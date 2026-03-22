package com.absentia.app.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.absentia.app.databinding.ActivityScanQrBinding
import com.absentia.app.repository.AbsentiaRepository
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.AttendanceState
import com.absentia.app.viewmodels.AttendanceViewModel
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import kotlinx.coroutines.launch

class ScanQRActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScanQrBinding
    private val viewModel: AttendanceViewModel by viewModels()
    private lateinit var session: SessionManager
    private var scanning = true
    private lateinit var repo: AbsentiaRepository

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) startScanning() else { toast("Camera permission required"); finish() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanQrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)
        repo = (application as com.absentia.app.AbsentiaApp).repository

        binding.btnBack.setOnClickListener { finish() }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
            startScanning()
        } else {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }

        setupObserver()
    }

    private fun startScanning() {
        binding.barcodeScanner.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                if (!scanning) return
                result?.text?.let { content ->
                    scanning = false
                    binding.barcodeScanner.pause()
                    markAttendance(content)
                }
            }
        })
    }

    private fun markAttendance(qrContent: String) {
        lifecycleScope.launch {
            val student = repo.getUserById(session.getUserId())
            if (student != null) {
                viewModel.scanAndMarkAttendance(qrContent, student)
            } else {
                toast("User session error. Please login again.")
                finish()
            }
        }
    }

    private fun setupObserver() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is AttendanceState.Loading -> binding.progressBar.visible()
                is AttendanceState.MarkedSuccess -> {
                    binding.progressBar.gone()
                    binding.tvResult.text = state.message
                    binding.layoutResult.visible()
                    binding.barcodeScanner.gone()
                    toast(state.message)
                    binding.btnDone.setOnClickListener { finish() }
                    viewModel.resetState()
                }
                is AttendanceState.Error -> {
                    binding.progressBar.gone()
                    toast(state.message)
                    scanning = true
                    binding.barcodeScanner.resume()
                    viewModel.resetState()
                }
                else -> binding.progressBar.gone()
            }
        }
    }

    override fun onResume() { super.onResume(); if (scanning) binding.barcodeScanner.resume() }
    override fun onPause() { super.onPause(); binding.barcodeScanner.pause() }
}
