# UM.facultad.core-service

[![UM.facultad.rest CI](https://github.com/UM-services/UM.facultad.core-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/UM-services/UM.facultad.core-service/actions/workflows/maven.yml)

## 📋 Descripción

Servicio core para la gestión de facultades de la Universidad de Mendoza. Este proyecto está construido con Spring Boot y proporciona una API RESTful para la administración de recursos académicos.

## 🚀 Tecnologías

- Java 21
- Kotlin 2.1.10
- Spring Boot 3.4.2
- MySQL
- OpenAPI (Swagger) 2.8.4
- Apache POI 5.4.0

## 📦 Prerequisitos

- JDK 21 o superior
- Maven 3.8+
- MySQL 8.0+

## 🛠️ Instalación

1. Clonar el repositorio
```bash
git clone https://github.com/UM-services/UM.facultad.core-service.git
```

2. Navegar al directorio del proyecto
```bash
cd UM.facultad.core-service
```

3. Compilar el proyecto
```bash
mvn clean install
```

4. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

## 📚 Documentación API

La documentación de la API está disponible a través de Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Tests

Para ejecutar los tests:
```bash
mvn test
```

## 📐 Arquitectura

El proyecto sigue una arquitectura en capas:
- Controllers (API endpoints)
- Services (Lógica de negocio)
- Repositories (Acceso a datos)
- Models (Entidades y DTOs)

## 🤝 Contribución

1. Fork el proyecto
2. Crea tu Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push al Branch (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia [MIT](LICENSE)

## 👥 Autores

* **Universidad de Mendoza** - *Desarrollo inicial* - [UM-services](https://github.com/UM-services)

## 🔍 Estado del Proyecto

![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-green)
![Versión](https://img.shields.io/badge/Versión-1.0.0-blue)

## 📞 Soporte

Para soporte, por favor crear un issue en el repositorio.
