FROM nginx:1.23.3

LABEL org.opencontainers.image.title="brand-management-frontend"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"
LABEL org.opencontainers.image.description="frontend service"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

WORKDIR /usr/share/nginx/html/
RUN rm -rf ./*

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/website-application/browser .
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
