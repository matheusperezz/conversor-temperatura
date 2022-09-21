package com.example.conversordetemperatura

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conversordetemperatura.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var resultBinding : ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(resultBinding.root)

        val result = intent.getDoubleExtra("DEGREE", 0.0)
        val label = intent.getStringExtra("LABEL")

        val tvResult = resultBinding.tvDegreeResultActivity
        tvResult.text = "${result}${label}"

        val btnCloseActivity = resultBinding.btnCloseResultActivity
        btnCloseActivity.setOnClickListener {
            finish()
        }


    }
}