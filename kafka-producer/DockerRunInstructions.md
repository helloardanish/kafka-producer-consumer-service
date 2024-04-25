Build it:

docker build -t kafka-producer:v1 .

Run it:

docker run -p 8080:8080 kafka-producer:v1

docker run -p 8090:8090 kafka-producer:v1 #if port changed
