package com.example.secondlab.editors

import com.example.secondlab.shapes.PointShape
import com.example.secondlab.shapes.Shape

class PointEditor(
    private var shapesList: MutableList<Shape> = mutableListOf()
) : Editor() {
    private var pointShape = PointShape()

    override fun onTouchDown(x: Float, y: Float) {
        pointShape.setStartCoords(x, y)
    }

    override fun onMove(x: Float, y: Float) {
        pointShape.setEndCoords(x, y)
    }

    override fun onTouchUp() {
        shapesList.add(pointShape)
        pointShape = PointShape()
    }
}