FROM maven:latest as builder
WORKDIR source
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:latest as deployer
WORKDIR app
COPY --from=builder source/target/*.jar build.jar
ENTRYPOINT ["java", "-jar", "build.jar"]