package com.example.palembang.database

import android.content.Context
import com.example.palembang.model.Vocabulary
import com.example.palembang.model.Quiz
import com.example.palembang.model.FavoriteVocabulary

class DatabaseHelper(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val vocabularyDao = db.vocabularyDao()
    private val quizDao = db.quizDao()
    private val favoriteDao = db.favoriteDao()

    // Vocabulary Methods
    suspend fun getAllVocabulary(): List<Vocabulary> {
        return vocabularyDao.getAllVocabulary()
    }

    suspend fun getVocabularyByCategory(category: String): List<Vocabulary> {
        return vocabularyDao.getVocabularyByCategory(category)
    }

    suspend fun searchVocabulary(query: String): List<Vocabulary> {
        return vocabularyDao.searchVocabulary(query)
    }

    suspend fun getVocabularyById(id: Int): Vocabulary? {
        return vocabularyDao.getVocabularyById(id)
    }

    // Quiz Methods
    suspend fun getAllQuiz(): List<Quiz> {
        return quizDao.getAllQuiz()
    }

    suspend fun getQuizByCategory(category: String): List<Quiz> {
        return quizDao.getQuizByCategory(category)
    }

    // Favorite Methods
    suspend fun getAllFavorites(): List<FavoriteVocabulary> {
        return favoriteDao.getAllFavorites()
    }

    suspend fun getFavoritesByCategory(category: String): List<FavoriteVocabulary> {
        return favoriteDao.getFavoritesByCategory(category)
    }

    suspend fun addFavorite(favorite: FavoriteVocabulary) {
        favoriteDao.addFavorite(favorite)
    }

    suspend fun removeFavorite(favorite: FavoriteVocabulary) {
        favoriteDao.removeFavorite(favorite)
    }

    suspend fun isFavorite(vocabularyId: Int): Boolean {
        return favoriteDao.isFavorite(vocabularyId) > 0
    }

    suspend fun deleteFavoriteByVocabularyId(vocabularyId: Int) {
        favoriteDao.deleteFavoriteByVocabularyId(vocabularyId)
    }

    companion object {
        fun getInitialVocabulary(): List<Vocabulary> {
            return listOf(
                Vocabulary(
                    word = "Mak Cik",
                    translation = "Ibu/Kakak Perempuan",
                    pronunciation = "Mak Chik",
                    example = "Mak cik aku yang paling cantik",
                    category = "Keluarga",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Emak",
                    translation = "Ibu",
                    pronunciation = "E-mak",
                    example = "Emak sudah memasak nasi goreng",
                    category = "Keluarga",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Pak Uda",
                    translation = "Ayah",
                    pronunciation = "Pak U-da",
                    example = "Pak uda pergi ke pasar",
                    category = "Keluarga",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Anak Bere",
                    translation = "Anak Laki-laki",
                    pronunciation = "Anak Be-re",
                    example = "Anak bere saya sudah sekolah",
                    category = "Keluarga",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Pagi",
                    translation = "Pagi",
                    pronunciation = "Pa-gi",
                    example = "Selamat pagi semua",
                    category = "Waktu",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Siang",
                    translation = "Siang",
                    pronunciation = "Si-ang",
                    example = "Ayo makan siang",
                    category = "Waktu",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Malam",
                    translation = "Malam",
                    pronunciation = "Ma-lam",
                    example = "Selamat malam teman",
                    category = "Waktu",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Nasi",
                    translation = "Nasi",
                    pronunciation = "Na-si",
                    example = "Nasi goreng palembang enak",
                    category = "Makanan",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Pempek",
                    translation = "Pempek (Makanan khas Palembang)",
                    pronunciation = "Pem-pek",
                    example = "Pempek kapal selam paling terkenal",
                    category = "Makanan",
                    audioUrl = null
                ),
                Vocabulary(
                    word = "Cuko",
                    translation = "Kuah Asam untuk Pempek",
                    pronunciation = "Cu-ko",
                    example = "Cuko pempek ini pedas",
                    category = "Makanan",
                    audioUrl = null
                )
            )
        }

        fun getInitialQuiz(): List<Quiz> {
            return listOf(
                Quiz(
                    question = "Apa arti 'Mak Cik' dalam bahasa Palembang?",
                    optionA = "Ayah",
                    optionB = "Ibu/Kakak Perempuan",
                    optionC = "Nenek",
                    optionD = "Kakak Laki-laki",
                    correctAnswer = "Ibu/Kakak Perempuan",
                    category = "Keluarga"
                ),
                Quiz(
                    question = "Makanan khas Palembang yang paling terkenal adalah?",
                    optionA = "Satay",
                    optionB = "Rendang",
                    optionC = "Pempek",
                    optionD = "Soto Banjar",
                    correctAnswer = "Pempek",
                    category = "Makanan"
                ),
                Quiz(
                    question = "'Pak Uda' dalam bahasa Palembang berarti?",
                    optionA = "Paman",
                    optionB = "Kakak Laki-laki",
                    optionC = "Ayah",
                    optionD = "Kakek",
                    correctAnswer = "Ayah",
                    category = "Keluarga"
                ),
                Quiz(
                    question = "Kuah asam untuk pempek disebut?",
                    optionA = "Bumbu",
                    optionB = "Cuko",
                    optionC = "Sambal",
                    optionD = "Saus",
                    correctAnswer = "Cuko",
                    category = "Makanan"
                ),
                Quiz(
                    question = "'Pagi' dalam bahasa Palembang pronunciation-nya?",
                    optionA = "Puh-gi",
                    optionB = "Pa-gee",
                    optionC = "Pa-gi",
                    optionD = "Peh-gi",
                    correctAnswer = "Pa-gi",
                    category = "Waktu"
                )
            )
        }
    }
}