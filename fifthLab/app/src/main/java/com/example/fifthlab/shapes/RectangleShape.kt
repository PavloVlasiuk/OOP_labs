package com.example.fifthlab.shapes

import android.graphics.Canvas

class RectangleShape : Shape() {
    override var name: String = "Прямокутник"

    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        canvas.drawRect(startX, startY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setFillStyle(247, 235, 5)
        canvas.drawRect(startX, startY, endX, endY, paint)

        setStrokeStyle()
        canvas.drawRect(startX, startY, endX, endY, paint)
    }

    override fun createInstance(): Shape {
        return RectangleShape()
    }
}