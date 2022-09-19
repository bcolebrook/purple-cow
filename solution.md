# purple-cow
Fearless Trial Project

The purpose of this project is to create a simple RESTful API for demo-ing how we could use an API for our proof of concept purple cow project.

# Requirements
- Java 8
- Java Spring Boot
- Docker
- MongoDB
- Gradle

# How to build
`./gradlew build`

`docker build -t purplecow .`

# How to run
First we need to start our database image.

`docker run --name mongodb -d -p 27017:27017 mongo`

Can also use volume mount to mount a local or remote folder into the db container to use it as your storage. Simply add `-v <your_folder>:/data/db` to the command above.

Next run the container for our api.

``export MONGODB_HOSTNAME=`docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mongodb` ``


`docker run --name purplecow -p 3000:8080 -e MONGODB_HOSTNAME=${MONGODB_HOSTNAME} purplecow:latest`

If you would like to change the port, simply switch out the 3000 for your ideal port number.

`docker run -p <port>:8080 purplecow:latest`

# Testing the REST endpoint
We can use curl to test the various different api calls.


To retrieve the current list of items, we want to do a GET request, which is the default for curl.

GET: `curl http://localhost:3000/items`

To set the list of items, we will do a POST request and provide in json format a new list we want to set as the list of items.

POST: `curl --request POST 'http://localhost:3000/items' --header 'Content-Type: application/json' --data-raw '[{"name":"Ben", "id":1},{"name":"Hope","id":2}]'`

To delete all of the items we will do a DELETE request.

DELETE: `curl --request DELETE 'http://localhost:3000/items'`


# If I had more time...
I would expand the API to have more calls including getting the items by id and updating items (PUT) and removing items by id.