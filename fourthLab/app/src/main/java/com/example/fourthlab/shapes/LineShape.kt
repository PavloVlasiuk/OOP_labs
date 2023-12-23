package com.example.fourthlab.shapes

import android.graphics.Canvas

open class LineShape : Shape() {
    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun createInstance(): Shape {
        return LineShape()
    }
}