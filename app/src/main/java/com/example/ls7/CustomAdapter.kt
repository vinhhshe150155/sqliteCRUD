package com.example.ls7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent




class CustomAdapter(private val itemList: List<Folder>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position];
        holder.tvId.text = item.id.toString()
        holder.tvName.text = item.name
        holder.tvDetail.text = item.detail
        holder.parentLayout.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra("folder", item)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvId : TextView = itemView.findViewById(R.id.tv_id)
        val tvName : TextView = itemView.findViewById(R.id.tv_name)
        val tvDetail : TextView = itemView.findViewById(R.id.tv_detail)
        val parentLayout  = itemView

    }
}