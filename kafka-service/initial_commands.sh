#!/bin/bash

# Start ZooKeeper server
kafka-3.7.0-src/bin/zookeeper-server-start.sh kafka-3.7.0-src/config/zookeeper.properties &
zookeeper_pid=$!
sleep 5

# Start Kafka server
kafka-3.7.0-src/bin/kafka-server-start.sh kafka-3.7.0-src/config/server.properties &
kafka_pid=$!
sleep 10

# Create the topic
kafka-3.7.0-src/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic message

# Wait for 1 minute and then stop the servers
sleep 30
trap "kill $zookeeper_pid $kafka_pid" EXIT
