package com.example.fourthlab.shapes

import android.graphics.Canvas

class PointShape : Shape() {
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