package com.example.thirdlab.editors

import com.example.thirdlab.shapes.LineShape
import com.example.thirdlab.shapes.Shape

class LineEditor(
    private var shapesList: MutableList<Shape> = mutableListOf()
) : Editor() {
    private var lineShape: Shape = LineShape()

    override fun onTouchDown(x: Float, y: Float) {
        lineShape.showTrail()
        lineShape.setStartCoords(x, y)
    }

    override fun onMove(x: Float, y: Float) {
        lineShape.setEndCoords(x, y)
        shapesList.add(lineShape)
    }

    override fun onTouchUp() {
        lineShape.hideTrail()
        lineShape = LineShape()
    }
}