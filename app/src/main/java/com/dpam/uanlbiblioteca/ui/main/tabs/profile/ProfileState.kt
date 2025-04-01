package com.dpam.uanlbiblioteca.ui.main.tabs.profile

import com.dpam.uanlbiblioteca.domain.model.StudentModel

data class ProfileState(
    val student: StudentModel = StudentModel(
        name = "Diegeishon",
        email = "go.diego@uanl.mx",
        major = "Lic. en Historia",
        campus = "Facultad de Filosofia y Letras",
        enrollmentNumber = "4499796",
        profileURL = "https://pbs.twimg.com/profile_images/1540139703982243843/aCZ0X-kY_400x400.jpg"
    ),
)
