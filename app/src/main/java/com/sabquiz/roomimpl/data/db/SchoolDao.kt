package com.sabquiz.roomimpl.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sabquiz.roomimpl.data.model.Director
import com.sabquiz.roomimpl.data.model.School
import com.sabquiz.roomimpl.data.model.SchoolAndDirector
import com.sabquiz.roomimpl.data.model.SchoolWithStudents
import com.sabquiz.roomimpl.data.model.Student
import com.sabquiz.roomimpl.data.model.StudentSubjectCrossRef
import com.sabquiz.roomimpl.data.model.StudentWithSubjects
import com.sabquiz.roomimpl.data.model.Subject
import com.sabquiz.roomimpl.data.model.SubjectWithStudents

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName =:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName=:schoolName")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName =:subjectName")
    suspend fun getStudentsOfSubject(subjectName:String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM Student WHERE studentName =:studentName")
    suspend fun getSubjectsOfStudent(studentName:String): List<StudentWithSubjects>


}