package com.example.gallery.models

import java.io.Serializable

data class Tag(
    val source: Source,
    val title: String,
    val type: String
): Serializable