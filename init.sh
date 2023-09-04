#!/bin/bash

# Prepara o ambiente
rm -rf .idea &&

# Gera imagem
cd  fastfood-management-system  && mvn clean install &&

cd fastfood-system-application/k8s

echo "Iniciando aplicação ..."

# Aplica secrets
kubectl apply -f fastfood-mongo-secrets.yml &&
kubectl apply -f fastfood-secrets.yml &&

# Aplica serviços
kubectl apply -f fastfood-mongo-svc.yml &&
kubectl apply -f fastfood-svc.yml &&

# Aplica PVC (Persistent Volume Claim)
kubectl apply -f fastfood-mongo-pvc.yml &&

# Aplica StatefulSet
kubectl apply -f fastfood-mongo-statefulset.yml &&

# Aplica Deployment
kubectl apply -f fastfood-deployment.yml &&

# Aplica HorizontalPodAutoscaler (HPA)
kubectl apply -f fastfood-hpa.yml &&

# Aplica componentes
kubectl apply -f components.yaml

echo "Aplicação inicializada!"
