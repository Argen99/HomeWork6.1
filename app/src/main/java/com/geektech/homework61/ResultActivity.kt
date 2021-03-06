package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.homework61.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = getIntent()
        val result: String? = intent.getStringExtra(MainActivity.keyMaRa)
        binding.editTextResult.setText(result)

        initClickers()
    }

    private fun initClickers() {
        binding.btnReturn.setOnClickListener {
            val text: String = binding.editTextResult.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, R.string.toast_isEmpty, Toast.LENGTH_SHORT).show()
            } else {
                val data = Intent()
                data.putExtra(keyRaMa, text)
                setResult(RESULT_OK, data)
                finish()
            }
        }
    }

    companion object {
        const val keyRaMa: String = "key_result"
    }
}