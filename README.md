
---

## 🧠 What is This?

This is a **Jenkins Shared Library** that provides reusable pipeline steps for:

- Code checkout
- Docker build & deployment
- Security scanning
- Code quality analysis

Instead of writing the same pipeline code again and again, these scripts help you **reuse logic across multiple projects**.

---

## ⚙️ How I Use This

### 1. Add Shared Library in Jenkins
- Go to **Manage Jenkins → Configure System**
- Add a **Global Pipeline Library**
- Provide:
  - Repository URL
  - Default branch (e.g., `main`)

---

### 2. Use in Jenkins Pipeline

```groovy
@Library('your-library-name') _

pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                clone('repo-url', 'main')
            }
        }

        stage('Build Docker Image') {
            steps {
                docker_build('app-name')
            }
        }

        stage('Push Docker Image') {
            steps {
                docker_push('app-name')
            }
        }

        stage('Security Scan') {
            steps {
                trivy_scan('app-name')
            }
        }

        stage('Code Quality') {
            steps {
                sonarqube_analysis()
                sonarqube_code_quality()
            }
        }
    }
}

```

## 🔧 Available Scripts

### 📦 Code Management
- **`clone.groovy`** → Clones a Git repository  
- **`code_checkout.groovy`** → Checks out a specific branch or commit  

---

### 🐳 Docker Operations
- **`docker_build.groovy`** → Builds a Docker image from source code  
- **`docker_push.groovy`** → Pushes the Docker image to a container registry  
- **`docker_compose.groovy`** → Deploys services using Docker Compose  
- **`docker_cleanup.groovy`** → Cleans up unused Docker images and containers  

---

### 🔍 Security & Code Quality
- **`trivy_scan.groovy`** → Performs vulnerability scanning on Docker images using Trivy  
- **`owasp_dependency.groovy`** → Scans project dependencies for known vulnerabilities (OWASP)  
- **`sonarqube_analysis.groovy`** → Runs static code analysis using SonarQube  
- **`sonarqube_code_quality.groovy`** → Enforces SonarQube Quality Gate  

---

### 🧪 Utility
- **`hello.groovy`** → A sample/test script to verify library integration  

---

## 🚀 Final Note

This project demonstrates how reusable Jenkins Shared Libraries can simplify CI/CD pipelines and improve development efficiency.

Contributions and suggestions are always welcome!!
