package com.example.secondlab.shapes

import android.graphics.Canvas

class LineShape : Shape() {
    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}