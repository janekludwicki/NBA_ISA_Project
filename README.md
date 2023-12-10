# Internet Services Architecture Laboratory 3 Spring MVC
During third laboratory students should get familiar with basic components of Spring MVC
(REST services implementation). Project should be based on the code developed during
previous laboratories.
The following tasks should be completed:
1. Implementation of DTO classes for creating/updating and reading all entity classes.
Additionally separate DTO classes for reading collections of entity classes. DTO
classes for creating/updating need to contain only those fields which can be set. For
example: primary keys and categories are set by sending request to specified
resource and are not present in the request body. DTO classes for reading
collections should not contain all original fields but only identifiers and some user
friendly name or description. (3 point).
2. Implementation of rest controllers as @RestController for each entity class.
Controllers should utilize services for business operations and translate between
business entities and DTO objects. Each controller must allow for creating/updating,
deleting and reading elements and categories as well as reading whole collections.
The resource addresses of the REST services must be well formed and
hierarchical. Appropriate HTTP methods must be used as well as appropriate
response codes. Removing categories must remove all elements (this can be done
with appropriate JPA configuration). Elements are always added to category. Client
can both fetch all elements and elements from single category. Remember that
fetching elements from empty and not existing categories will result in two different
responses. Situations like adding element to not existing category must result in
appropriate response code. (4 points)
3. All HTTP request must be documented and tested using standard request.http
file. Those files can be used with IntelliJ IDEA HTTP Client plugin or Visual Studio
Code REST Client plugin. (1 points)
