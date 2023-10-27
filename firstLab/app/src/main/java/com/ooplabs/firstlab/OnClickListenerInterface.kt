package com.ooplabs.firstlab

interface OnClickListenerInterface {
    fun onPositiveClick(value: String?, dialogIdentifier: Int)
    fun onNegativeClick(dialogIdentifier: Int)
    fun onNeutralClick()
}