package com.absentia.app.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.absentia.app.databinding.DialogCreateClassBinding
import com.absentia.app.utils.toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateClassDialog(
    private val teacherId: Int,
    private val teacherName: String,
    private val onCreateClass: (name: String, division: String, branch: String, year: String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogCreateClassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogCreateClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCancel.setOnClickListener { dismiss() }
        binding.btnCreate.setOnClickListener {
            val name = binding.etClassName.text.toString().trim()
            val division = binding.etDivision.text.toString().trim()
            val branch = binding.etBranch.text.toString().trim()
            val year = binding.spinnerYear.selectedItem.toString()

            if (name.isBlank()) { toast("Enter class name"); return@setOnClickListener }
            if (division.isBlank()) { toast("Enter division"); return@setOnClickListener }

            onCreateClass(name, division, branch, year)
            dismiss()
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
