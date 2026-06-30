package com.example.palembang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String,
    val category: String
)

data class QuizResult(
    val quizId: Int,
    val userAnswer: String,
    val isCorrect: Boolean
)