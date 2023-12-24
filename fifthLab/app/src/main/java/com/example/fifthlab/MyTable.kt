package com.example.fifthlab

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.graphics.toColor

class MyTable : Fragment() {
    private lateinit var tableLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val table = inflater.inflate(R.layout.table_fragment, container, false)
        tableLayout = table.findViewById(R.id.table_layout)
        return table
    }

    fun addRow(shapeData: MutableList<String>) {
        val tableRaw = TableRow(context)

        for (value in shapeData) {
            val textView = TextView(context)
            textView.text = value
            textView.setTextColor(resources.getColor(R.color.black))
            textView.gravity = Gravity.CENTER
            tableRaw.addView(textView)
        }

        tableLayout.addView(tableRaw)
    }
}