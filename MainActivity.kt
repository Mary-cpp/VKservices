package com.example.vkservices

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var sList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sList = findViewById(R.id.services_list)
        sList.layoutManager = LinearLayoutManager(baseContext)

        parseJson()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun parseJson() {

        // create Retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        // create service
        val service: JsonApi = retrofit.create(JsonApi::class.java)

        // Define scope & create a Coroutine
        CoroutineScope(Dispatchers.IO).launch{
            val response = service.getServices()

            // Changing CoroutineContext
            withContext(Dispatchers.Main){
                if (
                    response.isSuccessful
                ) {
                    val items = response.body()
                    if (items!= null) {
                        sList.apply {
                            ServicesRecyclerAdapter(items)
                            sList.adapter!!.notifyDataSetChanged()
                        }
                        repeat(items.count()){

                            // Logging
                            val name = items[it].name ?: "N/A"
                            Log.d("name: ", name)

                            val description = items[it].description ?: "N/A"
                            Log.d("description: ", description)

                            val icon = items[it].iconUrl ?: "N/A"
                            Log.d("icon: ", icon)

                            val url = items[it].serviceUrl ?: "N/A"
                            Log.d("url: ", url)
                        }
                    }
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }
    }
}