FROM openjdk:21


LABEL org.opencontainers.image.title="nba_player"
LABEL org.opencontainers.image.authors="Jan Ludwicki"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"


ENV VERSION="1.0.0"
ENV TITLE="nba_player"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:NBA_player
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/NBA_player-0.0.1-SNAPSHOT.jar /opt/nba_player/nba_player.jar


CMD ["java", "-jar", "/opt/nba_player/nba_player.jar"]