## event-seats

Events are identified by a unique id, and each event has Seats available for sale. Seats have the following properties.

available=true|false

aisle=true|false

type = adult | child

Design and implement a working REST api service that would provide a way to return the following.

    Total count of seats available.
    Get seat count based on filters for type and aisle. 

### Documentation

This Spring Boot API was built with Maven plugin and includes the dependency spring-boot-starter-data-rest, which means that the corresponding 
REST API CRUD endpoints for events and seats are enabled.

For the purpose of this exercise, I used H2 in memory database and it can be found at http://localhost:8080/h2-console once the app is running for data manipulation. 

The endpoint /events/{eventId}/seats was customized to accept filters(type, aisle, available) and return http header x-total-count.

Valid filter parameter values are:

type=adult|child 
aisle=true|false|1|0
available =true|false|1|0

**Example** 

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/events/76167bf5-bc68-4581-b120-314df000fc06/seats?type=adult&available=1

Response:
`
HTTP/1.1 200 
X-Total-Count: 1
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sat, 19 May 2018 06:27:30 GMT

[{"id":5,"type":"adult","aisle":true,"available":true}]
`