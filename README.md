# UM.facultad.core-service

[![UM.facultad.rest CI](https://github.com/UM-services/UM.facultad.core-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/UM-services/UM.facultad.core-service/actions/workflows/maven.yml)

## 📋 Descripción

Servicio core para la gestión de facultades de la Universidad de Mendoza. Este proyecto está construido con Spring Boot y proporciona una API RESTful para la administración de recursos académicos.

## 🚀 Tecnologías

- Java 21
- Kotlin 2.1.20
- Spring Boot 3.4.4
- MySQL 9.2.0
- OpenAPI (Swagger) 2.8.6
- Apache POI 5.4.0
- LibrePDF 2.0.3
- Log4j2
- Lombok

## 📦 Prerequisitos

- JDK 21 o superior
- Maven 3.8.8+
- MySQL 8.0+
- Docker (opcional)

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

## 🐳 Docker

Para ejecutar con Docker:

```bash
docker-compose up -d
```

## 📚 Documentación API

La documentación de la API está disponible a través de Swagger UI:
```