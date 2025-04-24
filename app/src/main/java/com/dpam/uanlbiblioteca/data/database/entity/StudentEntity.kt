package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.dpam.uanlbiblioteca.domain.model.StudentModel


@Entity(
    indices = [
        Index(value = ["email"], unique = true),
        Index(value = ["enrollment_number"], unique = true),
        Index(value = ["major_id"]), // Se recomienda para claves foráneas
        Index(value = ["campus_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = MajorEntity::class,
            parentColumns = ["id"],
            childColumns = ["major_id"]
        ),
        ForeignKey(
            entity = CampusEntity::class,
            parentColumns = ["id"],
            childColumns = ["campus_id"]
        )
    ]
)
data class StudentEntity(
    @PrimaryKey val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "profile_image_url") val profileImageUrl: String,
    @ColumnInfo(name = "enrollment_number") val enrollmentNumber: String,
    @ColumnInfo(name = "major_id") val majorId: Long,
    @ColumnInfo(name = "campus_id") val campusId: Long,
)

data class StudentWithDetails(
    @Embedded val student: StudentEntity,
    @Relation(
        parentColumn = "major_id",
        entityColumn = "id"
    )
    val major: MajorEntity,
    @Relation(
        parentColumn = "campus_id",
        entityColumn = "id"
    )
    val campus: CampusEntity
) {
    fun asDomain() = StudentModel(
        id = student.id,
        name = student.name,
        email = student.email,
        major = major.name,
        campus = campus.name,
        enrollmentNumber = student.enrollmentNumber,
        profileURL = student.profileImageUrl,
    )
}
