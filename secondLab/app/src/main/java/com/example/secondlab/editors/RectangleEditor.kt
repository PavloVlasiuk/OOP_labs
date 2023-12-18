package com.example.secondlab.editors

import com.example.secondlab.shapes.RectangleShape
import com.example.secondlab.shapes.Shape

class RectangleEditor(
    private var shapesList: MutableList<Shape> = mutableListOf()
) : Editor() {
    private var rectangleShape: Shape = RectangleShape()

    override fun onTouchDown(x: Float, y: Float) {
        rectangleShape.showTrail()
        rectangleShape.setStartCoords(x, y)
    }

    override fun onMove(x: Float, y: Float) {
        rectangleShape.setEndCoords(x, y)
        shapesList.add(rectangleShape)
    }

    override fun onTouchUp() {
        rectangleShape.hideTrail()
        rectangleShape = RectangleShape()
    }
}