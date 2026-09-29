#!/bin/bash

# Creiamo le sottocartelle necessarie con i permessi giusti subito
mkdir -p ./data/h2

docker run -d \
  --name keycloak \
  -p 7080:8080 \
  -u root \
  -e KC_BOOTSTRAP_ADMIN_USERNAME=admin \
  -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin \
  -v "$(pwd)/data:/opt/keycloak/data" \
  quay.io/keycloak/keycloak:26.5.5 \
  start-dev
