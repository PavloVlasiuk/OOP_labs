package com.example.sixthlab_2

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(private val matrix: Array<IntArray>) :
    RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.matrix_element, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val itemWidth = screenWidth / matrix.size

        val layoutParams = holder.textView.layoutParams
        layoutParams.width = itemWidth
        layoutParams.height = itemWidth

        val row = position / matrix.size
        val col = position % matrix.size
        val item = matrix[row][col].toString()
        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return matrix.size * matrix.size
    }
}
