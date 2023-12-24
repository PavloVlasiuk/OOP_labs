package com.example.fifthlab.shapes

import android.graphics.Canvas

class PointShape : Shape() {
    override var name: String = "Крапка"

    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        canvas.drawPoint(startX, startY, paint)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        canvas.drawPoint(startX, startY, paint)
    }

    override fun createInstance(): Shape {
        return PointShape()
    }
}