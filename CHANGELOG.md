# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.6.0] - 2026-07-31

### Added
- Nuevo bounded context `personas` con arquitectura hexagonal (Ports & Adapters) completa:
  - Módulo `persona`: dominio (modelo `Persona`, puertos `FindPersonaByPersonaIdAndDocumentoIdUseCase`, `FindAllPersonasByPersonaIdInUseCase` y repositorio `PersonaRepository`), aplicación (`PersonaService`, implementaciones de casos de uso y `PersonaException`), infraestructura (controlador REST, `PersonaResponse`, `PersonaDtoMapper`, adaptador JPA, entidad y mapper de persistencia)
  - Módulo `domicilio`: dominio (modelos `Domicilio` y `Pagador`, puertos `FindDomicilioByPersonaIdAndDocumentoIdUseCase`, `FindDomicilioByPagadorUseCase`, `AddDomicilioUseCase`, `UpdateDomicilioUseCase`, `SincronizeDomicilioUseCase`, repositorio `DomicilioRepository` y puertos de salida `PagadorPort`, `TesoreriaSincronizePort`), aplicación (`DomicilioService`, casos de uso e `DomicilioException`), infraestructura (controlador REST, `DomicilioRequest`, `DomicilioResponse`, `DomicilioDtoMapper`, adaptadores JPA/Pagador/Tesorería, entidad y mapper de persistencia)
- Nuevo módulo `inscripcionPago` con arquitectura hexagonal dentro del bounded context `inscripciones`:
  - Dominio: modelo `InscripcionPago`, puerto `FindInscripcionPagoByUniqueUseCase` y repositorio `InscripcionPagoRepository`
  - Aplicación: `InscripcionPagoService`, implementación del caso de uso e `InscripcionPagoException`
  - Infraestructura: adaptador JPA, entidad, mapper y repositorio JPA

### Changed
- `InscripcionService.findInscripcionFull()`: los datos de pago, persona pagadora y domicilio ahora se obtienen mediante los domain models (`InscripcionPago`, `Persona`, `Domicilio`) en lugar de entidades JPA
- `InscripcionFullDto`: los campos `inscripcionPago`, `personaPago` y `domicilioPago` cambian de entidades a domain models; `@Data` reemplazado por `@Getter`/`@Setter`
- `PendienteInfo`: el campo `persona` migra de `PersonaEntity` a `Persona` (domain model)
- Módulo `matriculacion`: el modelo `Persona` se reubica en `personas.persona`, actualizando `MatriculacionContext`, `MatriculacionContextService`, `GetPersonaDataUseCase`, `MatriculacionContextRepository` y su implementación
- `PersonaController` y `DomicilioController`: recreados bajo el paquete hexagonal con DTOs de request/response
- `InscriptosToXlsService`: migrado a inyección por constructor (`@RequiredArgsConstructor`) con logging `@Slf4j`
- `SheetService`: reemplazo de `printStackTrace()` por `log.error()`
- `PersonaEntityControllerTest`: actualizado al nuevo `PersonaService` hexagonal

### Removed
- Eliminación de los servicios legacy `PersonaService`, `DomicilioService` e `InscripcionPagoService` del paquete `service`
- Eliminación de los controladores legacy `PersonaController` y `DomicilioController` del paquete `controller`
- Eliminación de las excepciones legacy `PersonaException`, `DomicilioException` e `InscripcionPagoException` del paquete `exception` (reubicadas en sus módulos hexagonales)
- Eliminación de los repositorios legacy `PersonaRepository`, `DomicilioRepository` e `InscripcionPagoRepository` del paquete `repository` (renombrados a `Jpa*Repository`)
- Eliminación de las entidades `PersonaEntity`, `DomicilioEntity` e `InscripcionPagoEntity` del paquete `model` (reubicadas en sus módulos hexagonales)
- Eliminación de los mappers de infraestructura del módulo `matriculacion` (Carrera, Inscripcion, Materia, Persona, Plan)

## [1.5.0] - 2026-07-30

