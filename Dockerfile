# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt
RUN wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar -xvf apache-maven-3.6.3-bin.tar.gz
RUN mv apache-maven-3.6.3 maven
RUN ls
ENV M2_HOME="/opt/maven"
ENV PATH="$M2_HOME/bin:$PATH"
RUN mvn -version
WORKDIR /app
COPY ./ .
RUN mvn clean install
EXPOSE 8080
ENTRYPOINT ["./scripts/run.sh"]






