package com.sabquiz.roomimpl.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn ="subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)
