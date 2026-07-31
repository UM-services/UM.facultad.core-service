# UM.facultad.core-service 🏛️

Servicio core para la gestión de facultades de la Universidad de Mendoza.

## 📋 Descripción

Este servicio proporciona la funcionalidad core para la gestión de facultades, incluyendo:
- Gestión de inscripciones
- Manejo de domicilios
- Procesamiento de pagos
- Automatriculación
- Estado de tesorería
- Integración con servicios externos

## 🛠️ Tecnologías Utilizadas

- Java 25
- Spring Boot 4.1.0
- MySQL Connector 26.7.0
- Apache POI 5.5.1
- OpenPDF 3.0.5
- SpringDoc OpenAPI 3.0.3
- Spring Security
- Lombok
- Docker
- H2 (para tests)

## 📦 Prerrequisitos

- Java 25 o superior
- Maven 3.8+
- Docker (opcional)
- MySQL 8.0+

## 🚀 Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/UM-services/um.facultad.core-service.git
cd um.facultad.core-service
```

2. Configurar la base de datos:
   - Crear una base de datos MySQL
   - Configurar las credenciales en `application.yml`

3. Compilar el proyecto:
```bash
mvn clean install
```

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

## 🐳 Uso con Docker

> **Nota**: La configuración de Docker está en proceso de actualización. Por favor, use la configuración local por ahora.

## 🔒 Seguridad

La aplicación incluye configuración de Spring Security:
- Endpoints de documentación protegidos con autenticación básica
- Endpoint /domicilio/sincronize permitido sin autenticación
- CSRF deshabilitado
- Credenciales configurables via variables de entorno (`app.swagger_user`, `app.swagger_password`)

## 📚 API Documentation

La documentación de la API está disponible en:
- Swagger UI: `http://localhost:8080/swagger-ui.html` (requiere autenticación)
- OpenAPI: `http://localhost:8080/v3/api-docs`

## 🧪 Testing

```bash
mvn test
```

## 🏗️ Arquitectura

El proyecto sigue una **Arquitectura Hexagonal (Ports & Adapters)** organizada en bounded contexts:

### Bounded Contexts

- **carreras**: Gestión de carreras, planes y materias
- **inscripciones**: Gestión de inscripciones, pagos, detalle de inscripciones y matriculación
- **personas**: Gestión de personas y domicilios
- **tesoreriaEstado**: Consulta de estado de tesorería

### Capas por Contexto

- **Domain**: Modelos de dominio y puertos (interfaces)
- **Application**: Casos de uso (servicios de aplicación)
- **Infrastructure - Web**: Controladores REST y DTOs
- **Infrastructure - Persistence**: Adaptadores JPA, entidades y repositorios

### Principales Componentes

- `CarreraController` (hexagonal): Gestión de carreras
- `InscripcionController` (hexagonal): Gestión de inscripciones
- `InscripcionDetalleController` (hexagonal): Detalle de inscripciones
- `PlanController` (hexagonal): Gestión de planes de estudio
- `MateriaController` (hexagonal): Gestión de materias
- `TesoreriaEstadoController` (hexagonal): Estado de tesorería
- `MatriculacionContextController` (hexagonal): Contexto de matriculación
- `PersonaController` (hexagonal): Consulta de personas
- `DomicilioController` (hexagonal): Manejo de domicilios
- `AutoMatriculaController`: Proceso de automatriculación
- `InscripcionFullDto`: DTO agregado con datos de inscripción, pago, persona y domicilio (`GET /inscripcion/full/...`)

## 🤝 Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'feat: add some amazing feature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## 👥 Autores

- **Daniel Quinteros** - *Desarrollo Principal* - [dqmdz](https://github.com/dqmdz)

## 📊 Estado del Proyecto

🟢 Activo - En desarrollo activo

### Versión Actual
**1.6.0**

### Últimas Actualizaciones
- Nuevo bounded context `personas` con módulos hexagonales de persona y domicilio (controladores REST, servicios, casos de uso, adaptadores JPA y DTOs)
- Nuevo módulo hexagonal `inscripcionPago` con `InscripcionPagoService`, casos de uso y adaptador JPA
- El domain model `Persona` incorpora los campos `sexo`, `profesionId` y `mascara`
- `InscripcionFullDto` y `PendienteInfo` migrados a domain models (ya no usan entidades JPA)
- Migración de los servicios, controladores y repositorios legacy de persona, domicilio e inscripción-pago a la arquitectura hexagonal

## 💬 Soporte

Para soporte, por favor abra un issue en el repositorio o contacte al equipo de desarrollo.

---

⭐️ From [UM-services](https://github.com/UM-services)