package Adaptors

import Models.ListAppHorizontal
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chplay.R

class ListOfListItemAdaptor(val data: List<ListAppHorizontal>) : RecyclerView.Adapter<ListOfListItemAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.list_app_title)
        val app_rv = view.findViewById<RecyclerView>(R.id.app_rv)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listApp = data[position]
        val apps = listApp.listApp

        val listItemAdaptor = ListItemAdaptor(apps)
        holder.app_rv.layoutManager = LinearLayoutManager(holder.app_rv.context, LinearLayoutManager.HORIZONTAL, false )
        holder.app_rv.adapter = listItemAdaptor
        holder.title.text = listApp.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_application_layout, parent, false)
        return ViewHolder(view)
    }
}