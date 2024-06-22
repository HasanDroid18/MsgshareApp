package com.example.msgshareapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.bind(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txvTitle: TextView = itemView.findViewById(R.id.txvTitle)
        private val imageShare: ImageView = itemView.findViewById(R.id.imgShare)

        fun bind(hobby: Hobby?, position: Int) {
            txvTitle.text = hobby!!.title

            imageShare.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, hobby.title)
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }
    }
}