package com.example.shetkarisheva

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SoilAdapter (private val context: Context, private val soilList: List<Soil>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return soilList.size
    }

    override fun getItem(position: Int): Any {
        return soilList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.soil_item, null)
        } else {
            view = convertView
        }

        val country = getItem(position) as Soil

        val countryNameTextView = view.findViewById<TextView>(R.id.soilName)
        val countryAboutTextView = view.findViewById<TextView>(R.id.soilAbout)

        countryNameTextView.text = country.name
        countryAboutTextView.text = country.about

        return view
    }
}
