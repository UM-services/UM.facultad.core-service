FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY marca_etec.png marca_etec.png
COPY marca_um.png marca_um.png
ENTRYPOINT ["java","-jar","/app.jar"]
