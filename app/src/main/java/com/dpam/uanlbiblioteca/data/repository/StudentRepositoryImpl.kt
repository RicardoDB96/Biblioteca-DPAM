package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.CampusDao
import com.dpam.uanlbiblioteca.data.database.dao.MajorDao
import com.dpam.uanlbiblioteca.data.database.dao.StudentDao
import com.dpam.uanlbiblioteca.domain.model.StudentModel
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository

class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val majorDao: MajorDao,
    private val campusDao: CampusDao
) : StudentRepository {
    override suspend fun save(student: StudentModel) {
        studentDao.deleteAllStudents()

        val majorId = majorDao.getMajorIdByName(majorName = student.major)?.id
        val campusId = campusDao.getCampusIdByName(campusName = student.campus)?.id

        if (majorId != null && campusId != null) {
            studentDao.insertStudent(student.asEntity(majorId = majorId, campusId = campusId))
        }
    }

    override suspend fun getStudent(): StudentModel? =
        studentDao.getStudentWithDetails()?.asDomain()
}