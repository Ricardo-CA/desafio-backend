# Use a imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Definir variáveis de ambiente para habilitar o Spring Boot Actuator's Prometheus endpoint
ENV MANAGEMENT_ENDPOINT_METRICS_ENABLED=true
ENV MANAGEMENT_ENDPOINTS_WEB_EXPOSURE_INCLUDE=*

# VOLUME /tmp permite que o Spring Boot crie arquivos temporários em sua localização padrão "/tmp".
# Esses arquivos temporários podem incluir arquivos de sessão e outras coisas.
VOLUME /tmp

# Adicione seu aplicativo jar como "app.jar" ao contêiner
ADD target/desafio-backend-0.0.1-SNAPSHOT.jar desafio-backend-0.0.1-SNAPSHOT.jar

# O "touch" é usado para mudar a data de modificação do arquivo.
# Isso é útil porque alguns sistemas operacionais como Ubuntu, por exemplo, podem ter problemas de cache com o Docker.
RUN sh -c 'touch /desafio-backend-0.0.1-SNAPSHOT.jar'

# Comando para executar o aplicativo
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/desafio-backend-0.0.1-SNAPSHOT.jar"]
