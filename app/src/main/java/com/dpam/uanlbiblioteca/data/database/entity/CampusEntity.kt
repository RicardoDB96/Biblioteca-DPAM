package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CampusEntity(
    @PrimaryKey val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String
)
