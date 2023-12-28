package com.example.sixthlab_3

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDeterminant()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        showDeterminant()
    }

    private fun showDeterminant() {
        findViewById<LinearLayout>(R.id.linear_layout).post {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val determinant = clipboard.primaryClip?.getItemAt(0)?.text.toString()

            val determinantView = findViewById<TextView>(R.id.determinant_view)
            determinantView.text = determinant
        }
    }
}