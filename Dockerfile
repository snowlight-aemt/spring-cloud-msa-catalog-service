FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY target/catalog-service-1.0.jar CatalogService.jar
ENTRYPOINT ["java", "-jar", "CatalogService.jar"]

# docker run -d --network ecommerce-network `
#     --name catalog-service `
#     -e "spring.cloud.config.uri=http://config-service:8888" `
#     -e "spring.rabbitmq.host=rabbitmq" `
#     -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" `
#     -e "logging.file=/api-logs/catalogs-ws.log" `
#     mmsnow/catalog-service:1.0