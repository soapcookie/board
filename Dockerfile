FROM openjdk:17-jdk AS build
WORKDIR /app
COPY . /app
RUN apt-get update && apt-get install -y findutils
RUN chmod +x ./gradlew && ./gradlew bootJar
ENTRYPOINT ["sh", "-c","java ${JAVA_OPTS} -jar /app/build/libs/board-0.0.1-SNAPSHOT.jar"]