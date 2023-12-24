package com.example.fifthlab.shapes

import android.graphics.Canvas

open class LineShape : Shape() {
    override var name: String = "Лінія"

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