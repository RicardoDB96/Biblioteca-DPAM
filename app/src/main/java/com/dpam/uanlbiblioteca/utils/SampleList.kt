package com.dpam.uanlbiblioteca.utils

import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity

object SampleList {
    val faculties = listOf(
        CampusEntity(
            id = 1,
            name = "Facultad de Trabajo Social y Desarrollo Humano",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 2,
            name = "Facultad de Contaduría Pública y Administración",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 3,
            name = "Facultad de Filosofía y Letras",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 4,
            name = "Facultad de Derecho y Criminología",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 5,
            name = "Facultad de Arquitectura",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 6,
            name = "Facultad de Ingeniería Mecánica y Eléctrica",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 7,
            name = "Facultad de Ingeniería Civil",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 8,
            name = "Facultad de Ciencias Químicas",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 9,
            name = "Facultad de Ciencias Físico Matemáticas",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 10,
            name = "Facultad de Organización Deportiva",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 11,
            name = "Facultad de Ciencias Biológicas",
            address = "Campus Ciudad Universitaria, San Nicolás de los Garza, Nuevo León"
        ),
        CampusEntity(
            id = 12,
            name = "Facultad de Ciencias de la Comunicación",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 13,
            name = "Facultad de Música",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 14,
            name = "Facultad de Artes Escénicas",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 15,
            name = "Facultad de Artes Visuales",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 16,
            name = "Facultad de Ciencias Políticas y Relaciones Internacionales",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 17,
            name = "Facultad de Economía",
            address = "Campus Mederos, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 18,
            name = "Facultad de Medicina",
            address = "Campus Ciencias de la Salud, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 19,
            name = "Facultad de Odontología",
            address = "Campus Ciencias de la Salud, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 20,
            name = "Facultad de Enfermería",
            address = "Campus Ciencias de la Salud, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 21,
            name = "Facultad de Psicología",
            address = "Campus Ciencias de la Salud, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 22,
            name = "Facultad de Salud Pública y Nutrición",
            address = "Campus Ciencias de la Salud, Monterrey, Nuevo León"
        ),
        CampusEntity(
            id = 23,
            name = "Facultad de Agronomía",
            address = "Campus Ciencias Agropecuarias, General Escobedo, Nuevo León"
        ),
        CampusEntity(
            id = 24,
            name = "Facultad de Medicina Veterinaria y Zootecnia",
            address = "Campus Ciencias Agropecuarias, General Escobedo, Nuevo León"
        ),
        CampusEntity(
            id = 25,
            name = "Facultad de Ciencias de la Tierra",
            address = "Campus Linares, Linares, Nuevo León"
        ),
        CampusEntity(
            id = 26,
            name = "Facultad de Ciencias Forestales",
            address = "Campus Linares, Linares, Nuevo León"
        )
    )

    val majors = listOf(
        MajorEntity(id = 1, name = "Trabajo Social y Desarrollo Humano"),
        MajorEntity(id = 2, name = "Contaduría Pública y Administración"),
        MajorEntity(id = 3, name = "Filosofía y Letras"),
        MajorEntity(id = 4, name = "Derecho y Criminología"),
        MajorEntity(id = 5, name = "Arquitectura"),
        MajorEntity(id = 6, name = "Ingeniería Mecánica y Eléctrica"),
        MajorEntity(id = 7, name = "Ingeniería Civil"),
        MajorEntity(id = 8, name = "Ciencias Químicas"),
        MajorEntity(id = 9, name = "Ciencias Físico Matemáticas"),
        MajorEntity(id = 10, name = "Organización Deportiva"),
        MajorEntity(id = 11, name = "Ciencias Biológicas"),
        MajorEntity(id = 12, name = "Ciencias de la Comunicación"),
        MajorEntity(id = 13, name = "Música"),
        MajorEntity(id = 14, name = "Artes Escénicas"),
        MajorEntity(id = 15, name = "Artes Visuales"),
        MajorEntity(id = 16, name = "Ciencias Políticas y Relaciones Internacionales"),
        MajorEntity(id = 17, name = "Economía"),
        MajorEntity(id = 18, name = "Medicina"),
        MajorEntity(id = 19, name = "Odontología"),
        MajorEntity(id = 20, name = "Enfermería"),
        MajorEntity(id = 21, name = "Psicología"),
        MajorEntity(id = 22, name = "Salud Pública y Nutrición"),
        MajorEntity(id = 23, name = "Agronomía"),
        MajorEntity(id = 24, name = "Medicina Veterinaria y Zootecnia"),
        MajorEntity(id = 25, name = "Ciencias de la Tierra"),
        MajorEntity(id = 26, name = "Ciencias Forestales")
    )

