# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.3.4] - 2026-04-03

### Changed
- Actualización de configuración de GitHub Actions:
  - Se agregó la variable de entorno `FORCE_JAVASCRIPT_ACTIONS_TO_NODE24: true` para optar por Node.js 24 y silenciar advertencias de deprecación de Node.js 20.

## [1.3.3] - 2026-04-03

### Changed
- Actualización de GitHub Actions en pipeline de documentación:
  - actions/checkout@v4 → @v6
  - actions/setup-java@v4 → @v5
  - actions/upload-pages-artifact@v3 → @v4
  - actions/deploy-pages@v4 → @v5

### Changed
- Actualización de GitHub Actions en pipeline Maven:
  - actions/checkout@v4 → @v6
  - actions/setup-java@v4 → @v5 (JDK 24 → 25)
  - actions/cache@v4 → @v5
  - docker/login-action@v3 → @v4
  - docker/metadata-action@v5 → @v6
  - docker/setup-buildx-action@v3 → @v4
  - docker/build-push-action@v6 → @v7

## [1.3.2] - 2026-04-03

### Added
- Configuración de SonarCloud para análisis de código:
  - sonar.organization, sonar.projectKey, sonar.host.url, sonar.coverage.jacoco.xmlReportPaths

## [1.3.1] - 2026-04-03

### Changed
- Actualización de Spring Boot de 4.0.2 a 4.0.5
- Actualización de SpringDoc OpenAPI de 3.0.1 a 3.0.2
- Actualización de OpenPDF de 3.0.1 a 3.0.3
- Actualización de tomcat-embed-core de 11.0.18 a 11.0.20
- Refactorización de AlumnoExamenController y AlumnoExamenService usando inyección por constructor (@RequiredArgsConstructor)
- Mejora de código: reemplazo de `new ResponseEntity<>()` por `ResponseEntity.ok()`
- Limpieza de código: eliminación de logs debug redundantes en AlumnoExamenService

## [1.3.0] - 2026-03-01

### Added
- Implementación de arquitectura hexagonal (Ports and Adapters) para el módulo de matriculación
  - Domain layer: modelos (Persona, Inscripcion, Carrera, Materia, Plan, MatriculacionContext)
  - Application layer: use cases (GetPersonaDataUseCase, GetInscripcionDataUseCase, GenerateMatriculacionContextUseCase)
  - Infrastructure layer: mappers y repositorios adapters
  - dependencyManagement con assertj-core 3.27.7 y tomcat-embed-core 11.0.18

### Changed
- Actualización de OpenPDF de 3.0.0 a 3.0.1
- Renombramiento de entidades de dominio: todas las clases modelo ahora usan sufijo Entity (ej: Carrera → CarreraEntity)
- Actualización de todos los controladores para usar las nuevas entidades con sufijo Entity

### Deprecated
- deprecated: clases de modelo antiguas sin sufijo Entity (serán eliminadas en versión mayor)

## [1.2.0] - 2026-02-02

### Changed
- Actualización de Spring Boot de 4.0.0-M3 a 4.0.2
- Actualización de SpringDoc OpenAPI de 3.0.0-M1 a 3.0.1
- Actualización de MySQL Connector de 9.4.0 a 9.6.0
- Actualización de Apache POI de 5.4.1 a 5.5.1
- Cambio de anotación @AutoConfigureMockMvc para tests (Spring Boot 4.0.2 compatibility)

### Added
- Dependencia spring-boot-starter-webmvc-test para tests

### Removed
- Configuración executable del spring-boot-maven-plugin (heredada del parent)

## [1.1.0] - 2025-10-07

### Changed
- Security configuration: disabled CSRF globally and permitted all access to /domicilio/sincronize endpoint

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