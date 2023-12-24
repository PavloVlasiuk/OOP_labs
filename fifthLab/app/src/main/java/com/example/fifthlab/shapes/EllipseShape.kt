package com.example.fifthlab.shapes

import android.graphics.Canvas

class EllipseShape : Shape() {
    private var leftX: Float = 0f
    private var topY: Float = 0f

    override var name: String = "Еліпс"

    override fun drawTrail(canvas: Canvas) {
        setCenterCoords(startX, startY, endX, endY)
        setTrailStyle()
        canvas.drawOval(leftX, topY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setCenterCoords(startX, startY, endX, endY)
        setFillStyle(255, 255, 255)
        canvas.drawOval(leftX, topY, endX, endY, paint)

        setStrokeStyle()
        canvas.drawOval(leftX, topY, endX, endY, paint)
    }

    override fun createInstance(): Shape {
        return EllipseShape()
    }

    private fun setCenterCoords(startX: Float, startY: Float, endX: Float, endY: Float) {
        leftX = 2 * startX - endX
        topY = 2 * startY - endY
    }
}