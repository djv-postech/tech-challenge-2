FROM amazoncorretto:17-alpine-jdk
ADD ./fastfood-management-system/fastfood-management-application/target/fastfood-system-api-0.0.1-SNAPSHOT.jar fastfood.jar
ENTRYPOINT ["java", "-jar", "fastfood.jar"]
EXPOSE 8080
