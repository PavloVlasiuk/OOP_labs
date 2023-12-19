package com.example.thirdlab.shapes

import android.graphics.Canvas

class RectangleShape : Shape() {
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
}