package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        binding.btnSend.setOnClickListener {
            val text: String = binding.editTextMain.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, R.string.toast_isEmpty, Toast.LENGTH_SHORT).show()
            } else {
                intentLauncher.launch(Intent(this, ResultActivity::class.java).apply {
                    putExtra(keyMaRa, text)
                })
            }
        }
    }

    private val intentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK)
                binding.editTextMain.setText(result.data?.getStringExtra(ResultActivity.keyRaMa))
        }

    companion object {
        const val keyMaRa: String = "main_key"
    }
}

