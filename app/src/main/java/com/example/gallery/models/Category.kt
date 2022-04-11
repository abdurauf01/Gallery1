package com.example.gallery.models

import java.io.Serializable

data class Category(
    val pretty_slug: String,
    val slug: String
): Serializable