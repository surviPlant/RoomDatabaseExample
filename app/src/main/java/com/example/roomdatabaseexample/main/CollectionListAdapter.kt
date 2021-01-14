package com.example.roomdatabaseexample.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseexample.R

class CollectionListAdapter(var content:ArrayList<PlantCollection>):RecyclerView.Adapter<CollectionListAdapter.ViewHolder>()
{

    // just for the case we need to switch between pictures
    private val statusDrawables = arrayOf(R.drawable.ic_dummy_collection, R.drawable.ic_launcher_background)
    private lateinit var context: Context

    // Variables
    private lateinit var mListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent,false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCollectionName.text = "${content[position].name}"
    }

    override fun getItemCount(): Int {
        return content.size
    }


    class ViewHolder(itemView: View, var mListenenr: OnItemClickListener):RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener
    {
        var tvCollectionName:TextView = itemView.findViewById(R.id.rv_tv_collectionName)
        var imageCollection:ImageView = itemView.findViewById(R.id.rv_imageCollection)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            if(mListenenr!=null) {
                mListenenr.setOnClickListener(adapterPosition)
            }
        }

        override fun onLongClick(v: View?): Boolean {

            if(mListenenr!=null){
                mListenenr.setOnLongClickListener(adapterPosition)
            }

            return true
        }
    }

    interface OnItemClickListener
    {
        fun setOnClickListener(pos: Int)
        fun setOnLongClickListener(pos: Int)
    }

    fun setOnItemClickListener(mListener: OnItemClickListener)
    {
        this.mListener = mListener
    }

}