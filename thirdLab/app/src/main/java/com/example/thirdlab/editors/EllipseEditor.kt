package com.example.thirdlab.editors

import com.example.thirdlab.shapes.EllipseShape
import com.example.thirdlab.shapes.Shape

class EllipseEditor(
    private var shapesList: MutableList<Shape> = mutableListOf()
) : Editor() {
    private var ellipseShape: Shape = EllipseShape()

    override fun onTouchDown(x: Float, y: Float) {
        ellipseShape.showTrail()
        ellipseShape.setStartCoords(x, y)
    }

    override fun onMove(x: Float, y: Float) {
        ellipseShape.setEndCoords(x, y)
        shapesList.add(ellipseShape)
    }

    override fun onTouchUp() {
        ellipseShape.hideTrail()
        ellipseShape = EllipseShape()
    }
}