mvn package -Pnative -Dquarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.native-micro -t ghcr.io/pagopa/urlenctest:latest .
docker login ghcr.io -u ...
docker push ghcr.io/pagopa/urlenctest:latest