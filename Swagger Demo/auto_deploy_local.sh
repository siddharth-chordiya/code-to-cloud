#!/bin/bash

####  This file contains script to pull latest docker image from docker hub
####  and deploy it locally and cleanup old versions of images if any.


## stop script immediately if any command fails
set -e

## variables
IMAGE="{{YOUR_DOCKER_USERNAME}}/swagger-demo:latest"
DEPLOYMENT="swagger-demo"

echo "🚀 Starting auto deployment... $DEPLOYMENT"
  
  # Step 1: Pull latest image
echo "📥 Pulling latest image -> $IMAGE from Docker Hub..."
docker pull $IMAGE
  
  # Step 2: Create/Restart new kubernetes deployment
echo "🔄 Starting Kubernetes deployment..."
kubectl apply -f k8s/
kubectl rollout restart deployment $DEPLOYMENT
  
  # Step 3: Wait for rollout to complete
echo "⏳ Waiting for rollout to complete..."
kubectl rollout status deployment $DEPLOYMENT
echo "Rollout completed!!"

  # Step 4: Clean only dangling (<none>) images
echo "🧹 Cleaning dangling (<none>) Docker images from Docker desktop..."
docker image prune -f

echo "✅ Deployment successful and cleanup done!"