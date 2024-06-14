# Laboratory 6- Docker & Docker Compose
During sixth laboratory students should get familiar with basic concepts of creating and
running Docker based containers. Task requires working Spring Boot and Angular
applications.
The following tasks should be completed:
1. Create Docker container for Angular application based on NGINX image.
Remember about building Angular application, configuring NGINX proxy (using
environment variables) and declaring appropriate port. (3 point)
2. Create Docker container for Spring Boot categories application based on Eclipse
Temurin image. Remember about configuring Spring Boot application (using
environment variables) and declaring appropriate port. (1 point)
3. Create Docker container for Spring Boot elements application based on Eclipse
Temurin image. Remember about configuring Spring Boot application (using
environment variables) and declaring appropriate port. (1 point)
4. Crete Docker Compose configuration including all three applications. Remember
about exposing ports and configuring each container with environment variables.
(2 point)
5. Add external database (of your choice) container for categories to Docker Compose
configuration. Configure Spring Boot categories application to use this container.
(1 point)
6. Add external database (of your choice) container for elements to Docker Compose
configuration. Configure Spring Boot elements application to use this container.
(1 point)

Attention: Students do not need to present embedded and external database use cases.
It’s up to them if they want to present only solution for 1-4 steps or for 1-6.

Attention: Students do not need to present Docker commands if the are also presenting
Docker Compose configuration. If all applications can be started with Docker Compose,
there is no need to start them separately with Docker commands. In case if students are
not presenting Docker Compose configuration, they must start containers with Docker
commands.
