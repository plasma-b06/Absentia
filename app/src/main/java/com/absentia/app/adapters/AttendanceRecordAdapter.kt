package com.absentia.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.absentia.app.databinding.ItemAttendanceRecordBinding
import com.absentia.app.models.AttendanceRecord

class AttendanceRecordAdapter : ListAdapter<AttendanceRecord, AttendanceRecordAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemAttendanceRecordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AttendanceRecord) {
            binding.tvSubject.text = item.subject
            binding.tvDate.text = item.date
            binding.tvTimeSlot.text = item.timeSlot
            binding.tvStatus.text = item.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemAttendanceRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class DiffCallback : DiffUtil.ItemCallback<AttendanceRecord>() {
        override fun areItemsTheSame(a: AttendanceRecord, b: AttendanceRecord) = a.id == b.id
        override fun areContentsTheSame(a: AttendanceRecord, b: AttendanceRecord) = a == b
    }
}
