module moduleA {
    exports myPackage; // export du package myPackage pour utiliser la classe Person
    exports mySecondPackage; // export du package mySecondPackage pour utiliser la classe Voiture
    exports myPackage.subPackage; // export du package subPackage pour utiliser la classe Animal
}