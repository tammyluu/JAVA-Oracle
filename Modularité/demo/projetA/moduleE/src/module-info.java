module moduleE {
    exports openPackage;
    opens openPackage to moduleF; // provoque une erreur sur le module F si commenté
}