package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1 -52
        /*final int score1 = 8, score2 = 3;
        Integer myScore = 7;
        var goal = switch (myScore) {
        case score1, score2, 7 -> "good";
        case Integer i when i < 10 -> "better";
        case Integer i when i >= 10 -> "best";
        default -> { yield "unknown";}
        case null -> "nope";
        };
        System.out.print(goal);*/


        //2 -53
      /*  int moon = 9, star = 2 + 2 * 3;
        float sun = star > 10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println(sun + ", " + jupiter + ", " + mars);*/

        //4
    /* Predicate<String> empty = String::isEmpty;
     Predicate<String> notEmpty = empty.negate();

     var result = Stream.generate(() -> "")
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                 .stream()
                 .map(Entry::getValue)
                    .flatMap(Collection::stream)
                 .collect(Collectors.partitioningBy(notEmpty));
     System.out.println(result);*/

        //7
    /*Penguin.properties
            name=Billy
    age=1
    Penguin_de.properties
            name=Chilly
    age=4
    Penguin_en.properties
            name=Willy
    Locale fr = Locale.of("fr");
    Locale.setDefault(Locale.of("en", "US"));
    var b = ResourceBundle.getBundle("Penguin", fr);
    System.out.println(b.getString("name"));
    System.out.println(b.getString("age"));*/

        //7
        /*int[] array = {6, 9, 8};
        System.out.println("B" + Arrays.binarySearch(array, 9));
        System.out.println("C" + Arrays.compare(array,
                new int[]{6, 9, 8}));
        System.out.println("M" + Arrays.mismatch(array,
                new int[]{6, 9, 8}));*/
        
        //18
        /*var pooh = """
        "Oh, bother." -Pooh
        """.indent(1);
        System.out.print(pooh);*/



    }

    // 5
    /* class MathFunctions {
         public static void addToInt(int x, int amountToAdd) {
             x = x + amountToAdd % -5;
         }

         public static void main(String[] args) {
             var a = 15;
             var b = 10;
             MathFunctions.addToInt(a, b);
             System.out.println(a);
         }
     }*/
    
 


} /*
//17

class FeedingSchedule {
public static void main(String[] args) {
        var x = 5;
        var j = 0;
        OUTER: for (var i = 0; i < 3;)
        INNER: do {
        i++;
        x++;
        if (x> 10) break INNER;
        x += 4;
        j++;
        } while (j <= 2);
        System.out.println(x);
        }
}
*/
