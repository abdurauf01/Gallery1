package com.example.gallery.ui.fragments

import android.content.Intent
import android.os.Bundle
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


class Technology : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_technology, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_technology)
        val adapter = PhotosAdapter()
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.res.observe(requireActivity()) {
            adapter.submitItem(it)
        }
        viewModel.error.observe(requireActivity()) {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView.adapter = adapter
        viewModel.getPhotoFromRep("technology")
        adapter.setOytimClickListener {
            val intent = Intent(requireActivity(), PhotoZoom::class.java)
            intent.putExtra("t1", it.urls.small)
            startActivity(intent)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = Technology()
    }
}