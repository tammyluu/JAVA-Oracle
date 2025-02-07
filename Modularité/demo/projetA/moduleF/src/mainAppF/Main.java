package mainAppF;

import java.lang.reflect.Field;
import openPackage.People;

public class Main {
    public static void main(String[] args) {
        People people = new People("Alice", 30);
        printFields(people); // Inspecte et affiche les champs privés
    }

    public static void printFields(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Permet l’accès aux champs privés
            try {
                System.out.println(field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}