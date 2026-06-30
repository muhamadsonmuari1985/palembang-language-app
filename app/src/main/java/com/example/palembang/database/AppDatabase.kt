package com.example.palembang.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.palembang.model.Vocabulary
import com.example.palembang.model.Quiz
import com.example.palembang.model.FavoriteVocabulary

@Database(
    entities = [Vocabulary::class, Quiz::class, FavoriteVocabulary::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun quizDao(): QuizDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "palembang_language.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update

@Dao
interface VocabularyDao {
    @Query("SELECT * FROM vocabulary")
    suspend fun getAllVocabulary(): List<Vocabulary>

    @Query("SELECT * FROM vocabulary WHERE category = :category")
    suspend fun getVocabularyByCategory(category: String): List<Vocabulary>

    @Query("SELECT * FROM vocabulary WHERE word LIKE '%' || :searchQuery || '%' OR translation LIKE '%' || :searchQuery || '%'")
    suspend fun searchVocabulary(searchQuery: String): List<Vocabulary>

    @Insert
    suspend fun insertVocabulary(vocabulary: Vocabulary)

    @Update
    suspend fun updateVocabulary(vocabulary: Vocabulary)

    @Query("SELECT * FROM vocabulary WHERE id = :id")
    suspend fun getVocabularyById(id: Int): Vocabulary?
}

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    suspend fun getAllQuiz(): List<Quiz>

    @Query("SELECT * FROM quiz WHERE category = :category")
    suspend fun getQuizByCategory(category: String): List<Quiz>
}

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite_vocabulary ORDER BY savedAt DESC")
    suspend fun getAllFavorites(): List<FavoriteVocabulary>

    @Query("SELECT * FROM favorite_vocabulary WHERE category = :category ORDER BY savedAt DESC")
    suspend fun getFavoritesByCategory(category: String): List<FavoriteVocabulary>

    @Insert
    suspend fun addFavorite(favorite: FavoriteVocabulary)

    @Delete
    suspend fun removeFavorite(favorite: FavoriteVocabulary)

    @Query("SELECT COUNT(*) FROM favorite_vocabulary WHERE vocabularyId = :vocabularyId")
    suspend fun isFavorite(vocabularyId: Int): Int

    @Query("DELETE FROM favorite_vocabulary WHERE vocabularyId = :vocabularyId")
    suspend fun deleteFavoriteByVocabularyId(vocabularyId: Int)
}