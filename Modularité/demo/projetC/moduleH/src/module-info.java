module moduleH {
    //requires moduleG;
    requires transitive moduleG; // Expose les ingrédients aux modules consommateurs
    exports recipes; // Exporte les classes liées aux recettes
}