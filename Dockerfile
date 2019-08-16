FROM openjdk:8 as builder

WORKDIR /workspace

COPY . .

RUN ./gradlew --no-daemon clean build

FROM gcr.io/distroless/java:8

WORKDIR /app

COPY --from=builder /workspace/build/libs/hello.jms-0.0.1-SNAPSHOT.jar app.jar

CMD ["app.jar"]


