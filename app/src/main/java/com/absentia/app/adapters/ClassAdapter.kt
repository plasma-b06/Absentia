package com.absentia.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.absentia.app.databinding.ItemClassBinding
import com.absentia.app.models.ClassRoom

class ClassAdapter(
    private val onClassClick: (ClassRoom) -> Unit,
    private val onClassLongClick: (ClassRoom) -> Unit
) : ListAdapter<ClassRoom, ClassAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemClassBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClassRoom) {
            binding.tvClassName.text = item.name
            binding.tvDivision.text = "Div: ${item.division}"
            binding.tvTeacher.text = item.teacherName
            binding.tvBranch.text = item.branch.ifBlank { "—" }
            binding.root.setOnClickListener { onClassClick(item) }
            binding.root.setOnLongClickListener { onClassLongClick(item); true }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemClassBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class DiffCallback : DiffUtil.ItemCallback<ClassRoom>() {
        override fun areItemsTheSame(a: ClassRoom, b: ClassRoom) = a.id == b.id
        override fun areContentsTheSame(a: ClassRoom, b: ClassRoom) = a == b
    }
}
