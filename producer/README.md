# Swagger

```shell
http://localhost:8180/swagger-ui.html
```

# How to run the producer in the root compose

```shell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.6"
```

```shell
./gradlew bootJar # Ensure the JAR is built
```

```shell
docker-compose up --build
```

# Optional: Clean and Build Docker Image

```shell
./gradlew clean bootJar
./gradlew clean bootJar --warning-mode all
```

```shell
docker-compose down --volumes --remove-orphans
```

```shell
docker-compose build --no-cache
```

```shell
docker-compose up
```