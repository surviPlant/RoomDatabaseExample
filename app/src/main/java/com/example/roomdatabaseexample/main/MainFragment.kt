package com.example.roomdatabaseexample.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseexample.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private lateinit var rootView: View


    // Recycler View
    private lateinit var rv:RecyclerView
    private lateinit var adapter:CollectionListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private lateinit var content:ArrayList<PlantCollection>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_main, container, false)



        initRecyclerView()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initRecyclerView()
    {
        rv = rootView.findViewById(R.id.rv_collection)
        layoutManager = LinearLayoutManager(rootView.context,RecyclerView.VERTICAL,false)
//        val testContent = ArrayList<String>(List(25){""})
        content = ArrayList()
        content.add(PlantCollection(1,"testCollection1"))
        content.add(PlantCollection(2,"testCollection2"))
        adapter = CollectionListAdapter(content)
        rv.layoutManager = layoutManager
        rv.adapter = adapter

        rv.addItemDecoration(DividerItemDecoration(rv.context,layoutManager.orientation))

        adapter.setOnItemClickListener(object: CollectionListAdapter.OnItemClickListener{
            override fun setOnClickListener(pos: Int) {
                Toast.makeText(context,"${content[pos]} wurde geklickt", Toast.LENGTH_SHORT).show()
            }

            override fun setOnLongClickListener(pos: Int) {
                Toast.makeText(context,"${content[pos]} wurde lange geklickt", Toast.LENGTH_SHORT).show()
            }

        })

    }
}