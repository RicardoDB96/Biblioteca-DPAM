package com.dpam.uanlbiblioteca.domain.model

import com.dpam.uanlbiblioteca.data.database.entity.StudentEntity

data class StudentModel(
    val name: String = "",
    val email: String = "",
    val major: String = "",
    val campus: String = "",
    val enrollmentNumber: String = "",
    val profileURL: String = "",
) {
    fun asEntity(majorId: Long, campusId: Long) = StudentEntity(
        name = name,
        email = email,
        profileImageUrl = profileURL,
        enrollmentNumber = enrollmentNumber,
        majorId = majorId,
        campusId = campusId
    )
}
