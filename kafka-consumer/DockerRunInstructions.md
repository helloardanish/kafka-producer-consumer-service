Build it:

docker build -t kafka-consumer:v1 .

Run it:

docker run -p 8080:8080 kafka-consumer:v1

docker run -p 8091:8091 kafka-consumer:v1 #if port changed
