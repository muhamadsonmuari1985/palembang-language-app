package com.example.palembang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vocabulary")
data class Vocabulary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val translation: String,
    val pronunciation: String,
    val example: String,
    val category: String,
    val imageUrl: String? = null,
    val audioUrl: String? = null,
    val isFavorite: Boolean = false
)