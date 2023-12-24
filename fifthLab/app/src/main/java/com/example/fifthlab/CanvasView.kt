package com.example.fifthlab

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var motionEventX: Float = 0f
    private var motionEventY: Float = 0f

    var myEditor: MyEditor = MyEditor.getInstance()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        myEditor.drawShape(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionEventX = event.x
        motionEventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                myEditor.onTouchDown(motionEventX, motionEventY)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                myEditor.onMove(motionEventX, motionEventY)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                myEditor.onTouchUp()
                invalidate()
            }
        }
        return true
    }
}