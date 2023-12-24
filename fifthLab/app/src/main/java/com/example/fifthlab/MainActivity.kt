package com.example.fifthlab

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.fifthlab.shapes.CubeShape
import com.example.fifthlab.shapes.EllipseShape
import com.example.fifthlab.shapes.LineOOShape
import com.example.fifthlab.shapes.LineShape
import com.example.fifthlab.shapes.PointShape
import com.example.fifthlab.shapes.RectangleShape

class MainActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var canvasView: CanvasView
    private lateinit var myEditor: MyEditor
    private lateinit var buttons: Array<ImageButton>
    private lateinit var myTable: MyTable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        canvasView = findViewById(R.id.canvas_view)
        myEditor = canvasView.myEditor

        initButtonsMenu()
        myTable = MyTable()
        myEditor.setTable(myTable)
        supportFragmentManager.beginTransaction().replace(R.id.table_container, myTable).commit()
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

            getString(R.string.table_title) -> {
                setTableVisibility()
            }

            getString(R.string.save_file_title) -> {
                onSaveOption()
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

    private fun setTableVisibility() {
        val tableContainer = findViewById<LinearLayout>(R.id.table_container)
        if (tableContainer.visibility == View.GONE) {
            tableContainer.visibility = View.VISIBLE
        } else {
            tableContainer.visibility = View.GONE
        }
    }

    private fun onSaveOption() {
        val shapes = myEditor.getShapes()
        var data = ""
        shapes.forEach {
            data += it.getShapeData().joinToString("   ")
            data += "\n"
        }

        createSaveDialog(data)
    }

    private fun createSaveDialog(data: String) {
        val fileManager = FileManager(this)
        val inputFileName = EditText(this)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Зберегти файл")
        builder.setView(inputFileName)
        builder.setNegativeButton("Відміна") { dialog, id ->
            dialog.cancel()
        }
        builder.setPositiveButton("Зберегти") { dialog, id ->
            val fileName = inputFileName.text.toString()
            fileManager.writeFile(fileName, data)
            Toast.makeText(this, "Data saved to $fileName file", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }
}