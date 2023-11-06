package com.example.chplay

import Adaptors.ListOfListItemAdaptor
import Models.App
import Models.ListAppHorizontal
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = intArrayOf(R.drawable.app1, R.drawable.app2, R.drawable.app3, R.drawable.app4, R.drawable.app5, R.drawable.app6, R.drawable.app7)
        var title = listOf<String>("App one", "App two", "App three", "App four", "App five", "App six", "App seven")
        var ratings = listOf<String>("1","2","3","4","5","2.5","3.5")

        val list_app_rv: RecyclerView = findViewById(R.id.list_app_rv)
        list_app_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )

        val apps = ArrayList<ListAppHorizontal>()
        for (i in 1..10) {
            val listApp = ArrayList<App>()
            for (i in 1..20) {
                var index = Random.nextInt(100)%7
                listApp.add(App(images[index], title[index], ratings[index]))
            }
            val listAppHorizontal = ListAppHorizontal("Category $i",listApp)
            apps.add(listAppHorizontal)
        }

        val appsAdaptor = ListOfListItemAdaptor(apps)

        list_app_rv.adapter = appsAdaptor
    }
}