./gradlew clean buildDocker
docker run -it -p 8080:8080 ia.nazarov.test/gamesys:0.0.1-snapshot