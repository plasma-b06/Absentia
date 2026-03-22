package com.absentia.app.activities

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.databinding.ActivityGenerateQrBinding
import com.absentia.app.models.ClassRoom
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.AttendanceState
import com.absentia.app.viewmodels.AttendanceViewModel

class GenerateQRActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenerateQrBinding
    private val viewModel: AttendanceViewModel by viewModels()
    private lateinit var session: SessionManager
    private lateinit var classRoom: ClassRoom
    private var activeSessionId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerateQrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)
        classRoom = intent.getParcelableExtra("class")!!

        setupToolbar()
        setupSpinners()
        setupObserver()

        binding.btnGenerateQR.setOnClickListener {
            val date = binding.tvSelectedDate.text.toString()
            val timeSlot = binding.spinnerTimeSlot.selectedItem.toString()
            val subject = binding.etSubject.text.toString().trim()
            if (subject.isBlank()) { toast("Enter subject name"); return@setOnClickListener }
            viewModel.createSession(classRoom.id, classRoom.name, session.getUserId(), timeSlot, subject)
        }

        binding.btnEndSession.setOnClickListener {
            if (activeSessionId != -1) confirmEndSession()
            else toast("No active session")
        }

        binding.btnShareQR.setOnClickListener {
            toast("Share QR feature — screenshot and share the QR code")
        }
    }

    private fun setupToolbar() {
        binding.btnBack.setOnClickListener {
            if (activeSessionId != -1) confirmEndSession() else finish()
        }
        binding.tvTitle.text = classRoom.name
    }

    private fun setupSpinners() {
        val timeSlots = arrayOf(
            "8:00 - 9:00", "9:00 - 10:00", "9:40 - 10:30",
            "10:30 - 11:30", "11:30 - 12:30", "12:30 - 1:30",
            "1:30 - 2:30", "2:30 - 3:30", "3:30 - 4:30"
        )
        val adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_spinner_item, timeSlots)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTimeSlot.adapter = adapter

        binding.tvSelectedDate.text = com.absentia.app.utils.getCurrentDate()

        binding.tvSelectedDate.setOnClickListener {
            val cal = java.util.Calendar.getInstance()
            android.app.DatePickerDialog(this, { _, y, m, d ->
                binding.tvSelectedDate.text = String.format("%02d %s %d", d,
                    arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")[m], y)
            }, cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), cal.get(java.util.Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun setupObserver() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is AttendanceState.Loading -> {
                    binding.progressBar.visible()
                    binding.btnGenerateQR.isEnabled = false
                }
                is AttendanceState.SessionCreated -> {
                    binding.progressBar.gone()
                    activeSessionId = state.session.id
                    showQR(state.qrBitmap)
                    binding.tvSessionInfo.text = "${state.session.subject} | ${state.session.timeSlot} | ${state.session.date}"
                    binding.tvSessionInfo.visible()
                    binding.btnGenerateQR.isEnabled = false
                    binding.btnEndSession.isEnabled = true
                    toast("QR Code generated! Session is active.")
                }
                is AttendanceState.Error -> {
                    binding.progressBar.gone()
                    binding.btnGenerateQR.isEnabled = true
                    toast(state.message)
                    viewModel.resetState()
                }
                else -> {
                    binding.progressBar.gone()
                    binding.btnGenerateQR.isEnabled = true
                }
            }
        }
    }

    private fun showQR(bitmap: Bitmap) {
        binding.layoutQr.visible()
        binding.ivQrCode.setImageBitmap(bitmap)
        binding.layoutForm.gone()
    }

    private fun confirmEndSession() {
        AlertDialog.Builder(this)
            .setTitle("End Session")
            .setMessage("End the attendance session? Students won't be able to scan after this.")
            .setPositiveButton("End Session") { _, _ ->
                viewModel.endSession(activeSessionId)
                toast("Session ended")
                finish()
            }
            .setNegativeButton("Keep Active", null).show()
    }

    override fun onBackPressed() {
        if (activeSessionId != -1) confirmEndSession()
        else super.onBackPressed()
    }
}
