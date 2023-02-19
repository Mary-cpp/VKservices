package com.example.vkservices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ServicesRecyclerAdapter(private val services: List<Service>?) :
    RecyclerView.Adapter<ServicesRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.service_icon)
        val name: TextView = itemView.findViewById(R.id.service_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_element,parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = services!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = services!![position].name ?: "N/A"
        Picasso.get()
            .load(services[position].serviceUrl)
            .error(R.drawable.ic_launcher_background)
            .into(holder.image)
    }
}