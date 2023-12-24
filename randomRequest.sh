#!/bin/bash

while true; do
    # Generate a random sleep interval between 1 and 5 seconds
    sleep_interval=$((1 + RANDOM % 5))

    # Perform the GET request using curl
    curl -X GET http://localhost:8080/customer/1

    # Sleep for the random interval
    sleep $sleep_interval

    # Check if a stop signal file exists
    if [ -f "stop_signal.txt" ]; then
        echo "Script stopped."
        rm -f "stop_signal.txt"  # Remove the stop signal file
        break
    fi
done
