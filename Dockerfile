FROM openjdk:17-jdk AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
RUN microdnf install findutils
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/board-0.0.1-SNAPSHOT.jar"]
