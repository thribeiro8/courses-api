# Courses API

## Rocketseat Backend Challenge

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

This project is an API built using **Java, Java Spring, JPA, Docker, PostgreSQL.**

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/thribeiro8/courses-api
```

2. Install dependencies with Maven

3. Create a configuration with your runtime environment variables with your PostgreeSQL Credentials that are used in `application.properties`

```yml
spring.datasource.url=jdbc:postgresql://localhost:5432/courses_api
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

**Docker**

```yml
version: "3.8"

services:
  postgres:
    container_name: courses_api_postgres
    image: postgres
    ports:
      - 5432:5432
    environment:
      - POSTGRES_USER=admin
      - POSTGRES_PASSWORD=admin
      - POSTGRES_DB=courses_api
```

**Postgres**

1. Run in terminal:

```bash
docker compose up -d
```

2. Create a DB for postgres using docker compose: http://localhost:5432.

3. Log with admin:admin and create a database called 'course'.

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:5432

## API Endpoints

The API provides the following endpoints:

**API COURSE**

```markdown
POST /courses - Create a new course
GET /courses - Retrieve all courses
GET /courses/{id} - Retrieve a course
PUT /courses/{id} - Updates a course
DELETE /courses/{id} - Delete a course
```

**BODY**

```json
{
  "name": "Curso a ser postado",
  "category": "Categoria a ser postada"
}
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.
