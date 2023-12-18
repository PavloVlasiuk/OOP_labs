package com.example.secondlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar;
    private lateinit var canvasView: CanvasView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        canvasView = findViewById(R.id.canvas_view)

        actionBar.title = getString(R.string.line_title)
        canvasView.setLineEditor()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.point -> {
                actionBar.title = item.title
                canvasView.setPointEditor()
            }

            R.id.line -> {
                actionBar.title = item.title
                canvasView.setLineEditor()
            }

            R.id.rectangular -> {
                actionBar.title = item.title
                canvasView.setRectangleEditor()
            }

            R.id.ellipse -> {
                actionBar.title = item.title
                canvasView.setEllipseEditor()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}