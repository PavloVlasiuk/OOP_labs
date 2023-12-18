package com.example.secondlab

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.secondlab.editors.Editor
import com.example.secondlab.editors.EllipseEditor
import com.example.secondlab.editors.LineEditor
import com.example.secondlab.editors.PointEditor
import com.example.secondlab.editors.RectangleEditor
import com.example.secondlab.shapes.Shape

class CanvasView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var motionEventX = 0f
    private var motionEventY = 0f
    private var currentEditor: Editor? = null

    private var shapesList: MutableList<Shape> = mutableListOf()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (shape in shapesList) {
            if (shape.getTrailStatus()) shape.drawTrail(canvas) else shape.draw(canvas)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionEventX = event.x
        motionEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentEditor?.onTouchDown(motionEventX, motionEventY)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                currentEditor?.onMove(motionEventX, motionEventY)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                currentEditor?.onTouchUp()
                invalidate()
            }
        }
        return true
    }

    fun setPointEditor() {
        currentEditor = PointEditor(shapesList)
    }

    fun setLineEditor() {
        currentEditor = LineEditor(shapesList)
    }

    fun setRectangleEditor() {
        currentEditor = RectangleEditor(shapesList)
    }

    fun setEllipseEditor() {
        currentEditor = EllipseEditor(shapesList)
    }
}