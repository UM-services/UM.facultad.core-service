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

- Java 21
- Kotlin 2.1.20
- Spring Boot 3.4.5
- MySQL 9.3.0
- Apache POI 5.4.1
- OpenPDF 2.0.4
- SpringDoc OpenAPI 2.8.8
- Docker

## 📦 Prerrequisitos

- Java 21 o superior
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
   - Configurar las credenciales en `application.properties`

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

## 📚 API Documentation

La documentación de la API está disponible en:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
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
- Nuevo endpoint para obtener información completa de inscripciones
- Refactorización de servicios y manejo de pagos
- Actualización de dependencias y mejoras de código (PR #27)
- Implementación de inyección por constructor (PR #25)
- Optimización de relaciones entre entidades
- Mejoras en el manejo de excepciones

## 💬 Soporte

Para soporte, por favor abra un issue en el repositorio o contacte al equipo de desarrollo.

---

⭐️ From [UM-services](https://github.com/UM-services)