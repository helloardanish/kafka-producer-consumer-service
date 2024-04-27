#!/bin/bash

# Start ZooKeeper server
kafka-3.7.0-src/bin/zookeeper-server-start.sh kafka-3.7.0-src/config/zookeeper.properties &
zookeeper_pid=$!

# Wait for ZooKeeper to start
sleep 5

# Start Kafka server
kafka-3.7.0-src/bin/kafka-server-start.sh kafka-3.7.0-src/config/server.properties &
kafka_pid=$!

# Keep the script running to prevent container from exiting
trap 'kill $zookeeper_pid $kafka_pid; exit' SIGTERM SIGINT
while true; do
    sleep 1
done


#This script starts the ZooKeeper server, waits for 5 seconds, and then starts the Kafka server. It also sets up a trap to handle SIGTERM and SIGINT signals, which will stop both the ZooKeeper and Kafka servers when the container is stopped or terminated.
#The while true; do sleep 1; done loop keeps the script running indefinitely, preventing the container from exiting immediately after starting the servers.
