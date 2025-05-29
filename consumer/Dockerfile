FROM openjdk:21-jdk-slim

# ✅ Add curl for healthcheck
RUN apt-get update && apt-get install -y curl

WORKDIR /app

COPY build/libs/consumer-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
