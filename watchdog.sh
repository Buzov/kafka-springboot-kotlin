#!/bin/sh

# Install Docker CLI
# apk add --no-cache docker
echo "Starting watchdog to monitor unhealthy containers..."

while true; do
  echo "watchdog tick"

  # Find all unhealthy containers
  unhealthy_containers=$(docker ps --filter "health=unhealthy" --format "{{.ID}}")

  if [ -n "$unhealthy_containers" ]; then
    echo "Unhealthy container(s) detected: $unhealthy_containers"

    for container in $unhealthy_containers; do
      echo "Restarting container: $container"
      docker restart "$container"
    done
  fi

  sleep 120
done
