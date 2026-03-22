package com.absentia.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.absentia.app.databinding.ItemSessionAttendanceBinding
import com.absentia.app.models.AttendanceRecord

class SessionAttendanceAdapter : ListAdapter<AttendanceRecord, SessionAttendanceAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemSessionAttendanceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AttendanceRecord, pos: Int) {
            binding.tvIndex.text = "${pos + 1}"
            binding.tvStudentName.text = item.studentName
            binding.tvStatus.text = item.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemSessionAttendanceBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), position)

    class DiffCallback : DiffUtil.ItemCallback<AttendanceRecord>() {
        override fun areItemsTheSame(a: AttendanceRecord, b: AttendanceRecord) = a.id == b.id
        override fun areContentsTheSame(a: AttendanceRecord, b: AttendanceRecord) = a == b
    }
}
