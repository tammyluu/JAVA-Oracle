# Demonstration en ligne de commande

## Compilation

#### Compiler le module `moduleA`
```powershell
javac -d moduleA\bin moduleA\src\module-info.java moduleA\src\myPackage\*.java moduleA\src\myPackage\subPackage\*.java moduleA\src\mySecondPackage\*.java
```

#### Compiler le module `moduleC`
```powershell
javac --module-path "moduleA\bin" -d moduleC\bin moduleC\src\module-info.java moduleC\src\selectivePackage\*.java
```

#### Compiler le module `moduleB`
```powershell
javac --module-path "moduleA\bin;moduleC\bin" -d moduleB\bin moduleB\src\module-info.java moduleB\src\app\*.java
```

#### Compiler le module `moduleE`
```powershell
javac --module-path "moduleA\bin" -d moduleE\bin moduleE\src\module-info.java moduleE\src\openPackage\*.java
```

#### Compiler le module `moduleD`
```powershell
javac --module-path "moduleA\bin;moduleB\bin;moduleC\bin" -d moduleD\bin moduleD\src\module-info.java moduleD\src\mainApp\*.java
```

#### Compiler le module `moduleF`
```powershell
javac --module-path "moduleA\bin;moduleD\bin;moduleE\bin" -d moduleF\bin moduleF\src\module-info.java moduleF\src\mainAppF\*.java
```

## Exécuter

#### Exécuter le programme principal de `moduleB`
```powershell
java --module-path "moduleA\bin;moduleB\bin;moduleC\bin" --module moduleB/app.Main
```

#### Exécuter le programme principal de `moduleD`
```powershell
java --module-path "moduleA\bin;moduleB\bin;moduleC\bin;moduleD\bin" --module moduleD/mainApp.Main
```

#### Exécuter le programme principal de `moduleF`
```powershell
java --module-path "moduleA\bin;moduleD\bin;moduleE\bin;moduleF\bin" --module moduleF/mainAppF.Main
```
