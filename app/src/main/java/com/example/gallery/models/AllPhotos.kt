package com.example.gallery.models

import java.io.Serializable

data class AllPhotos(
    val results: List<Resultt>,
    val total: Int,
    val total_pages: Int): Serializable