package com.example.vkservices

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ServicePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_page)

        savedInstanceState?.getString("name")

        val icon = findViewById<ImageView>(R.id.service_icon_big)
        Picasso.get()
            .load(savedInstanceState?.getString("icon"))
            .error(R.mipmap.ic_launcher)
            .into(icon)
        val name = findViewById<TextView>(R.id.service_name_big)
        name.text = savedInstanceState?.getString("name")
        val description = findViewById<TextView>(R.id.service_description)
        description.text = savedInstanceState?.getString("desc")
        val url = findViewById<TextView>(R.id.service_url)
        url.text = savedInstanceState?.getString("url")
    }



}