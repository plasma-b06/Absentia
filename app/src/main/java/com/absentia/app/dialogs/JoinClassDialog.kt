package com.absentia.app.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.absentia.app.databinding.DialogJoinClassBinding
import com.absentia.app.utils.toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class JoinClassDialog(
    private val onJoin: (code: String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogJoinClassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogJoinClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancel.setOnClickListener { dismiss() }
        binding.btnJoin.setOnClickListener {
            val code = binding.etJoinCode.text.toString().trim().uppercase()
            if (code.length != 6) { toast("Enter a valid 6-character join code"); return@setOnClickListener }
            onJoin(code)
            dismiss()
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
