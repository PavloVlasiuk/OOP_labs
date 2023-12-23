package com.example.fourthlab

import android.graphics.Canvas
import com.example.fourthlab.shapes.Shape

class MyEditor {
    private var shapesList: MutableList<Shape> = mutableListOf()
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
        currentShape = currentShape?.createInstance()
    }

    fun drawShape(canvas: Canvas) {
        for (shape in shapesList) {
            if (shape.getTrailStatus()) shape.drawTrail(canvas) else shape.draw(canvas)
        }
    }
}