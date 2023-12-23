package com.example.fourthlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import com.example.fourthlab.shapes.CubeShape
import com.example.fourthlab.shapes.EllipseShape
import com.example.fourthlab.shapes.LineOOShape
import com.example.fourthlab.shapes.LineShape
import com.example.fourthlab.shapes.PointShape
import com.example.fourthlab.shapes.RectangleShape

class MainActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var canvasView: CanvasView
    private lateinit var myEditor: MyEditor
    private lateinit var buttons: Array<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        canvasView = findViewById(R.id.canvas_view)
        myEditor = canvasView.myEditor

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
            findViewById(R.id.ellipse_button),
            findViewById(R.id.cube_button),
            findViewById(R.id.line_with_circles_button)
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
                myEditor.start(PointShape())
            }

            getString(R.string.line_title) -> {
                setActiveMode(buttons[1])
                actionBar.title = title
                myEditor.start(LineShape())
            }

            getString(R.string.rect_title) -> {
                setActiveMode(buttons[2])
                actionBar.title = title
                myEditor.start(RectangleShape())
            }

            getString(R.string.ellipse_title) -> {
                setActiveMode(buttons[3])
                actionBar.title = title
                myEditor.start(EllipseShape())
            }

            getString(R.string.cube_title) -> {
                setActiveMode(buttons[4])
                actionBar.title = title
                myEditor.start(CubeShape())
            }

            getString(R.string.line_with_circles_title) -> {
                setActiveMode(buttons[5])
                actionBar.title = title
                myEditor.start(LineOOShape())
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