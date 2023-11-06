package Adaptors

import Models.App
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chplay.R

class ListItemAdaptor(val apps: List<App>) :
    RecyclerView.Adapter<ListItemAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appImage = view.findViewById<ImageView>(R.id.app_image)
        val appName = view.findViewById<TextView>(R.id.app_name)
        val appRating = view.findViewById<TextView>(R.id.app_rating)
    }

    override fun getItemCount(): Int {
        return apps.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.application_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app: App = apps[position]

        holder.appImage.setImageResource(app.imageUrl)
        holder.appName.text = app.name
        holder.appRating.text = app.rating

    }
}