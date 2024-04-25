# Build Stage
FROM ubuntu:latest as buildstage

# Set the working directory
WORKDIR /app

# Install wget and download Maven
RUN apt-get update && apt-get install -y wget
RUN wget -q https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz

# Extract Maven
RUN tar -xf apache-maven-3.9.6-bin.tar.gz

# Move Maven to the appropriate directory
RUN mv apache-maven-3.9.6 /opt/maven

# Set environment variables for Maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Cleanup
RUN rm apache-maven-3.9.6-bin.tar.gz

# Install OpenJDK
RUN apt-get update && apt-get install -y openjdk-21-jdk

# Verify Maven installation
RUN mvn -v

# Copy the Maven project
COPY . .

# Build the project
RUN mvn clean install -DskipTests

# Print the current directory (optional)
RUN pwd


# Check if the file exists
RUN if [ -f /app/target/kafka-producer-0.0.1-SNAPSHOT.jar ]; then \
    echo "File exists"; \
    else \
    echo "File does not exist"; \
    exit 1; \
    fi



# Final Stage
FROM openjdk:21

# Copy the JAR file from the build stage
#COPY --from=buildstage /app/app.jar /app/app.jar

# Copy the JAR file from the build stage
COPY --from=buildstage /app/target/*.jar app.jar

# Define the entry point
ENTRYPOINT [ "java", "-jar", "app.jar" ]
