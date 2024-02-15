package com.sabquiz.roomimpl.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sabquiz.roomimpl.data.model.Director
import com.sabquiz.roomimpl.data.model.School
import com.sabquiz.roomimpl.data.model.Student
import com.sabquiz.roomimpl.data.model.StudentSubjectCrossRef
import com.sabquiz.roomimpl.data.model.Subject

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ], version = 1, exportSchema = false
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(appContext: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    appContext.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).fallbackToDestructiveMigration()
                    .build().also {
                        INSTANCE=it
                    }
            }
        }
    }
}