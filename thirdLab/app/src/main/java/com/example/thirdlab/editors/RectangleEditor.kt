package com.example.thirdlab.editors

import com.example.thirdlab.shapes.RectangleShape
import com.example.thirdlab.shapes.Shape

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