package com.example.fifthlab

import android.graphics.Canvas
import androidx.fragment.app.Fragment
import com.example.fifthlab.shapes.Shape

class MyEditor {
    companion object {
        private var instance: MyEditor? = null

        fun getInstance(): MyEditor {
            if (instance == null) {
                instance = MyEditor()
            }
            return instance!!
        }
    }

    private var shapesList: MutableList<Shape> = mutableListOf()
    private var finishedShapes: MutableList<Shape> = mutableListOf()
    private lateinit var table: MyTable
    private var currentShape: Shape? = null

    fun start(shape: Shape) {
        currentShape = shape
    }

    fun onTouchDown(x: Float, y: Float) {
        currentShape?.showTrail()
        currentShape?.setStartCoords(x, y)
    }

    fun onMove(x: Float, y: Float) {
        currentShape?.setEndCoords(x, y)
        shapesList.add(currentShape!!)
    }

    fun onTouchUp() {
        currentShape?.hideTrail()
        finishedShapes.add(currentShape!!)
        table.addRow(currentShape!!.getShapeData())
        currentShape = currentShape?.createInstance()
    }

    fun drawShape(canvas: Canvas) {
        for (shape in shapesList) {
            if (shape.getTrailStatus()) shape.drawTrail(canvas) else shape.draw(canvas)
        }
    }

    fun setTable(table: MyTable) {
        this.table = table
    }

    fun getShapes(): MutableList<Shape> {
        return finishedShapes
    }
}