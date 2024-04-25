# Use Node.js Alpine image as base
FROM node:alpine

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Set the working directory
WORKDIR /app

# Create a new Angular project
RUN ng new ping-now --routing --style=scss --skip-install

# Copy a startup script into the container
COPY startup.sh /usr/local/bin/startup.sh

# Make the script executable
RUN chmod +x /usr/local/bin/startup.sh

# Set the script as the entrypoint
ENTRYPOINT ["/usr/local/bin/startup.sh"]
