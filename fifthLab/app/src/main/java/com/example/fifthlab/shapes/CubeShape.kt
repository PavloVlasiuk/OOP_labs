package com.example.fifthlab.shapes

import android.graphics.Canvas
import kotlin.math.abs

class CubeShape : LineShape() {
    override var name: String = "Куб"

    override fun drawTrail(canvas: Canvas) {
        setTrailStyle()
        drawCube(canvas)
    }

    override fun draw(canvas: Canvas) {
        setStrokeStyle()
        drawCube(canvas)
    }

    override fun createInstance(): Shape {
        return CubeShape()
    }

    private fun drawCube(canvas: Canvas) {
        val diff = abs(endX - startX) / 3
        val width = endX - startX
        canvas.drawRect(startX, startY, endX, endY, paint)
        canvas.drawRect(startX + diff, startY + diff, endX + diff, endY + diff, paint)
        canvas.drawLine(startX, startY, startX + diff, startY + diff, paint)
        canvas.drawLine(endX, endY, endX + diff, endY + diff, paint)
        canvas.drawLine(startX + width, startY, startX + width + diff, startY + diff, paint)
        canvas.drawLine(endX - width, endY, endX - width + diff, endY + diff, paint)
    }

}