    val books = listOf(
        BookEntity(
            id = 1,
            title = "Principios de Administración Financiera",
            author = "Lawrence J. Gitman",
            isbn = "9789701064080",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789701064080-L.jpg"
        ),
        BookEntity(
            id = 2,
            title = "Fundamentos de Derecho",
            author = "Juan Antonio Travieso",
            isbn = "9789875495293",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789875495293-L.jpg"
        ),
        BookEntity(
            id = 3,
            title = "Cálculo de una Variable",
            author = "James Stewart",
            isbn = "9789706864838",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789706864838-L.jpg"
        ),
        BookEntity(
            id = 4,
            title = "Introducción a la Psicología",
            author = "Charles G. Morris",
            isbn = "9786071502298",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786071502298-L.jpg"
        ),
        BookEntity(
            id = 5,
            title = "Biología",
            author = "Neil A. Campbell",
            isbn = "9788448164371",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788448164371-L.jpg"
        ),
        BookEntity(
            id = 6,
            title = "Ingeniería de Control Moderna",
            author = "Dorf Richard",
            isbn = "9788429145144",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788429145144-L.jpg"
        ),
        BookEntity(
            id = 7,
            title = "Estructuras de Datos y Algoritmos",
            author = "Alfred V. Aho, Jeffrey D. Ullman, John E. Hopcroft",
            isbn = "9788420527826",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420527826-L.jpg"
        ),
        BookEntity(
            id = 8,
            title = "Fundamentos de Química",
            author = "Raymond Chang",
            isbn = "9786073209768",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789701062968-L.jpg"
        ),
        BookEntity(
            id = 9,
            title = "Macroeconomía",
            author = "Rudiger Dornbusch, Stanley Fischer",
            isbn = "9786071507934",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786071507934-L.jpg"
        ),
        BookEntity(
            id = 10,
            title = "Arte y Percepción Visual",
            author = "Rudolf Arnheim",
            isbn = "9788449308224",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788449308224-L.jpg"
        ),
        BookEntity(
            id = 11,
            title = "Álgebra Lineal y sus Aplicaciones",
            author = "David C. Lay",
            isbn = "9788429172203",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788429172203-L.jpg"
        ),
        BookEntity(
            id = 12,
            title = "Química Orgánica",
            author = "Paula Yurkanis Bruice",
            isbn = "9786073207474",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786073207474-L.jpg"
        ),
        BookEntity(
            id = 13,
            title = "Inteligencia Artificial: Un Enfoque Moderno",
            author = "Stuart Russell, Peter Norvig",
            isbn = "9788490357198",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788490357198-L.jpg"
        ),
        BookEntity(
            id = 14,
            title = "Mecánica de Materiales",
            author = "Ferdinand P. Beer",
            isbn = "9780077687260",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9780077687260-L.jpg"
        ),
        BookEntity(
            id = 15,
            title = "Análisis Matemático",
            author = "Tom M. Apostol",
            isbn = "9789681626832",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789681626832-L.jpg"
        )
    )

    val categories = listOf(
        CategoryEntity(id = 1, name = "Administración"),
        CategoryEntity(id = 2, name = "Derecho"),
        CategoryEntity(id = 3, name = "Matemáticas"),
        CategoryEntity(id = 4, name = "Psicología"),
        CategoryEntity(id = 5, name = "Biología"),
        CategoryEntity(id = 6, name = "Ingeniería"),
        CategoryEntity(id = 7, name = "Programación"),
        CategoryEntity(id = 8, name = "Química"),
        CategoryEntity(id = 9, name = "Economía"),
        CategoryEntity(id = 10, name = "Arte"),
        CategoryEntity(id = 11, name = "Inteligencia Artificial"),
        CategoryEntity(id = 12, name = "Física")
    )

