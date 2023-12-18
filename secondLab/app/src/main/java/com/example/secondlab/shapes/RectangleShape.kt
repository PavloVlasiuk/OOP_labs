package com.example.secondlab.shapes

import android.graphics.Canvas

class RectangleShape : Shape() {
    private var leftX: Float = 0f;
    private var topY: Float = 0f;

    override fun drawTrail(canvas: Canvas) {
        setCenterCoords(startX, startY, endX, endY)

        setFillStyle()
        canvas.drawRect(leftX, topY, endX, endY, paint)

        setTrailStyle()
        canvas.drawRect(leftX, topY, endX, endY, paint)
    }

    override fun draw(canvas: Canvas) {
        setCenterCoords(startX, startY, endX, endY)

        setFillStyle()
        canvas.drawRect(leftX, topY, endX, endY, paint)

        setStrokeStyle()
        canvas.drawRect(leftX, topY, endX, endY, paint)
    }

    private fun setCenterCoords(startX: Float, startY: Float, endX: Float, endY: Float) {
        leftX = 2 * startX - endX
        topY = 2 * startY - endY
    }
}