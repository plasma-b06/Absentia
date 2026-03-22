package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.absentia.app.adapters.ClassAdapter
import com.absentia.app.databinding.ActivityStudentDashboardBinding
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.ClassState
import com.absentia.app.viewmodels.ClassViewModel

class StudentDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDashboardBinding
    private val classViewModel: ClassViewModel by viewModels()
    private lateinit var session: SessionManager
    private lateinit var classAdapter: ClassAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        setupToolbar()
        setupRecyclerView()
        loadClasses()
        setupFab()
        setupObserver()
    }

    private fun setupToolbar() {
        binding.tvWelcome.text = "Hello, ${session.getUserName().split(" ").first()} 👋"
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.btnMenu.setOnClickListener { showMenu() }
    }

    private fun setupRecyclerView() {
        classAdapter = ClassAdapter(
            onClassClick = { classRoom ->
                val intent = Intent(this, AttendanceHistoryActivity::class.java)
                intent.putExtra("class", classRoom)
                intent.putExtra("studentId", session.getUserId())
                startActivity(intent)
            },
            onClassLongClick = { }
        )
        binding.rvClasses.apply {
            layoutManager = LinearLayoutManager(this@StudentDashboardActivity)
            adapter = classAdapter
        }
    }

    private fun loadClasses() {
        classViewModel.getStudentClasses(session.getUserId()).observe(this) { classes ->
            if (classes.isEmpty()) {
                binding.tvEmpty.visible()
                binding.rvClasses.gone()
            } else {
                binding.tvEmpty.gone()
                binding.rvClasses.visible()
                classAdapter.submitList(classes)
            }
        }
    }

    private fun setupFab() {
        binding.fabJoinClass.setOnClickListener {
            showJoinClassDialog()
        }
    }

    private fun showJoinClassDialog() {
        val dialog = com.absentia.app.dialogs.JoinClassDialog { code ->
            classViewModel.joinClass(code, session.getUserId())
        }
        dialog.show(supportFragmentManager, "join_class")
    }

    private fun setupObserver() {
        classViewModel.classState.observe(this) { state ->
            when (state) {
                is ClassState.Success -> { toast(state.message); classViewModel.resetState() }
                is ClassState.Error -> { toast(state.message); classViewModel.resetState() }
                else -> {}
            }
        }
    }

    private fun showMenu() {
        val items = arrayOf("Scan QR Code", "My Attendance", "Settings", "Logout")
        AlertDialog.Builder(this)
            .setTitle("Menu")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> startActivity(Intent(this, ScanQRActivity::class.java))
                    1 -> startActivity(Intent(this, AttendanceHistoryActivity::class.java)
                            .apply { putExtra("studentId", session.getUserId()) })
                    2 -> startActivity(Intent(this, SettingsActivity::class.java))
                    3 -> confirmLogout()
                }
            }.show()
    }

    private fun confirmLogout() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Logout") { _, _ ->
                session.logout()
                startActivity(Intent(this, LoginActivity::class.java)
                    .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK })
            }
            .setNegativeButton("Cancel", null).show()
    }
}
