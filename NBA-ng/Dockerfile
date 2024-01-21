FROM nginx:1.23.3

LABEL org.opencontainers.image.title="nba-ng"
LABEL org.opencontainers.image.authors="Jan Ludwicki"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/nba-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/