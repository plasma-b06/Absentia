package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.absentia.app.adapters.SessionAdapter
import com.absentia.app.databinding.ActivityClassDetailBinding
import com.absentia.app.models.ClassRoom
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.AttendanceState
import com.absentia.app.viewmodels.AttendanceViewModel

class ClassDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClassDetailBinding
    private val attendanceViewModel: AttendanceViewModel by viewModels()
    private lateinit var session: SessionManager
    private lateinit var classRoom: ClassRoom
    private lateinit var sessionAdapter: SessionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        classRoom = intent.getParcelableExtra("class")!!

        setupToolbar()
        setupInfo()
        setupRecyclerView()
        loadSessions()
        setupObserver()

        binding.btnGenerateQR.setOnClickListener {
            val intent = Intent(this, GenerateQRActivity::class.java)
            intent.putExtra("class", classRoom)
            startActivity(intent)
        }
    }

    private fun setupToolbar() {
        binding.btnBack.setOnClickListener { finish() }
        binding.tvTitle.text = classRoom.name
    }

    private fun setupInfo() {
        binding.tvDivision.text = "Division: ${classRoom.division}"
        binding.tvBranch.text = "Branch: ${classRoom.branch}"
        binding.tvJoinCode.text = "Join Code: ${classRoom.joinCode}"
    }

    private fun setupRecyclerView() {
        sessionAdapter = SessionAdapter { session ->
            val intent = Intent(this, AttendanceHistoryActivity::class.java)
            intent.putExtra("sessionId", session.id)
            intent.putExtra("sessionName", "${session.subject} — ${session.date}")
            startActivity(intent)
        }
        binding.rvSessions.apply {
            layoutManager = LinearLayoutManager(this@ClassDetailActivity)
            adapter = sessionAdapter
        }
    }

    private fun loadSessions() {
        attendanceViewModel.getTeacherSessions(session.getUserId()).observe(this) { sessions ->
            val filtered = sessions.filter { it.classId == classRoom.id }
            if (filtered.isEmpty()) {
                binding.tvEmpty.visible()
                binding.rvSessions.gone()
            } else {
                binding.tvEmpty.gone()
                binding.rvSessions.visible()
                sessionAdapter.submitList(filtered)
            }
        }
    }

    private fun setupObserver() {
        attendanceViewModel.state.observe(this) { state ->
            when (state) {
                is AttendanceState.Error -> { toast(state.message); attendanceViewModel.resetState() }
                else -> {}
            }
        }
    }
}
