package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataTransformerDemo {
    public static void main(String[] args) {
        DataTransformer<Integer> doubleValue = num -> num*2;
        System.out.println("Double de 5 :"+ doubleValue.transform(5));

        DataTransformer<String> addPrefix = str -> "Prefixe_"+str;
        System.out.println("Avec préfixe : "+ addPrefix.transform("test"));

        DataTransformer<List<Integer>> sortList = list ->{
            Collections.sort(list);
            return list;
        };
        List<Integer> numbers = Arrays.asList(4,6,7,1,8);
        System.out.println("Liste triée : "+sortList.transform(numbers));
    }
}
