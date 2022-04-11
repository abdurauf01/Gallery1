package com.example.gallery.models

import java.io.Serializable

data class TopicSubmissions(
    val monochrome: Monochrome,
    val texturepatterns: TexturesPatterns,
    val wallpapers: Wallpapers
): Serializable