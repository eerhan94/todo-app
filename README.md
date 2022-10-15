# TODO Application
Project Description
ReadingIsGood is an online books retail firm which operates only on the Internet. Main target of ReadingIsGood is to deliver books from its one centralized warehouse to their customers within the same day.

# Running with docker
1. Clone this repository
2. Go to project directory
3. mvn clean install
4. docker-compose up --build
 
# Used Technologies
1. Java 8
1. Spring Boot
2. Spring Data Couchbase
3. Couchbase
4. Swagger
5. Maven
6. Docker
7. JUnit and Mockito

# Swagger todo-app-api
http://localhost:9300/swagger-ui/index.html#/
![swagger-ui](https://user-images.githubusercontent.com/10101398/196004625-89e153a7-b12b-4dd0-93af-46501b91ca5f.png)

# Unit test coverage
![unit-test](https://user-images.githubusercontent.com/10101398/196004630-11bb4d83-ef9d-4eea-a77a-b62784d84891.png)

# Create User Api
curl --location --request POST 'http://localhost:9300/user' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1FE6B9B8F5A6F3B68E2991104596E3E0' \
--data-raw '{
    "username": "testuser",
    "password": "testpassword"
}'

# Authentication Token Url
curl --location --request POST 'http://localhost:9300/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=1FE6B9B8F5A6F3B68E2991104596E3E0' \
--data-raw '{
    "username": "testuser",
    "password": "testpassword"
}'

# Postman Collections
![postman](https://user-images.githubusercontent.com/10101398/196004634-15a5d22a-6381-4e51-a49c-1950a146ecd1.png)
