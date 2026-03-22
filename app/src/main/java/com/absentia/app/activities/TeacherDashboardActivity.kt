package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.absentia.app.adapters.ClassAdapter
import com.absentia.app.databinding.ActivityTeacherDashboardBinding
import com.absentia.app.models.ClassRoom
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.ClassState
import com.absentia.app.viewmodels.ClassViewModel

class TeacherDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeacherDashboardBinding
    private val classViewModel: ClassViewModel by viewModels()
    private lateinit var session: SessionManager
    private lateinit var classAdapter: ClassAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherDashboardBinding.inflate(layoutInflater)
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
                val intent = Intent(this, ClassDetailActivity::class.java)
                intent.putExtra("class", classRoom)
                startActivity(intent)
            },
            onClassLongClick = { classRoom -> confirmDeleteClass(classRoom) }
        )
        binding.rvClasses.apply {
            layoutManager = LinearLayoutManager(this@TeacherDashboardActivity)
            adapter = classAdapter
        }
    }

    private fun loadClasses() {
        classViewModel.getTeacherClasses(session.getUserId()).observe(this) { classes ->
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
        binding.fabCreateClass.setOnClickListener {
            showCreateClassDialog()
        }
    }

    private fun showCreateClassDialog() {
        val dialog = com.absentia.app.dialogs.CreateClassDialog(session.getUserId(), session.getUserName()) { name, div, branch, year ->
            classViewModel.createClass(name, div, session.getUserId(), session.getUserName(), branch, year)
        }
        dialog.show(supportFragmentManager, "create_class")
    }

    private fun confirmDeleteClass(classRoom: ClassRoom) {
        AlertDialog.Builder(this)
            .setTitle("Delete Class")
            .setMessage("Delete '${classRoom.name}'? This cannot be undone.")
            .setPositiveButton("Delete") { _, _ -> classViewModel.deleteClass(classRoom) }
            .setNegativeButton("Cancel", null)
            .show()
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
        val items = arrayOf("Settings", "Need Help?", "About Us", "Logout")
        AlertDialog.Builder(this)
            .setTitle("Menu")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> startActivity(Intent(this, SettingsActivity::class.java))
                    1 -> toast("For support, email: support@absentia.app")
                    2 -> toast("ABSENTIA v1.0 — Smart Attendance System")
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