### Added
- Nuevo endpoint `GET /inscripcion/full/{facultadId}/{personaId}/{documentoId}/{lectivoId}` que retorna un `InscripcionFullDto` con datos agregados de:
  - `Inscripcion` (domain model)
  - `InscripcionPagoEntity` (información de pago)
  - `PersonaEntity` (persona pagadora)
  - `DomicilioEntity` (domicilio del pagador)
- Nuevo método `findInscripcionFull()` en `InscripcionService` que integra datos de inscripción, pagos, persona y domicilio

### Changed
- Refactorización de `InscripcionFullDto`: el campo `inscripcion` cambió de tipo `InscripcionEntity` a `Inscripcion` (domain model) para alinearse con la arquitectura hexagonal

## [1.4.0] - 2026-07-30

### Added
- Nuevo módulo `tesoreriaEstado` con arquitectura hexagonal completa:
  - Domain: modelo `TesoreriaEstado`, puerto `FindTesoreriaEstadoByUniqueUseCase`, repositorio `TesoreriaRepository`
  - Application: servicio `TesoreriaEstadoService`, implementación `FindTesoreriaEstadoByUniqueUseCaseImpl`
  - Infrastructure: controlador REST, entidad JPA, mapper, adapter, DTO response

### Changed
- Migración completa de los módulos `carreras` (carrera, materia, plan) a Arquitectura Hexagonal (Ports & Adapters)
- Migración completa de los módulos `inscripciones` (inscripcion, inscripcionDetalle) a Arquitectura Hexagonal
- Reorganización del módulo `matriculacion` de `um.facultad.rest.hexagonal.matriculacion` a `um.facultad.rest.hexagonal.inscripciones.matriculacion`
- Actualización de dependencias:
  - MySQL Connector de 9.7.0 a 26.7.0
  - Tomcat Embed Core de 11.0.22 a 11.0.24
- Refactorización de `PendienteInfoService`: migración de `@Autowired` a inyección por constructor (`@RequiredArgsConstructor`)
- Actualización de imports en servicios legacy (`LegajoService`, `AutoMatriculaService`, `SheetService`, `MatriculaToPdfService`, `MailService`, `InscriptosToXlsService`, `PendienteInfoService`) para usar domain models en lugar de entities directas

### Removed
- Eliminación de servicios legacy: `CarreraService`, `PlanService`, `MateriaService`, `InscripcionService`, `InscripcionDetalleService`
- Eliminación de repositorios legacy: `CarreraRepository`, `PlanRepository`, `InscripcionDetalleRepository`
- Eliminación de controladores legacy: `CarreraController`, `PlanController`, `InscripcionController`, `InscripcionDetalleController`
- Eliminación de excepciones legacy: `CarreraException`, `InscripcionException`
- Eliminación de `CarreraEntity` del paquete `model`
- Eliminación de entidades duplicadas de dominio del módulo `matriculacion` (Carrera, Inscripcion, Materia, Plan)
- Eliminación de `logback-spring.xml`

## [1.3.6] - 2026-06-19

### Changed
- Actualización de Spring Boot de 4.0.5 a 4.1.0
- Actualización de MySQL Connector de 9.6.0 a 9.7.0
- Actualización de SpringDoc OpenAPI de 3.0.2 a 3.0.3
- Actualización de OpenPDF de 3.0.3 a 3.0.5
- Actualización de tomcat-embed-core de 11.0.20 a 11.0.22

### Fixed
- Corrección del formato de fecha ISO 8601: cambio de patrón `Z` a `XX` para incluir separador de dos puntos en el offset de zona horaria en todas las entidades

## [1.3.5] - 2026-04-03

### Fixed
- Eliminación de la variable `FORCE_JAVASCRIPT_ACTIONS_TO_NODE24: true` para resolver advertencias de acciones "forzadas" a Node.js 24 que aún no lo soportan de forma nativa (como `upload-pages-artifact`).
- Las acciones que ya soportan Node.js 24 de forma nativa (`checkout@v6`, `setup-java@v5`, etc.) continuarán ejecutándose en Node.js 24 automáticamente.

## [1.3.4] - 2026-04-03

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