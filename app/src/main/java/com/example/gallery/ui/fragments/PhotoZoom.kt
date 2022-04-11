package com.example.gallery.ui.fragments

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.models.Resultt

class PhotoZoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_zoom)

        val imge = findViewById<ImageView>(R.id.imageZoom)
        val oytim:String= intent.getSerializableExtra("t1") as String
        Glide.with(this).load(oytim).into(imge)
    }
}