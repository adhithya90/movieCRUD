package com.adhi.moviecrud.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "movies_tbl")
data class Movie(
    @PrimaryKey(autoGenerate = true)  val id: Int = 0,
    val title: String
)

