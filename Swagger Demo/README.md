# Swagger Demo — Spring Boot

A lightweight Spring Boot application that demonstrates API documentation using **SpringDoc OpenAPI (Swagger UI)**. It showcases how to annotate RESTful endpoints, and expose an interactive API explorer — all containerized and deployable via Docker + Kubernetes with a full CI/CD pipeline.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.4.4 |
| API Documentation | SpringDoc OpenAPI 2.7.0 (Swagger UI) |
| Build Tool | Maven (spring-boot-maven-plugin) |
| Containerization | Docker |
| Orchestration | Kubernetes (K8s) |
| CI/CD | GitHub Actions |

---

## Project Structure

```
code-to-cloud/                     # Root repository
├── .github/
│   └── workflows/                  # GitHub Actions CI/CD pipeline
├── Swagger Demo/                   # Spring Boot application
│   ├── src/
│   │   └── main/java/com/example/...
│   ├── k8s/                        # Kubernetes manifest files
│   │   ├── swagger-demo-deployment.yml
│   │   └── service.yml
│   ├── auto_deploy_local.sh        # Local K8s deployment script
│   ├── Dockerfile
│   └── pom.xml

```

---

## Running Locally (Docker + Kubernetes)

### Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) with Kubernetes enabled
- `kubectl` CLI configured to point at your local cluster

### Steps

0. Replace {{DOCKER_USERNAME}} in below files with your actual docker username
   - auto_deploy_local.sh
   - swagger-demo-deployment.yml

1. **Enable Kubernetes** in Docker Desktop → Settings → Kubernetes → Enable Kubernetes.

2. **Clone the repository**

   ```bash
   git clone {github_repo_url}
   cd code-to-cloud/Swagger Demo
   ```

3. **Apply Kubernetes manifests**

   ```bash
   kubectl apply -f k8s/
   ```

4. **Run the automated deploy script**

   ```bash
   chmod +x auto_deploy_local.sh
   ./auto_deploy_local.sh
   ```

5. **Access Swagger UI**

   Once all pods are running, open your browser at:

   ```
   http://localhost:<configured-port>/swagger-ui/index.html
   ```

---

## CI/CD — Build & Deploy to Docker Hub

A GitHub Actions workflow is defined in `.github/workflows/` that automatically:

1. Builds the Maven project and creates a Docker image
2. Pushes the image to Docker Hub on every push to the main branch

### Pull and Run from Docker Hub

If you just want to run the pre-built image without building locally:

```bash
# Pull the latest image from Docker Hub
docker pull <your-dockerhub-username>/swagger-demo:latest

# Apply the Kubernetes manifests (image is already referenced in the YMLs)
kubectl apply -f k8s/
```

### Required GitHub Secrets

Set these in your repository → Settings → Secrets and variables → Actions:

| Secret | Description |
|---|---|
| `DOCKER_USERNAME` | Your Docker Hub username |
| `DOCKER_PASSWORD` | Your Docker Hub password or access token |

---

## API Documentation

Once the application is running, the full interactive API documentation is available at:

```
http://localhost:8080/swagger-ui/index.html
```

The raw OpenAPI spec (JSON) is available at:

```
http://localhost:8080/v3/api-docs
```

## License

This project is provided as a demo/reference implementation. See `LICENSE` for details.
