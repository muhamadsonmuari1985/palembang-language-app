package com.example.palembang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_vocabulary")
data class FavoriteVocabulary(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val vocabularyId: Int,
    val word: String,
    val translation: String,
    val pronunciation: String,
    val example: String,
    val category: String,
    val savedAt: Long = System.currentTimeMillis()
)