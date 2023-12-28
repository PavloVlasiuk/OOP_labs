package com.example.sixthlab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var n: EditText
    private lateinit var min: EditText
    private lateinit var max: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n = findViewById(R.id.n)
        min = findViewById(R.id.min)
        max = findViewById(R.id.max)
        onButtonClick()
    }

    private fun onButtonClick() {
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            if (isValidData()) {
                startSixthLab2()
            }
        }
    }

    private fun isValidData(): Boolean {
        when("") {
            n.text.toString() -> {
                Toast.makeText(this, "n cannot be empty", Toast.LENGTH_SHORT).show()
                return false
            }

            min.text.toString() -> {
                Toast.makeText(this, "min cannot be empty", Toast.LENGTH_SHORT).show()
                return false
            }

            max.text.toString() -> {
                Toast.makeText(this, "max cannot be empty", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun startSixthLab2() {
        val intent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            putExtra("n", n.text.toString().toInt())
            putExtra("min", min.text.toString().toInt())
            putExtra("max", max.text.toString().toInt())
        }
        intent.setClassName("com.example.sixthlab_2", "com.example.sixthlab_2.MainActivity")

        startActivity(intent)
    }
}