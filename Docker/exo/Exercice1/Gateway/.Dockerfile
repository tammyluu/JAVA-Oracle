# Étape 1 : Compilation avec Maven
FROM maven:3.9.4-amazoncorretto-21 AS build

WORKDIR /app

# Copier uniquement les fichiers nécessaires pour télécharger les dépendances en cache
COPY pom.xml /app/

# Télécharger les dépendances Maven pour accélérer les builds futurs
RUN mvn dependency:go-offline

# Copier les sources et compiler
COPY src /app/src
RUN mvn clean package -DskipTests

# Étape 2 : Image pour exécuter l’application
FROM amazoncorretto:21

WORKDIR /app

# Copier le fichier JAR depuis l’étape précédente
COPY --from=build /app/target/*.jar /app/myapp.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
