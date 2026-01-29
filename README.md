Enterprise Knowledge Copilot

Enterprise Knowledge Copilot is a backend service built with Spring Boot that manages structured enterprise knowledge such as policies, internal documents, and references.
It is designed to be cloud-ready, containerized, and extensible for future AI-powered search and retrieval use cases.

🚀 Tech Stack

Java 21
Spring Boot 4
Spring Data JPA (Hibernate)
PostgreSQL
Docker & Docker Compose
MinIO (S3-compatible object storage)
HikariCP
REST APIs

📦 Features

Store and retrieve enterprise documents

JPA-based persistence with PostgreSQL

RESTful API endpoints

Dockerized infrastructure (Postgres + MinIO)

Environment-based configuration using .env

Production-ready project structure

🧱 Architecture Overview
Client (Postman / UI)
        ↓
Spring Boot REST API
        ↓
   PostgreSQL (Metadata)
        ↓
     MinIO (Object Storage - future use)

🛠️ Local Setup
Prerequisites

Java 21

Docker & Docker Compose

Maven

1. Clone the repository
git clone https://github.com/<your-username>/enterprise-knowledge-copilot.git
cd enterprise-knowledge-copilot

2. Create .env file
DB_NAME=copilot
DB_USERNAME=copilot
DB_PASSWORD=copilot

MINIO_ROOT_USER=minioadmin
MINIO_ROOT_PASSWORD=minioadmin


.env is ignored by Git. See .env.example.

3. Start infrastructure
docker compose up -d


PostgreSQL → localhost:5432

MinIO Console → http://localhost:9001

4. Run the application
mvn spring-boot:run


Application runs on:

http://localhost:8080

📡 API Example
Get all documents
GET /api/documents


Response:

[
  {
    "id": 1,
    "title": "Leave Policy",
    "content": "Employees get 24 leaves.",
    "source": "manual",
    "createdAt": "2026-01-28T16:58:11.953895Z"
  }
]

🔐 Configuration Notes

Sensitive values are externalized using .env

Database timezone issues are handled explicitly

Hibernate dialect is configured to avoid metadata issues

📈 Future Enhancements

Full-text search

Document upload to MinIO

Vector embeddings for semantic search

Role-based access control

OpenAPI / Swagger documentation

AI-powered retrieval (RAG)

👤 Author

Vinay Mundhe
Backend Engineer | Java | Spring Boot | Cloud | Systems Design
