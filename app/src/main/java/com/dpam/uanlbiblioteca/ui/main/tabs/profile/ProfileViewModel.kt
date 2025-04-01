package com.dpam.uanlbiblioteca.ui.main.tabs.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.model.StudentModel
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.MajorRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import com.dpam.uanlbiblioteca.utils.SampleList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val studentRepository: StudentRepository,
    private val majorRepository: MajorRepository,
    private val campusRepository: CampusRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            majorRepository.saveAllMajors(SampleList.majors)
            campusRepository.saveAllCampus(SampleList.faculties)

            studentRepository.save(
                StudentModel(
                    name = "Diegeishon",
                    email = "go.diego@uanl.mx",
                    major = "Filosofía y Letras",
                    campus = "Facultad de Filosofía y Letras",
                    enrollmentNumber = "43192296",
                    profileURL = "https://pbs.twimg.com/profile_images/1540139703982243843/aCZ0X-kY_400x400.jpg"
                )
            )

            studentRepository.getStudent()?.let { student ->
                _state.update { it.copy(student = student) }
            }
        }
    }
}