package com.absentia.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.absentia.app.databinding.ItemSessionBinding
import com.absentia.app.models.AttendanceSession

class SessionAdapter(
    private val onClick: (AttendanceSession) -> Unit
) : ListAdapter<AttendanceSession, SessionAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemSessionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AttendanceSession) {
            binding.tvSubject.text = item.subject
            binding.tvTimeSlot.text = item.timeSlot
            binding.tvDate.text = item.date
            binding.tvStatus.text = if (item.isActive) "ACTIVE" else "ENDED"
            binding.tvStatus.setTextColor(
                if (item.isActive) binding.root.context.getColor(android.R.color.holo_green_dark)
                else binding.root.context.getColor(android.R.color.darker_gray)
            )
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class DiffCallback : DiffUtil.ItemCallback<AttendanceSession>() {
        override fun areItemsTheSame(a: AttendanceSession, b: AttendanceSession) = a.id == b.id
        override fun areContentsTheSame(a: AttendanceSession, b: AttendanceSession) = a == b
    }
}
