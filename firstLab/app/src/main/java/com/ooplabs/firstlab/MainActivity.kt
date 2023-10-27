package com.ooplabs.firstlab

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), OnClickListenerInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.work1)
            .setOnClickListener {
                Work1().show(supportFragmentManager, "work1")
            }

        findViewById<Button>(R.id.work2)
            .setOnClickListener {
                Work2_1().show(supportFragmentManager, "work2_1")
            }
    }

    override fun onPositiveClick(value: String?, dialogIdentifier: Int) {
        if (dialogIdentifier == R.string.work1Yes) {
            val textView = findViewById<TextView>(R.id.mainTextView)
            textView.text = value
        } else if (dialogIdentifier == R.string.work2_1Next) {
            Work2_2().show(supportFragmentManager, "work2_2")
        }
    }

    override fun onNegativeClick(dialogIdentifier: Int) {
        if (dialogIdentifier == R.string.work1No) {
            val textView = findViewById<TextView>(R.id.mainTextView)
            textView.text = ""
        }
    }

    override fun onNeutralClick() {
        Work2_1().show(supportFragmentManager, "work2_1")
    }
}