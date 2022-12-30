# Microservices
### Desenvolvendo arquitetura de microservices com Spring boot cloud
- Microservices
  - Clientes
  - Cartoes
  - Avaliador de Credito
  - Gateway
- Eureka Server / Client
- Feign Client
- Comunicação entre microservices
- Segurança da API 
  - Keycloak
- Serviço de Mensageria
  - RabbitMQ
- Docker(imagens)
  - docker run -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management
  - docker run --name keycloak -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev

