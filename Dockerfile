FROM eclipse-temurin:8-jdk-alpine AS builder
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:8-jdk-alpine AS runner
WORKDIR /app
RUN apk add --no-cache tzdata
RUN addgroup -S spring \
    && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /app/target/*.jar aniversario.jar
ENTRYPOINT ["java", "-jar", "aniversario.jar"]
