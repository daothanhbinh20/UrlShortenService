# URL Shortener Service

## Introduction
This repository contains the source code for a URL shortener service built using Spring Boot 3. The service allows users to shorten long URLs into more manageable, shorter ones. It provides an API for generating shortened URLs and redirecting users to the original long URLs.

## Features
- Shorten long URLs into unique, short aliases.
- Redirect users from shortened URLs to the original long URLs.

## Technologies Used
- Java
- Spring Boot 3
- MySql
- Gradle
- Prometheus: For scraping metrics from `/actuator/prometheus`
- Grafana: For metrics visualization
- Docker


## Setup
1. Clone this repository to your local machine.
2. Make sure you have Java installed.
3. Navigate to the project directory.
4. Run `./gradlew startDocker` to start the application.
5. The application will be accessible at `http://localhost:8080`. Application metrics is exposed at port `8086`

## Usage
### Generating Shortened URLs
To generate a shortened URL, send a POST request to `/urlShortener` endpoint with the following txt payload:
```text
https://www.youtube.com/watch?v=U5NdL3RokJc
```

Example:
```bash
curl -X POST -H "Content-Type: text/plain" -d 'https://www.youtube.com/watch?v=U5NdL3RokJc' http://localhost:8080/urlShortener
```

### Redirecting Users
To redirect users from a shortened URL to the original long URL, simply visit the shortened URL in the browser or send a GET request to the shortened URL.

Example:
```bash
curl http://localhost:8080/SHORT_ALIAS
```

## Future Work
- Integrate a Java Client Interface and update the `/urlShortener` endpoint to support `application/json` Content-Type.
- Implement Log management tools like ELK stack or Promtail.
- Develop end-to-end tests (e2e tests).
- Configure GitHub workflows for automated testing.
- Enable Minikube for local deployment.
- Set up production-ready deployment within the local network.
- Optimize the length of shortened URLs by revising the hashing mechanism; currently, full Sha-256 hash is used for uniqueness.
- Implement on-heap caching.
- Integrate Redis caching for improved performance.


## Contributors
- [David Dao](https://github.com/daothanhbinh20)
