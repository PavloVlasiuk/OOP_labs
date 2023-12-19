package com.example.thirdlab.editors

import com.example.thirdlab.shapes.PointShape
import com.example.thirdlab.shapes.Shape

class PointEditor(
    private var shapesList: MutableList<Shape> = mutableListOf()
) : Editor() {
    private var pointShape: Shape = PointShape()

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