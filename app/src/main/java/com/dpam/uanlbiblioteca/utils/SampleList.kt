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
            isbn = "9786073209830",
            imageUrl = "https://covers.openlibrary.org/b/id/8259091-L.jpg"
        ),
        BookEntity(
            id = 2,
            title = "Fundamentos de Derecho",
            author = "Juan Antonio Travieso",
            isbn = "9789875495293",
            imageUrl = "https://covers.openlibrary.org/b/id/13738580-L.jpg"
        ),
        BookEntity(
            id = 3,
            title = "Cálculo de una Variable",
            author = "James Stewart",
            isbn = "9789706864838",
            imageUrl = "https://covers.openlibrary.org/b/id/7303031-L.jpg"
        ),
        BookEntity(
            id = 4,
            title = "Introducción a la Psicología",
            author = "Charles G. Morris",
            isbn = "9786071502298",
            imageUrl = "https://covers.openlibrary.org/b/id/6664038-L.jpg"
        ),
        BookEntity(
            id = 5,
            title = "Biología",
            author = "Neil A. Campbell",
            isbn = "9788448164371",
            imageUrl = "https://covers.openlibrary.org/b/id/5272061-L.jpg"
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
        ),
        BookEntity(
            id = 16,
            title = "Física Universitaria",
            author = "Hugh D. Young",
            isbn = "9786071506845",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786071506845-L.jpg"
        ),
        BookEntity(
            id = 17,
            title = "Contabilidad Financiera",
            author = "Jerry J. Weygandt",
            isbn = "9786071504568",
            imageUrl = "https://covers.openlibrary.org/b/id/8036062-L.jpg"
        ),
        BookEntity(
            id = 18,
            title = "Marketing",
            author = "Philip Kotler",
            isbn = "9786074424016",
            imageUrl = "https://covers.openlibrary.org/b/id/12166579-L.jpg"
        ),
        BookEntity(
            id = 19,
            title = "Derecho Constitucional Mexicano",
            author = "Felipe Tena Ramírez",
            isbn = "9789681617557",
            imageUrl = "https://covers.openlibrary.org/b/id/6319085-L.jpg"
        ),
        BookEntity(
            id = 20,
            title = "Psicología Social",
            author = "David G. Myers",
            isbn = "9786071507460",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786071507460-L.jpg"
        ),
        BookEntity(
            id = 21,
            title = "Química General",
            author = "Raymond Chang",
            isbn = "9786073205609",
            imageUrl = "https://covers.openlibrary.org/b/id/7282298-L.jpg"
        ),
        BookEntity(
            id = 22,
            title = "Microeconomía",
            author = "Paul A. Samuelson",
            isbn = "9789706860793",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789706860793-L.jpg"
        ),
        BookEntity(
            id = 23,
            title = "Historia del Arte",
            author = "Ernst Gombrich",
            isbn = "9788420689410",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420689410-L.jpg"
        ),
        BookEntity(
            id = 24,
            title = "Fundamentos de Física",
            author = "David Halliday",
            isbn = "9789681857816",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789681857816-L.jpg"
        ),
        BookEntity(
            id = 25,
            title = "Programación en C",
            author = "Brian W. Kernighan, Dennis M. Ritchie",
            isbn = "9788420536349",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420536349-L.jpg"
        ),
        BookEntity(
            id = 26,
            title = "El origen de las especies",
            author = "Charles Darwin",
            isbn = "9788491050296",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788491050296-L.jpg"
        ),
        BookEntity(
            id = 27,
            title = "Crítica de la razón pura",
            author = "Immanuel Kant",
            isbn = "9788420670975",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420670975-L.jpg"
        ),
        BookEntity(
            id = 28,
            title = "Historia de la filosofía occidental",
            author = "Bertrand Russell",
            isbn = "9788420688901",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420688901-L.jpg"
        ),
        BookEntity(
            id = 29,
            title = "La República",
            author = "Platón",
            isbn = "9788420602358",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420602358-L.jpg"
        ),
        BookEntity(
            id = 30,
            title = "Breve historia del tiempo",
            author = "Stephen Hawking",
            isbn = "9788497593797",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788497593797-L.jpg"
        ),
        BookEntity(
            id = 31,
            title = "Cosmos",
            author = "Carl Sagan",
            isbn = "9788408178945",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788408178945-L.jpg"
        ),
        BookEntity(
            id = 32,
            title = "Física universitaria",
            author = "Hugh D. Young, Roger A. Freedman",
            isbn = "9786073214854",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786073214854-L.jpg"
        ),
        BookEntity(
            id = 33,
            title = "La estructura de las revoluciones científicas",
            author = "Thomas S. Kuhn",
            isbn = "9789681605325",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789681605325-L.jpg"
        ),
        BookEntity(
            id = 34,
            title = "La interpretación de los sueños",
            author = "Sigmund Freud",
            isbn = "9788420669054",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420669054-L.jpg"
        ),
        BookEntity(
            id = 35,
            title = "Manual de psicología",
            author = "Rita L. Atkinson",
            isbn = "9788420683012",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420683012-L.jpg"
        ),
        BookEntity(
            id = 36,
            title = "Ética para Amador",
            author = "Fernando Savater",
            isbn = "9788432211324",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788432211324-L.jpg"
        ),
        BookEntity(
            id = 37,
            title = "Los orígenes del totalitarismo",
            author = "Hannah Arendt",
            isbn = "9788491041553",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788491041553-L.jpg"
        ),
        BookEntity(
            id = 38,
            title = "Economía en una lección",
            author = "Henry Hazlitt",
            isbn = "9788472091377",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788472091377-L.jpg"
        ),
        BookEntity(
            id = 39,
            title = "El capital",
            author = "Karl Marx",
            isbn = "9788420675550",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420675550-L.jpg"
        ),
        BookEntity(
            id = 40,
            title = "La riqueza de las naciones",
            author = "Adam Smith",
            isbn = "9788420675468",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420675468-L.jpg"
        ),
        BookEntity(
            id = 41,
            title = "El arte de la guerra",
            author = "Sun Tzu",
            isbn = "9788420681360",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420681360-L.jpg"
        ),
        BookEntity(
            id = 42,
            title = "El contrato social",
            author = "Jean-Jacques Rousseau",
            isbn = "9788420675994",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9788420675994-L.jpg"
        ),
        BookEntity(
            id = 43,
            title = "Matemáticas discretas y sus aplicaciones",
            author = "Kenneth H. Rosen",
            isbn = "9780073383098",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9780073383098-L.jpg"
        ),
        BookEntity(
            id = 44,
            title = "Base de datos: Un enfoque práctico",
            author = "Carlos Coronel, Steven Morris",
            isbn = "9786074817955",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786074817955-L.jpg"
        ),
        BookEntity(
            id = 45,
            title = "Introducción a los sistemas operativos",
            author = "Abraham Silberschatz",
            isbn = "9786074816514",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786074816514-L.jpg"
        ),
        BookEntity(
            id = 46,
            title = "Ciencias ambientales",
            author = "William P. Cunningham",
            isbn = "9789681857434",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9789681857434-L.jpg"
        ),
        BookEntity(
            id = 47,
            title = "Probabilidad y estadística para ingeniería y ciencias",
            author = "Jay L. Devore",
            isbn = "9786074815173",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9786074815173-L.jpg"
        ),
        BookEntity(
            id = 48,
            title = "Redes de computadoras",
            author = "Andrew S. Tanenbaum",
            isbn = "9789701064757",
            imageUrl = "https://covers.openlibrary.org/b/id/8084042-L.jpg"
        ),
        BookEntity(
            id = 49,
            title = "Patrones de diseño",
            author = "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
            isbn = "9780201633610",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9780201633610-L.jpg"
        ),
        BookEntity(
            id = 50,
            title = "Diseño de compiladores",
            author = "Alfred V. Aho, Monica S. Lam, Ravi Sethi, Jeffrey D. Ullman",
            isbn = "9780321486813",
            imageUrl = "https://covers.openlibrary.org/b/isbn/9780321486813-L.jpg"
        ),
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
        BookCategoryEntity(bookId = 9, categoryId = 5),  // Macroeconomía → Economía
        BookCategoryEntity(bookId = 10, categoryId = 10), // Arte y Percepción Visual → Arte
        BookCategoryEntity(
            bookId = 11,
            categoryId = 3
        ), // Álgebra Lineal y sus Aplicaciones → Matemáticas
        BookCategoryEntity(bookId = 12, categoryId = 8), // Química Orgánica → Química
        BookCategoryEntity(bookId = 13, categoryId = 11), // Inteligencia Artificial → IA
        BookCategoryEntity(bookId = 14, categoryId = 6), // Mecánica de Materiales → Ingeniería
        BookCategoryEntity(bookId = 15, categoryId = 3), // Análisis Matemático → Matemáticas
        BookCategoryEntity(bookId = 16, categoryId = 12), // Física Universitaria → Física
        BookCategoryEntity(bookId = 17, categoryId = 1),  // Contabilidad Financiera → Administración
        BookCategoryEntity(bookId = 18, categoryId = 1),  // Marketing → Administración
        BookCategoryEntity(bookId = 19, categoryId = 2),  // Derecho Constitucional Mexicano → Derecho
        BookCategoryEntity(bookId = 20, categoryId = 4),  // Psicología Social → Psicología
        BookCategoryEntity(bookId = 21, categoryId = 8),  // Química General → Química
        BookCategoryEntity(bookId = 22, categoryId = 9),  // Microeconomía → Economía
        BookCategoryEntity(bookId = 23, categoryId = 10), // Historia del Arte → Arte
        BookCategoryEntity(bookId = 24, categoryId = 12), // Fundamentos de Física → Física
        BookCategoryEntity(bookId = 25, categoryId = 7),   // Programación en C → Programación
        BookCategoryEntity(bookId = 26, categoryId = 12), // "El origen de las especies" → Biología
        BookCategoryEntity(bookId = 27, categoryId = 6),  // "La crítica de la razón pura" → Filosofía
        BookCategoryEntity(bookId = 28, categoryId = 6),  // "Meditaciones" → Filosofía
        BookCategoryEntity(bookId = 29, categoryId = 6),  // "El contrato social" → Filosofía
        BookCategoryEntity(bookId = 30, categoryId = 12), // "Breve historia del tiempo" → Física
        BookCategoryEntity(bookId = 31, categoryId = 12), // "Cosmos" → Física
        BookCategoryEntity(bookId = 32, categoryId = 12), // "El universo en una cáscara de nuez" → Física
        BookCategoryEntity(bookId = 33, categoryId = 12), // "Física cuántica" → Física
        BookCategoryEntity(bookId = 34, categoryId = 4), // "Psicología social" → Psicología
        BookCategoryEntity(bookId = 35, categoryId = 4), // "La interpretación de los sueños" → Psicología
        BookCategoryEntity(bookId = 36, categoryId = 6),  // "El existencialismo es un humanismo" → Filosofía
        BookCategoryEntity(bookId = 37, categoryId = 9),  // "Historia de la Revolución Francesa" → Historia
        BookCategoryEntity(bookId = 38, categoryId = 9),  // "El capital" → Economía
        BookCategoryEntity(bookId = 39, categoryId = 9),  // "La riqueza de las naciones" → Economía
        BookCategoryEntity(bookId = 40, categoryId = 9),  // "Teoría general del empleo, el interés y el dinero" → Economía
        BookCategoryEntity(bookId = 41, categoryId = 6),  // "Así habló Zaratustra" → Filosofía
        BookCategoryEntity(bookId = 42, categoryId = 6),  // "La genealogía de la moral" → Filosofía
        BookCategoryEntity(bookId = 43, categoryId = 3), // "Cálculo infinitesimal" → Matemáticas
        BookCategoryEntity(bookId = 44, categoryId = 7), // "Estructuras computacionales" → Tecnología
        BookCategoryEntity(bookId = 45, categoryId = 7), // "La ingeniería de software" → Tecnología
        BookCategoryEntity(bookId = 46, categoryId = 12), // "Los principios de la mecánica" → Física
        BookCategoryEntity(bookId = 47, categoryId = 3), // "Álgebra lineal" → Matemáticas
        BookCategoryEntity(bookId = 48, categoryId = 7), // "Redes de computadoras" → Tecnología
        BookCategoryEntity(bookId = 49, categoryId = 7), // "Programación orientada a objetos" → Programación
        BookCategoryEntity(bookId = 50, categoryId = 7),  // "Algoritmos y estructuras de datos" → Programación
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
        BookLibraryEntity(bookId = 1, libraryId = 1, quantity = 5),
        BookLibraryEntity(bookId = 3, libraryId = 2, quantity = 4),
        BookLibraryEntity(bookId = 5, libraryId = 4, quantity = 1),
        BookLibraryEntity(bookId = 7, libraryId = 2, quantity = 9),
        BookLibraryEntity(bookId = 8, libraryId = 3, quantity = 2),
        BookLibraryEntity(bookId = 8, libraryId = 1, quantity = 3),
        BookLibraryEntity(bookId = 9, libraryId = 1, quantity = 5),
        BookLibraryEntity(bookId = 10, libraryId = 5, quantity = 8),
        BookLibraryEntity(bookId = 11, libraryId = 2, quantity = 11),
        BookLibraryEntity(bookId = 13, libraryId = 1, quantity = 4),
        BookLibraryEntity(bookId = 14, libraryId = 2, quantity = 7),
        BookLibraryEntity(bookId = 15, libraryId = 1, quantity = 2),
        BookLibraryEntity(bookId = 16, libraryId = 2, quantity = 2),
        BookLibraryEntity(bookId = 17, libraryId = 1, quantity = 9),
        BookLibraryEntity(bookId = 18, libraryId = 1, quantity = 3),
        BookLibraryEntity(bookId = 19, libraryId = 3, quantity = 2),
        BookLibraryEntity(bookId = 20, libraryId = 4, quantity = 2),
        BookLibraryEntity(bookId = 21, libraryId = 3, quantity = 7),
        BookLibraryEntity(bookId = 22, libraryId = 1, quantity = 6),
        BookLibraryEntity(bookId = 23, libraryId = 5, quantity = 5),
        BookLibraryEntity(bookId = 24, libraryId = 2, quantity = 1),
        BookLibraryEntity(bookId = 25, libraryId = 2, quantity = 4),
        BookLibraryEntity(bookId = 26, libraryId = 1, quantity = 8),
        BookLibraryEntity(bookId = 27, libraryId = 1, quantity = 1),
        BookLibraryEntity(bookId = 28, libraryId = 1, quantity = 5),
        BookLibraryEntity(bookId = 34, libraryId = 1, quantity = 6),
        BookLibraryEntity(bookId = 35, libraryId = 1, quantity = 9),
        BookLibraryEntity(bookId = 36, libraryId = 1, quantity = 2),
        BookLibraryEntity(bookId = 41, libraryId = 1, quantity = 5),
        BookLibraryEntity(bookId = 42, libraryId = 1, quantity = 8),
        BookLibraryEntity(bookId = 30, libraryId = 2, quantity = 3),
        BookLibraryEntity(bookId = 31, libraryId = 2, quantity = 6),
        BookLibraryEntity(bookId = 32, libraryId = 2, quantity = 9),
        BookLibraryEntity(bookId = 33, libraryId = 2, quantity = 4),
        BookLibraryEntity(bookId = 43, libraryId = 2, quantity = 7),
        BookLibraryEntity(bookId = 47, libraryId = 2, quantity = 3),
        BookLibraryEntity(bookId = 46, libraryId = 2, quantity = 5),
        BookLibraryEntity(bookId = 37, libraryId = 3, quantity = 2),
        BookLibraryEntity(bookId = 38, libraryId = 3, quantity = 5),
        BookLibraryEntity(bookId = 39, libraryId = 3, quantity = 4),
        BookLibraryEntity(bookId = 40, libraryId = 3, quantity = 2),
        BookLibraryEntity(bookId = 44, libraryId = 4, quantity = 1),
        BookLibraryEntity(bookId = 45, libraryId = 4, quantity = 7),
        BookLibraryEntity(bookId = 48, libraryId = 4, quantity = 9),
        BookLibraryEntity(bookId = 49, libraryId = 4, quantity = 7),
        BookLibraryEntity(bookId = 50, libraryId = 4, quantity = 5),
    )
}