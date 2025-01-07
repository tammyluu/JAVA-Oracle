creation d'un dossier out

mkdir -p out

# compilation

#### Étape 1 : Compiler `module bookAPI` 
```cmd
javac -d out/bookAPI bookAPI/src/module-info.java bookAPI/src/book/Book.java


#### Étape 2 : Compiler `module checkOut` 
```cmd
javac -d out/checkOut --module-path out checkOut/src/module-info.java checkOut/src/checkOut/CheckoutSystem.java


#### Étape 3 : Compiler `module inventory` 
```cmd
javac -d out/inventory --module-path out inventory/src/module-info.java inventory/src/inventory/BookInventory.java

#### Étape 4 : Compiler `module notificationService` 
```cmd
javac -d out/notificationService --module-path out notificationService/src/module-info.java notificationService/src/notificationService/NotificationService.java

#### Étape 4 : Compiler `module emailNotification` 
```cmd
javac -d out/emailNotification --module-path out emailNotification/src/module-info.java emailNotification/src/emailNotification/EmailNotification.java

#### Étape 5 : Compiler `module report` 
```cmd
javac -d out/report --module-path out report/src/module-info.java report/src/reports/InventoryReport.java

#### Étape 6 : Compiler `module app` 
```cmd
javac -d out/app --module-path out app/src/module-info.java app/src/app/LibraryApp.java

# Execution du programme principale
java --module-path out -m app/app.LibraryApp