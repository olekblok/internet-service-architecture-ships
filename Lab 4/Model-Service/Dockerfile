FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="model-service"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="model service"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:model
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update


ENV ISA_SHIP_SERVICE_URL=http://ship-service:8080/


EXPOSE 8080


COPY target/ModelService-0.0.1-SNAPSHOT.jar /opt/ModelService/ModelService.jar

CMD ["java", "-jar", "/opt/ModelService/ModelService.jar"]