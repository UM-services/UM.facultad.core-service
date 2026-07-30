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
- **inscripciones**: Gestión de inscripciones, detalle de inscripciones y matriculación
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
- `AutoMatriculaController`: Proceso de automatriculación
- `DomicilioController`: Manejo de domicilios
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
**1.5.0**

### Últimas Actualizaciones
- Nuevo endpoint `/inscripcion/full` que retorna datos agregados de inscripción, pago, persona y domicilio
- Nuevo `InscripcionFullDto` con datos consolidados de inscripción y pagador
- Refactorización de `InscripcionFullDto` para usar dominio en lugar de entidad JPA

## 💬 Soporte

Para soporte, por favor abra un issue en el repositorio o contacte al equipo de desarrollo.

---

⭐️ From [UM-services](https://github.com/UM-services)