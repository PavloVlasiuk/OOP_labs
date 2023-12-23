package com.example.fourthlab.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint

abstract class Shape {
    protected var startX: Float = 0f
    protected var startY: Float = 0f
    protected var endX: Float = 0f
    protected var endY: Float = 0f

    private var trail: Boolean = false

    protected var paint: Paint = Paint().apply {
        isAntiAlias = true
        strokeWidth = 10f
    }

    abstract fun drawTrail(canvas: Canvas)

    abstract fun draw(canvas: Canvas)

    abstract fun createInstance(): Shape

    protected fun setStrokeStyle() {
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.pathEffect = null
    }

    protected fun setFillStyle(x: Int, y: Int, z: Int) {
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(x, y, z)
    }

    protected fun setTrailStyle() {
        paint.style = Paint.Style.STROKE
        paint.pathEffect = DashPathEffect(floatArrayOf(30f, 20f), 0f)
    }

    fun setStartCoords(x: Float, y: Float) {
        startX = x
        startY = y
    }

    fun setEndCoords(x: Float, y: Float) {
        endX = x
        endY = y
    }

    fun showTrail() {
        trail = true
    }

    fun hideTrail() {
        trail = false
    }

    fun getTrailStatus(): Boolean {
        return trail
    }
}