package com.absentia.app.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.absentia.app.adapters.AttendanceRecordAdapter
import com.absentia.app.adapters.SessionAttendanceAdapter
import com.absentia.app.databinding.ActivityAttendanceHistoryBinding
import com.absentia.app.models.ClassRoom
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.gone
import com.absentia.app.utils.visible
import com.absentia.app.viewmodels.AttendanceViewModel

class AttendanceHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAttendanceHistoryBinding
    private val viewModel: AttendanceViewModel by viewModels()
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttendanceHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        binding.btnBack.setOnClickListener { finish() }

        val sessionId = intent.getIntExtra("sessionId", -1)
        val sessionName = intent.getStringExtra("sessionName")
        val studentId = intent.getIntExtra("studentId", session.getUserId())
        val classRoom = intent.getParcelableExtra<ClassRoom>("class")

        when {
            sessionId != -1 -> loadSessionAttendance(sessionId, sessionName ?: "Attendance")
            classRoom != null -> loadStudentClassAttendance(studentId, classRoom)
            else -> loadStudentAllAttendance(studentId)
        }
    }

    private fun loadSessionAttendance(sessionId: Int, title: String) {
        binding.tvTitle.text = title
        val adapter = SessionAttendanceAdapter()
        binding.rvAttendance.layoutManager = LinearLayoutManager(this)
        binding.rvAttendance.adapter = adapter
        viewModel.getSessionAttendance(sessionId).observe(this) { records ->
            binding.tvSubtitle.text = "${records.size} students present"
            if (records.isEmpty()) { binding.tvEmpty.visible(); binding.rvAttendance.gone() }
            else { binding.tvEmpty.gone(); binding.rvAttendance.visible(); adapter.submitList(records) }
        }
    }

    private fun loadStudentClassAttendance(studentId: Int, classRoom: ClassRoom) {
        binding.tvTitle.text = classRoom.name
        binding.tvSubtitle.text = "Division: ${classRoom.division}"
        val adapter = AttendanceRecordAdapter()
        binding.rvAttendance.layoutManager = LinearLayoutManager(this)
        binding.rvAttendance.adapter = adapter
        viewModel.getStudentAttendance(studentId).observe(this) { records ->
            val filtered = records.filter { it.classId == classRoom.id }
            if (filtered.isEmpty()) { binding.tvEmpty.visible(); binding.rvAttendance.gone() }
            else { binding.tvEmpty.gone(); binding.rvAttendance.visible(); adapter.submitList(filtered) }
        }
    }

    private fun loadStudentAllAttendance(studentId: Int) {
        binding.tvTitle.text = "All Attendance"
        val adapter = AttendanceRecordAdapter()
        binding.rvAttendance.layoutManager = LinearLayoutManager(this)
        binding.rvAttendance.adapter = adapter
        viewModel.getStudentAttendance(studentId).observe(this) { records ->
            binding.tvSubtitle.text = "${records.size} total records"
            if (records.isEmpty()) { binding.tvEmpty.visible(); binding.rvAttendance.gone() }
            else { binding.tvEmpty.gone(); binding.rvAttendance.visible(); adapter.submitList(records) }
        }
    }
}
