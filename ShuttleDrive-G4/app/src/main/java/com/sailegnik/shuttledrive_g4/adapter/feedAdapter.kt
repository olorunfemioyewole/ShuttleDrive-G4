package com.sailegnik.shuttledrive_g4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.data.feedback

class feedAdapter( private val context: Context,private val feedList: ArrayList<feedback>):
RecyclerView.Adapter<feedAdapter.ImageViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageModel = feedList[position]
        holder.tvFeed.text = imageModel.feedback

    }

    override fun getItemCount(): Int {
        return feedList.size
    }


    class ImageViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val tvFeed: TextView = itemView.findViewById(R.id.tvFeed)

    }


}