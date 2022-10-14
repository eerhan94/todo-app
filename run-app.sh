mvn clean package -DskipTests

docker build -t eyup/todo-app .
docker run -p 9300:9300 -t eyup/todo-app