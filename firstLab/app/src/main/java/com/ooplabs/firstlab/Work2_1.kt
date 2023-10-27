package com.ooplabs.firstlab

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class Work2_1 : DialogFragment() {
    private lateinit var listener: OnClickListenerInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)

            builder.setTitle(R.string.work2_1Title)
                .setPositiveButton(R.string.work2_1Next) { _, _ ->
                    listener.onPositiveClick(null, R.string.work2_1Next)
                }
                .setNegativeButton(R.string.work2_1Discard) { _, _ ->
                    listener.onNegativeClick(R.string.work2_1Discard)
                }

            builder.create()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnClickListenerInterface
    }
}