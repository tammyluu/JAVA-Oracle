## Compilation

### bookapi
```cmd
javac -d bookapi/bin bookapi/src/module-info.java bookapi/src/com/bookapi/*.java
```

### inventory
```cmd
javac --module-path "bookapi/bin;reports/bin" -d inventory/bin inventory/src/module-info.java inventory/src/com/inventory/*.java
```

### reports
```cmd
javac --module-path "bookapi/bin;inventory/bin" -d reports/bin reports/src/module-info.java reports/src/com/reports/*.java
```

### notificationservice
```cmd
javac -d notificationservice/bin notificationservice/src/module-info.java notificationservice/src/com/notificationservice/*.java
```

### emailnotification
```cmd
javac --module-path "notificationservice/bin" -d emailnotification/bin emailnotification/src/module-info.java emailnotification/src/com/emailnotification/*.java
```

### checkout
```cmd
javac --module-path "bookapi/bin;inventory/bin;notificationservice/bin;emailnotification/bin" -d checkout/bin checkout/src/module-info.java checkout/src/com/checkout/*.java
```

### app
```cmd
javac --module-path "checkout/bin;reports/bin" -d app/bin app/src/module-info.java app/src/com/app/*.java
```

## application principale en utilisant les bin
```cmd
java --module-path "bookapi/bin;inventory/bin;checkout/bin;app/bin;reports/bin;notificationservice/bin;emailnotification/bin" --module app/com.app.LibrayApp
```

## creation des .jar (les bin doivent avoir ete genere)

### bookapi
```cmd
jar --create --file=bookapi/bookapi.jar -C bookapi/bin .
```

### inventory
```cmd
jar --create --file=inventory/inventory.jar -C inventory/bin .
```

### notificationservice
```cmd
jar --create --file=notificationservice/notificationservice.jar -C notificationservice/bin .
```

### emailnotification
```cmd
jar --create --file=emailnotification/emailnotification.jar -C emailnotification/bin .
```

### checkout
```cmd
jar --create --file=checkout/checkout.jar -C checkout/bin .
```

### reports
```cmd
jar --create --file=reports/reports.jar -C reports/bin .
```

### app
```cmd
jar --create --file=app/app.jar --main-class=com.app.LibrayApp -C app/bin .
```

## RUNNING THE APPLICATION USING JAR's (recommended)
```cmd
java --module-path "bookapi/bookapi.jar;inventory/inventory.jar;checkout/checkout.jar;app/app.jar;reports/reports.jar;notificationservice/notificationservice.jar;emailnotification/emailnotification.jar" -m app/com.app.LibrayApp
```

