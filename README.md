# UM.facultad.core-service 🏛️

Servicio core para la gestión de facultades de la Universidad de Mendoza.

## 📋 Descripción

Este servicio proporciona la funcionalidad core para la gestión de facultades, incluyendo:
- Gestión de inscripciones
- Manejo de domicilios
- Procesamiento de pagos
- Automatriculación
- Integración con servicios externos

## 🛠️ Tecnologías Utilizadas

- Java 25
- Spring Boot 4.0.0-M3
- MySQL 9.4.0
- Apache POI 5.4.1
- OpenPDF 3.0.0
- SpringDoc OpenAPI 3.0.0-M1
- Spring Security
- Lombok
- Docker
- H2 (para tests)

## 📦 Prerrequisitos

- Java 25 o superior
- Maven 3.8+
- Docker (opcional)
- MySQL 5.7+

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

El proyecto sigue una arquitectura en capas:
- Controllers: Endpoints REST
- Services: Lógica de negocio
- Repositories: Acceso a datos
- Models: Entidades y DTOs
- Exceptions: Manejo de errores personalizado

### Principales Componentes

- `InscripcionController`: Gestión de inscripciones
- `DomicilioController`: Manejo de domicilios
- `AutoMatriculaService`: Proceso de automatriculación
- `InscripcionPago`: Gestión de pagos de inscripción

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

### Últimas Actualizaciones
- Migración completa a Java eliminando Kotlin
- Actualización a Spring Boot 4.0.0-M3
- Implementación de Spring Security
- Adición de tests unitarios
- Generación automática de documentación via GitHub Actions
- Refactorización completa de inyección de dependencias

## 💬 Soporte

Para soporte, por favor abra un issue en el repositorio o contacte al equipo de desarrollo.

---

⭐️ From [UM-services](https://github.com/UM-services)