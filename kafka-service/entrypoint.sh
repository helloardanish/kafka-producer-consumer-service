#!/bin/bash

# Start ZooKeeper
#nohup kafka-3.7.0-src/bin/zookeeper-server-start.sh kafka-3.7.0-src/config/zookeeper.properties > /dev/null 2>&1 &
nohup kafka-3.7.0-src/bin/zookeeper-server-start.sh kafka-3.7.0-src/config/zookeeper.properties &

# Wait for 10 seconds
sleep 10
printf "\n"

# Start another command (for example, Kafka server)
#nohup kafka-3.7.0-src/bin/kafka-server-start.sh kafka-3.7.0-src/config/server.properties > /dev/null 2>&1 &
nohup kafka-3.7.0-src/bin/kafka-server-start.sh kafka-3.7.0-src/config/server.properties &

printf "\n"

#ps aux | grep entrypoint.sh

#kill PID
