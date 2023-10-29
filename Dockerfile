FROM amazoncorretto:17-alpine-jdk
COPY fastfood-management-system/fastfood-system-application/target/fastfood-system-api-0.0.1-SNAPSHOT.jar fastfood.jar
ENTRYPOINT ["java", "-jar", "fastfood.jar"]
EXPOSE 8080
