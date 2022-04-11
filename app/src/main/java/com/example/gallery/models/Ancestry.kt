package com.example.gallery.models

import java.io.Serializable

data class Ancestry(
    val category: Category,
    val type: Type
): Serializable