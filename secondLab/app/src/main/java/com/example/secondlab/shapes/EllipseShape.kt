package com.example.secondlab.shapes

import android.graphics.Canvas

class EllipseShape : Shape() {
    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        canvas.drawOval(startX, startY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        canvas.drawOval(startX, startY, endX, endY, paint)
    }
}