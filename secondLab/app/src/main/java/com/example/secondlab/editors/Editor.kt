package com.example.secondlab.editors

abstract class Editor {
    abstract fun onTouchDown(x: Float, y: Float)
    abstract fun onMove(x: Float, y: Float)
    abstract fun onTouchUp()
}