FROM amazoncorretto:17-alpine-jdk
ENV MONGO_HOST=localhost
ENV MONGO_USERNAME="" MONGO_PASSWORD="" MONGO_DB="gestaoDePedidos"
ADD target/fastfood-system-api-0.0.1-SNAPSHOT.jar fastfood.jar
ENTRYPOINT ["java", "-jar", "fastfood.jar"]
EXPOSE 8080