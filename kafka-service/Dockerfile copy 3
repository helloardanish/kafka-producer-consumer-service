FROM ubuntu:latest

WORKDIR /app

# Install necessary packages
RUN apt-get update && apt-get install -y wget && apt-get install -y curl && apt-get install -y openjdk-21-jdk

# Download Kafka source
RUN wget https://downloads.apache.org/kafka/3.7.0/kafka-3.7.0-src.tgz \
    && tar -xzf kafka-3.7.0-src.tgz \
    && rm kafka-3.7.0-src.tgz


RUN update-alternatives --config javac

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-arm64/

# Build Kafka using gradlew
RUN cd kafka-3.7.0-src \
    && ./gradlew jar -PscalaVersion=2.13.12

# Remove SLF4J Duplication
RUN rm /app/kafka-3.7.0-src/trogdor/build/dependant-libs-2.13.12/slf4j-reload4j-1.7.36.jar

COPY initial_commands.sh .
RUN chmod +x initial_commands.sh

# Run the script to start servers, create topic, and stop servers after 30 seconds
RUN ./initial_commands.sh

# Create a script file for entrypoint
COPY entrypoint.sh .
RUN chmod +x entrypoint.sh

# Expose Kafka ports
EXPOSE 9092 2181

#ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
ENTRYPOINT ["/bin/bash", "-c", "while true; do sleep 86400; done"]
