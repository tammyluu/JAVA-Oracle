package org.example;

public class Salmon {
    int count;
    {
        System.out.println(count + "-");
    }
    {count++;}
    public Salmon() {
        count = 4;
        System.out.println(2+ "-");
    }

    public static void main(String[] args) {
        System.out.println(7+"-");
        var s = new Salmon();
        System.out.println(s.count + "-");
    }
}
