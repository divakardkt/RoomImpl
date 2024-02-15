package com.sabquiz.roomimpl.data.model

import androidx.room.Entity

@Entity(primaryKeys = ["studentName","studentName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName: String
)