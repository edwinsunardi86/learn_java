# Gunakan image resmi OpenJDK sebagai base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory di dalam container
WORKDIR /app

# Copy file jar hasil build ke dalam container
COPY target/integrated-0.0.1-SNAPSHOT.jar app.jar

# Jalankan aplikasi Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]