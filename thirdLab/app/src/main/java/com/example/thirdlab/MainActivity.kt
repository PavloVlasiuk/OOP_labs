package com.example.thirdlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var canvasView: CanvasView
    private lateinit var buttons: Array<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        canvasView = findViewById(R.id.canvas_view)

        initButtonsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onOptionsSelected(item.title)

        return super.onOptionsItemSelected(item)
    }

    private fun initButtonsMenu() {
        buttons = arrayOf(
            findViewById(R.id.point_button),
            findViewById(R.id.line_button),
            findViewById(R.id.rectangle_button),
            findViewById(R.id.ellipse_button)
        )

        buttons.forEach {
            it.setOnClickListener {
                onOptionsSelected(it.contentDescription)
            }
        }
    }

    private fun onOptionsSelected(title: CharSequence?): Boolean {
        when (title) {
            getString(R.string.point_title) -> {
                setActiveMode(buttons[0])
                actionBar.title = title
                canvasView.setPointEditor()
            }

            getString(R.string.line_title) -> {
                setActiveMode(buttons[1])
                actionBar.title = title
                canvasView.setLineEditor()
            }

            getString(R.string.rect_title) -> {
                setActiveMode(buttons[2])
                actionBar.title = title
                canvasView.setRectangleEditor()
            }

            getString(R.string.ellipse_title) -> {
                setActiveMode(buttons[3])
                actionBar.title = title
                canvasView.setEllipseEditor()
            }
        }
        return true
    }

    private fun setActiveMode(button: ImageButton) {
        setInactiveMode()
        button.drawable.setTint(getColor(R.color.smoke_green))
        button.tag = true
    }

    private fun setInactiveMode() {
        buttons.forEach {
            it.drawable.setTint(getColor(R.color.black))
        }
    }
}