# UANL Biblioteca App

Aplicación de biblioteca académica diseñada para gestionar libros, préstamos y usuarios, construida
con Kotlin y Jetpack Compose. Esta app permite a los estudiantes consultar el catálogo de libros
disponibles, visualizar detalles de préstamos y administrar devoluciones.

---

## Características

- Visualización del catálogo de libros con detalles de disponibilidad.
- Gestión de relaciones entre libros, categorías, bibliotecas y estudiantes.
- Registro y visualización de préstamos de libros.
- Estado actualizado de los préstamos.
- UI utilizando Jetpack Compose.
- Almacenamiento persistente local con Room.
- Inyección de dependencias con Koin.

---

## Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose** – UI declarativa
- **Room** – Base de datos local
- **Koin** – Inyección de dependencias
- **Ktor** – Consumo de API
- **ViewModel + StateFlow** – Gestión de estado
- **Coroutines** – Manejo de operaciones asíncronas
- **Material 3** – Componentes de diseño

---

## Estructura del proyecto

```text
com.dpam.uanlbiblioteca/
├── data/                  # Capa de datos
│   ├── database/          # DAOs, entidades y mapeadores
│   └── repository/        # Repositorios y lógica de acceso a datos
├── di/                    # Módulos de Koin
├── domain/                # Capa de dominio
├── ui/                    # Capa de presentación
│   ├── main/              # Pantallas principales (tabs)
│   └── core/              # Componentes comunes reutilizables
└── MainActivity.kt        # Actividad principal de la app
```

---

##  Cómo ejecutar la app

### Requisitos

- Android Studio Giraffe o superior
- JDK 17
- Gradle 8+
- Emulador Android o dispositivo físico (Android 8+)

### Pasos

1. Clona el repositorio:

   ```bash
   git clone https://github.com/RicardoDB96/Biblioteca-DPAM.git
   cd Biblioteca-DPAM
   ```

2. Abre el proyecto con **Android Studio**.

3. Conéctate a un emulador o dispositivo físico.

4. Ejecuta la app con el botón de "Run".

