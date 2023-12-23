package com.example.fourthlab.shapes

import android.graphics.Canvas

class LineOOShape : LineShape() {
    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        drawLineOO(canvas)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        setFillStyle(0, 0, 0)
        drawLineOO(canvas)
    }

    override fun createInstance(): Shape {
        return LineOOShape()
    }

    private fun drawLineOO(canvas: Canvas) {
        val radius = 40f
        canvas.drawLine(startX, startY, endX, endY, paint)
        canvas.drawCircle(startX, startY, radius, paint)
        canvas.drawCircle(endX, endY, radius, paint)
    }
}