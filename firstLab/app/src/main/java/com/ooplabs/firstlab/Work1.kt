package com.ooplabs.firstlab

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class Work1 : DialogFragment() {
    private lateinit var listener: OnClickListenerInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val dialogView: View = inflater.inflate(R.layout.seek_bar_dialog, null)
            val seekBar = dialogView.findViewById<SeekBar>(R.id.seekBar)
            val textView = dialogView.findViewById<TextView>(R.id.seekBarTextView)

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    textView.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })

            builder.setView(dialogView)
                .setTitle(R.string.work1Title)
                .setPositiveButton(R.string.work1Yes) { _, _ ->
                    listener.onPositiveClick(textView.text.toString(), R.string.work1Yes)
                }
                .setNegativeButton(R.string.work1No) { _, _ ->
                    listener.onNegativeClick(R.string.work1No)
                }

            builder.create()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnClickListenerInterface
    }
}