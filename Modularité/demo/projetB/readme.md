creation d'un dossier out

mkdir -p out

# Compile service.api
javac -d out/service.api service.api/src/module-info.java service.api/src/com/service/api/GreetingService.java

# Compile service.impl.english
javac -d out/service.impl.english --module-path out service.impl.english/src/module-info.java service.impl.english/src/com/service/impl/english/EnglishGreetingService.java

# Compile service.impl.french
javac -d out/service.impl.french --module-path out service.impl.french/src/module-info.java service.impl.french/src/com/service/impl/french/FrenchGreetingService.java

# Compile service.consumer
javac -d out/service.consumer --module-path out service.consumer/src/module-info.java service.consumer/src/com/service/consumer/MainApp.java

# Execution du programme principale
java --module-path out -m service.consumer/com.service.consumer.MainApp