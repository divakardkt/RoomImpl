package com.sabquiz.roomimpl.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class SchoolAndDirector(

    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)