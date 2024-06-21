package com.example.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.R
import com.example.msgshareapp.models.Hobby
import com.example.msgshareapp.showToast

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
        var currhobby: Hobby? = null
        var currPos: Int = 0
        init {
            itemView.setOnClickListener{
//                Toast.makeText(context, currhobby!!.title + " Clicked", Toast.LENGTH_SHORT).show()
                context.showToast(currhobby!!.title + " Clicked")
            }
            imageShare.setOnClickListener {
                val message : String = "My hobby is " + currhobby!!.title
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, message)
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }
        fun bind(hobby: Hobby?, position: Int) {
            txvTitle.text = hobby!!.title
            this.currhobby=hobby
            this.currPos=position

        }
    }
}