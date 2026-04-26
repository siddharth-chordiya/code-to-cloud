# Code-To-Cloud

A personal collection of projects built with the help of AI — spanning backend services, API tooling, automation pipelines, and more. Each sub-project lives in its own folder with its own README and setup instructions.

---

## Projects

| Project                        | Description | Stack |
|--------------------------------|---|---|
| [Swagger Demo](./Swagger_Demo) | Spring Boot REST API with Swagger/OpenAPI documentation, containerized and deployed via Docker + Kubernetes | Java, Spring Boot, Docker, K8s |

> More projects coming soon.

---

## Repository Structure

```
code-to-cloud/
├── .github/
│   └── workflows/        # Shared CI/CD pipelines (GitHub Actions)
├── Swagger Demo/         # Project 1
├── <next-project>/       # Project 2 (coming soon)
└── README.md
```

---

## Getting Started

Each project is self-contained. Navigate to the relevant project folder and follow the README inside it.

```bash
git clone https://github.com/<your-org>/code-to-cloud.git
cd code-to-cloud/<project-name>
```

---

## CI/CD

GitHub Actions workflows are defined in `.github/workflows/` at the root level. Each workflow is scoped to its respective project and handles building, testing, and deploying to Docker Hub or other targets.

---

## License

This repository is provided for learning and experimentation purposes.