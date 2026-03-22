package com.absentia.app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.databinding.ActivityManageClassBinding

class ManageClassActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener { finish() }
    }
}
