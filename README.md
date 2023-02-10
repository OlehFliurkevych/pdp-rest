# pdp-rest

project for resolving tasks from _**Rest API**_ module in scope of preparing to assessment.
***
### Spring-based module, which handle CRUD operations with event.

Technologies:
- JDK 11+
- Apache Maven 3.6.0+
- Git
- Docker
- OpenApi
- Postgres
***
Build and deploy instance of Postgres DB in Docker:
> docker-compose up

Generate JavaDoc:
> mvn javadoc:javadoc

Run Spring Boot application:
> ./mvnw spring-boot:run
***
### Example:
#### Request:
> curl --location --request GET 'localhost:8080/events'

#### Response:
```json
{
  "events": [
    {
      "id": 21,
      "title": "Title 1",
      "place": 1,
      "speaker": "Speaker 1",
      "eventType": "COMPLEX",
      "dateTime": "2022-02-20",
      "_links": {
        "self": {
          "href": "http://localhost:8080/events/21"
        }
      }
    },
    {
      "id": 22,
      "title": "Title 2",
      "place": 5,
      "speaker": "Speaker 2",
      "eventType": "SIMPLE",
      "dateTime": "2022-02-22",
      "_links": {
        "self": {
          "href": "http://localhost:8080/events/22"
        }
      }
    },
    {
      "id": 23,
      "title": "Title 3",
      "place": 15,
      "speaker": "Speaker 3",
      "eventType": "COMPLEX",
      "dateTime": "2023-03-15",
      "_links": {
        "self": {
          "href": "http://localhost:8080/events/23"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "http://localhost:8080/events"
    }
  }
}
```
