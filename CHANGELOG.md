# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2025-10-04

### Added
- feat: Implementar endpoint completo para inscripciones y refactorizar servicios
- Adición de Spring Security con configuración básica
- Integración de Lombok para simplificar el código Java
- Adición de tests unitarios para controladores (CarreraController, PersonaController)
- Workflow de GitHub Actions para generación automática de documentación
- Configuración de H2 para tests
- Adición de actuator para monitoreo

### Changed
- **BREAKING**: Migración completa de Kotlin a Java
- **BREAKING**: Actualización de Spring Boot de 3.4.5 a 4.0.0-M3
- Reemplazo de @Autowired con inyección por constructor usando @RequiredArgsConstructor
- Conversión de modelos de Kotlin a Java con anotaciones Lombok
- Actualización de dependencias:
  - MySQL Connector de 9.3.0 a 9.4.0
  - SpringDoc OpenAPI de 2.8.8 a 3.0.0-M1
  - OpenPDF de 2.0.4 a 3.0.0
  - Java de 21 a 25
- Refactorización de excepciones y repositorios para mejores prácticas
- Mejora en la estructura del proyecto eliminando dependencias Kotlin
- Actualización de configuración de logging y aplicación

### Fixed
- Corrección de versiones de dependencias y compatibilidad
- Ajustes en la configuración de desarrollo y testing

### Security
- Implementación de autenticación básica para endpoints de documentación
- Actualización de dependencias por seguridad

### Removed
- Eliminación completa de dependencias y código Kotlin
- Remoción de archivos .iml y configuraciones obsoletas

## [Unreleased]

### Added
- Documentación inicial del proyecto
- Estructura base del README
- Configuración de Docker
- Integración con Swagger UI

### Changed
- Actualización de dependencias:
  - Spring Boot a 3.4.4
  - Kotlin a 2.1.20
  - MySQL Connector a 9.2.0
  - Apache POI a 5.4.0
  - LibrePDF a 2.0.3
- Mejora en la estructura del proyecto
- Optimización de la configuración de Maven

### Fixed
- Corrección de problemas de compatibilidad entre Java y Kotlin
- Ajustes en la configuración de logging

### Security
- Actualización de dependencias por seguridad
- Implementación de validación de entrada

## [0.0.1-SNAPSHOT] - 2024-03-29

### Added
- Inicialización del proyecto
- Configuración básica de Spring Boot
- Estructura base de la API REST
- Integración con base de datos MySQL
- Sistema de manejo de excepciones
- Generación de documentos (PDF y Excel)
- Sistema de envío de correos electrónicos

### Changed
- Refactorización de excepciones y repositorios
- Mejora en el manejo de errores
- Optimización de la arquitectura del proyecto

### Fixed
- Corrección de problemas de conectividad
- Ajustes en la configuración de desarrollo

### Security
- Implementación de validación de datos
- Mejora en el manejo de excepciones 