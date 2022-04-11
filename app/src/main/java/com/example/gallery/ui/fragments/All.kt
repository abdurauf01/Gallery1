package com.example.gallery.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.gallery.adapters.PhotosAdapter
import com.example.gallery.models.Resultt
import com.example.gallery.viewmodel.MainViewModel


class All : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotosAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.all_images)
        adapter = PhotosAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.res.observe(requireActivity()) {
            adapter.submitItem(it)
            Log.d("ALL", it.toString())
        }
        viewModel.error.observe(requireActivity()) {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView.adapter = adapter
        val map = HashMap<String, String>()
        map["query"] = "animals"
        map["query"] = "nature"
        map["query"] = "technology"
        map["query"] = "new"
        installData(map)
        adapter.setOytimClickListener {
            val intent = Intent(requireActivity(), PhotoZoom::class.java)
            intent.putExtra("t1", it.urls.small)
            startActivity(intent)
        }
    }

    private fun installData(query: Map<String, String>) {
        viewModel.getPhotosFromRep(query)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    companion object {
        fun newInstance() = All()
    }

}