# Laboratory 2- Spring Framework & Spring Boot & Spring Data
During second laboratory students should get familiar with basic components of Spring
Framework (component, repository, service), mechanism of dependency injection and
inversion of control as well as basic components of Spring Data (SQL database access
with repositories). Project should be realized as Maven Spring Boot project. Basic project
can be generated using Spring initializer https://start.spring.io/. Entity classes should be
based on the code developed during previous laboratories.
The following tasks should be completed:
1. All business classes should be enhanced with appropriate JPA annotations. Name
of the tables should be in plural form. Tables and columns names should be
formatted using snake_case. All relationships should be bidirectional. Fetching
category should not fetch elements by default. Entities should use UUID generated
by client (not by the JPA or database) as primary keys. Remember about data
source configuration. The in-memory H2 database should be used. (2 points).
2. Implementation of JPA repositories for each business class as Spring
@Repository. Repository for elements should allow for querying them by
category. (2 point)
3. Implementation of service for each business class as Spring @Service. Each
service should utilize repository instance provided by the container. At this moment
each service should delegate repository methods. At this point this can look as
services does not introduce any added value but this decomposition can be crucial
in developing much more complex applications. (2 points)
4. Implementation of example data initializer launched automatically after start as
Spring @Component. The initializer should utilize services instances provided by
the container. (1 point)
5. Implementation of command line runner as Spring @Component. The runner should
communicate with the user using standard input and output streams and allow for
listing available commands, listing all categories, listing all elements, adding new
element (with category selection), delete existing element, stopping the application.
The runner should utilize services instances provided by the container. (1 point)
