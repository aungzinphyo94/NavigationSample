package com.dandt.navsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.itemButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
//        val item = list.get(position)
        holder.button.text = list.get(position).toString()
        holder.button.setOnClickListener {
            val action = LetterFragmentDirections
                .actionLetterFragmentToWordFragment()
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}