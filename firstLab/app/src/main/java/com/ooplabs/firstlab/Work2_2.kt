package com.ooplabs.firstlab

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class Work2_2 : DialogFragment() {
    private lateinit var listener: OnClickListenerInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)

            builder.setTitle(R.string.work2_2Title)
                .setPositiveButton(R.string.work2_2Yes) { _, _ ->
                    listener.onPositiveClick(null, R.string.work2_2Yes)
                }
                .setNeutralButton(R.string.work2_2Prev) { _, _ ->
                    listener.onNeutralClick()
                }
                .setNegativeButton(R.string.work2_2Discard) { _, _ ->
                    listener.onNegativeClick(R.string.work2_2Discard)
                }

            builder.create()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnClickListenerInterface
    }
}