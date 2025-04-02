package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = ["id"],
            childColumns = ["campus_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index(value = ["campus_id"])]
)
data class LibraryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val location: String,
    val hours: String?,
    val contactInfo: String?,
    @ColumnInfo(name = "campus_id") val campusId: Long?
)
