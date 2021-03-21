package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight
import kotlinx.android.synthetic.main.fragment_sleep_quality.view.*
import kotlinx.android.synthetic.main.list_item_sleep_night.view.*

class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * Make the view instance and bind it to adapter
     * Pass in the XML layout for the view, and the parent view group for the view.
     * The third, boolean, argument is attachToRoot. This argument needs to be false,
     * because RecyclerView adds this item to the view hierarchy for you when it's time.
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    /**
     * Replacing the display contents
     * */
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED)
        } else {
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.textView.text = item.sleepQuality.toString()
    }

    /**
     * RecyclerView needs to know how many items the adapter has for it to display,
     * and it does that by calling getItemCount()
     * */
    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sleepLength: TextView = itemView.sleep_length
        val quality: TextView = itemView.quality_string
        val qualityImage: ImageView = itemView.quality_image
    }
}