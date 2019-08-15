./gradlew assemble

PORT=${1:-8080}

echo "Port: $PORT"

java -jar \
  -Dserver.port=${PORT} \
  -Dspring.profiles.active=dev \
  build/libs/hello.jms-0.0.1-SNAPSHOT.jar
