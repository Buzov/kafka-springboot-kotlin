# kafka-springboot-kotlin

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
