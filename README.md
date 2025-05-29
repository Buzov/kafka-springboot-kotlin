# kafka-springboot-kotlin

# How to run

Need to build java applications
```shell
./gradlew clean bootJar
```

```shell
docker-compose up -d
```

# How to stop

```shell
docker-compose down -v
```

# Restart containers completely with cleaning:

```shell
docker compose down -v --remove-orphans
```
```shell
docker compose up -d --build --force-recreate
```

# Check if topic exists

```shell
docker exec -it kafka1 kafka-topics --bootstrap-server kafka1:29092 --list
```

# 🆚 Kafka Docker Distributions – Comparison Overview

| Image                                                                          | Description                                                                      | Pros                                                                            | Cons                                                                                      | Recommended Use Case                                 |
|--------------------------------------------------------------------------------| -------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ---------------------------------------------------- |
| [`confluentinc/cp-kafka`](https://hub.docker.com/r/confluentinc/cp-kafka/tags) | Official Confluent Platform image. Includes Kafka, Zookeeper, and KRaft support. | ✅ Easy to use<br>✅ KRaft support<br>✅ Stable in Docker<br>✅ Actively maintained | 🚫 Heavier image<br>🚫 Enterprise features require license<br>🚫 Not ideal for production | ✅ Best for local development & KRaft experimentation |
| [`bitnami/kafka`](https://hub.docker.com/r/bitnami/kafka)                      | Community-supported Kafka image based on Apache binaries.                        | ✅ Lightweight<br>✅ Production-friendly<br>✅ Helm charts available               | 🚫 KRaft setup requires manual tweaks<br>🚫 Default configs are verbose                   | ✅ Suitable for cloud/K8s & production environments   |
| [`apache/kafka`](https://hub.docker.com/r/apache/kafka)                        | Official Apache Kafka image (from the Apache project).                           | ✅ Vanilla Kafka<br>✅ No vendor lock-in                                          | 🚫 Poor documentation<br>🚫 Minimal Docker support<br>🚫 Hard to configure                | ❗ Advanced users only – pure Apache setups           |
| `wurstmeister/kafka`                                                           | Popular community image from the early Docker Kafka days (now outdated).         | ✅ Simple setup<br>✅ Docker Compose ready                                        | 🚫 No KRaft<br>🚫 ZooKeeper-only<br>🚫 Not actively maintained                            | ❌ Not recommended for new setups                     |

Cluster ID string kraft-cluster-id must be a valid UUID:
16 bytes of a base64-encoded UUID

```shell
export CLUSTER_ID=$(kafka-storage random-uuid)
echo $CLUSTER_ID
```

# 📦 What is provectuslabs/kafka-ui?

[GitHub kafka-ui](https://github.com/provectus/kafka-ui)

provectuslabs/kafka-ui is a lightweight open-source web UI for managing Kafka clusters. It allows you to:

    - View brokers, topics, partitions, consumers
    - Produce and consume messages manually
    - Manage topic configurations
    - Monitor consumer groups and offsets
    - View real-time cluster state

# ✅ Why it's used (and preferred)

| Reason                              | Explanation                                                                          |
| ------------------------------------| ------------------------------------------------------------------------------------ |
| **✅ Simple and modern UI**         | Offers a clean, responsive interface with better UX than older tools like Kafka Tool |
| **✅ No database required**         | Runs statelessly without needing external DBs — great for local Docker setups        |
| **✅ Supports KRaft and ZooKeeper** | Compatible with both controller types, which is essential for KRaft-mode clusters    |
| **✅ Actively maintained**          | Fast-growing project with frequent updates and strong community support              |
| **✅ Easy Docker integration**      | Configuration via environment variables; minimal setup for use in `docker-compose`   |


# 🔍 Alternatives (and why not used here)

| Alternative                    | Why Not Used Here                                                                            |
| ------------------------------ | -------------------------------------------------------------------------------------------- |
| **Confluent Control Center**   | Requires Confluent Enterprise license, heavy dependencies                                    |
| **AKHQ (previously Kafka HQ)** | Great option, but slightly heavier and more complex to configure (requires JVM, DB optional) |
| **Kafdrop**                    | Lighter UI but limited features (e.g., message view only for uncompressed messages)          |


# healthcheck
⚠️ Note: The kafka-topics command must be available inside the container for this health check to work. 
It is included in images like confluentinc/cp-kafka and bitnami/kafka by default.
