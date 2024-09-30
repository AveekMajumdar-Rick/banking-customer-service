FROM openjdk:17-jdk-alpine
COPY target/customer-service-1.0.0.jar customer-service.jar
ENTRYPOINT [ "java", "-jar", "/customer-service.jar" ]