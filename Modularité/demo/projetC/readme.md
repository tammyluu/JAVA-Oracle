# compilation

#### Étape 1 : Compiler `moduleG` et générer le `.jar`
```cmd
javac -d out\moduleG moduleG\src\module-info.java moduleG\src\ingredient\Ingredient.java
jar --create --file libs/moduleG.jar --module-version 1.0 -C out\moduleG .
```

#### Étape 2 : Compiler `moduleH` en utilisant le `.jar` de `moduleG` et générer son `.jar`
```cmd
javac -d out\moduleH --module-path libs moduleH\src\module-info.java moduleH\src\recipes\Recipe.java moduleH\src\recipes\RecipeManager.java
jar --create --file libs/moduleH.jar --module-version 1.0 --main-class recipes.RecipeManager -C out\moduleH .
```

#### Étape 3 : Compiler `moduleI` en utilisant les `.jar` des modules `moduleG` et `moduleH`, et générer son `.jar`
```cmd
javac -d out\moduleI --module-path libs moduleI\src\module-info.java moduleI\src\mainAppI\Main.java
jar --create --file libs/moduleI.jar --module-version 1.0 --main-class mainAppI.Main -C out\moduleI .
```

#### Étape 4 : Exécuter l'application principale
```cmd
java --module-path libs -m moduleI
```