    val bookCategories = listOf(
        BookCategoryEntity(
            bookId = 1,
            categoryId = 1
        ),  // Principios de Administración Financiera → Administración
        BookCategoryEntity(bookId = 2, categoryId = 2),  // Fundamentos de Derecho → Derecho
        BookCategoryEntity(bookId = 3, categoryId = 3),  // Cálculo de una Variable → Matemáticas
        BookCategoryEntity(
            bookId = 4,
            categoryId = 4
        ),  // Introducción a la Psicología → Psicología
        BookCategoryEntity(bookId = 5, categoryId = 5),  // Biología → Biología
        BookCategoryEntity(
            bookId = 6,
            categoryId = 6
        ),  // Ingeniería de Control Moderna → Ingeniería
        BookCategoryEntity(
            bookId = 7,
            categoryId = 7
        ),  // Estructuras de Datos y Algoritmos → Programación
        BookCategoryEntity(bookId = 8, categoryId = 8),  // Fundamentos de Química → Química
        BookCategoryEntity(bookId = 8, categoryId = 9),
        BookCategoryEntity(bookId = 9, categoryId = 5),  // Macroeconomía → Economía
        BookCategoryEntity(bookId = 10, categoryId = 10), // Arte y Percepción Visual → Arte
        BookCategoryEntity(
            bookId = 11,
            categoryId = 3
        ), // Álgebra Lineal y sus Aplicaciones → Matemáticas
        BookCategoryEntity(bookId = 12, categoryId = 8), // Química Orgánica → Química
        BookCategoryEntity(bookId = 13, categoryId = 11), // Inteligencia Artificial → IA
        BookCategoryEntity(bookId = 14, categoryId = 6), // Mecánica de Materiales → Ingeniería
        BookCategoryEntity(bookId = 15, categoryId = 3) // Análisis Matemático → Matemáticas
    )

    val libraries = listOf(
        LibraryEntity(
            id = 1,
            name = "Biblioteca Central UANL",
            location = "San Nicolás de los Garza, NL",
            hours = "Lunes a Viernes: 8:00 - 20:00",
            contactInfo = "Tel: 81 8329 4000",
            campusId = 1
        ),
        LibraryEntity(
            id = 2,
            name = "Biblioteca de Ingeniería",
            location = "Facultad de Ingeniería Mecánica y Eléctrica",
            hours = "Lunes a Viernes: 9:00 - 18:00",
            contactInfo = "Tel: 81 8329 4000",
            campusId = 2
        ),
        LibraryEntity(
            id = 3,
            name = "Biblioteca de Medicina",
            location = "Facultad de Medicina",
            hours = "Lunes a Viernes: 8:00 - 17:00",
            contactInfo = "Tel: 81 8329 4000",
            campusId = 3
        ),
        LibraryEntity(
            id = 4,
            name = "Biblioteca de Ciencias Biológicas",
            location = "Facultad de Ciencias Biológicas",
            hours = "Lunes a Viernes: 8:00 - 20:00",
            contactInfo = "Tel: 81 8329 4000",
            campusId = 4
        ),
        LibraryEntity(
            id = 5,
            name = "Biblioteca de Arquitectura",
            location = "Facultad de Arquitectura",
            hours = "Lunes a Viernes: 9:00 - 18:00",
            contactInfo = "Tel: 81 8329 4000",
            campusId = 5
        )
    )

    val bookLibraries = listOf(
        BookLibraryEntity(bookId = 1, libraryId = 1),
        BookLibraryEntity(bookId = 3, libraryId = 2),
        BookLibraryEntity(bookId = 5, libraryId = 4),
        BookLibraryEntity(bookId = 7, libraryId = 2),
        BookLibraryEntity(bookId = 8, libraryId = 3, quantity = 2),
        BookLibraryEntity(bookId = 8, libraryId = 1, quantity = 3),
        BookLibraryEntity(bookId = 9, libraryId = 1),
        BookLibraryEntity(bookId = 10, libraryId = 5),
        BookLibraryEntity(bookId = 11, libraryId = 2),
        BookLibraryEntity(bookId = 13, libraryId = 1),
        BookLibraryEntity(bookId = 14, libraryId = 2),
        BookLibraryEntity(bookId = 15, libraryId = 1)
    )
}