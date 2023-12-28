package com.example.sixthlab_2

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val matrixService = MatrixService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val matrix = getMatrix()
        showData(matrix)

        val determinant = matrixService.calculateDeterminant(matrix)
        onCalcButtonClick(determinant)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)

        val matrix = getMatrix()
        showData(matrix)

        val determinant = matrixService.calculateDeterminant(matrix)
        onCalcButtonClick(determinant)
    }

    private fun getMatrix(): Array<IntArray> {
        val n = intent!!.getIntExtra("n", 3)
        val min = intent.getIntExtra("min", 1)
        val max = intent.getIntExtra("max", 4)

        return matrixService.generateMatrix(n, min, max)
    }

    private fun showData(matrix: Array<IntArray>) {
        val matrixView = findViewById<RecyclerView>(R.id.matrix_view)
        matrixView.layoutManager = GridLayoutManager(this, matrix.size)
        matrixView.adapter = MyRecyclerAdapter(matrix)
    }

    private fun onCalcButtonClick(determinant: Int) {
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startSixthLab3(determinant)
        }
    }

    private fun startSixthLab3(determinant: Int) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("determinant", determinant.toString())
        clipboardManager.setPrimaryClip(clip)

        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.setClassName("com.example.sixthlab_3", "com.example.sixthlab_3.MainActivity")
        startActivity(intent)
    }
}