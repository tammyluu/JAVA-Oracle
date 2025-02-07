package org.example;

import java.io.File;
import java.util.Scanner;

public class MyApp {
    private static int z;

    public static void main(String[] args) {
      /*  if (args.length >= 2) {
            System.out.println("parma 1: " + args[0]);
            System.out.println("parma 2: " + args[1]);
        } else {
            System.out.println("Vui lòng nhập ít nhất 2 tham số khi chạy chương trình!");
        }*/

       /* int decimal = 123;     // Số hệ thập phân
        int octal = 017;       // Số hệ bát phân (tương đương 15 trong hệ thập phân)
        int hex = 0xFF;        // Số hệ thập lục phân (tương đương 255)
        int binary = 0b1010;   // Số hệ nhị phân (tương đương 10)

        System.out.println("Decimal: " + decimal);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);
        System.out.println("Binary: " + binary);*/

       /* String pyramid = """
           *
          * *
         * * *
        """;
        System.out.print(pyramid);*/

       // String block = """doe"""; // DOES NOT COMPILE
        String block1 = """
                doe""";

        String block2 = """
                doe
                """;
        String block3 = """
            doe \
            deer""";

        String block4 = """
            doe \n
            deer
            """;

        String block = """
            "doe\"\"\"
            \"deer\"""
            """;
        /*System.out.println(block1);
        System.out.println("*******************");
        System.out.println(block2);
        System.out.println("*******************");
        System.out.println(block3);
        System.out.println("*******************");
        System.out.println(block4);
        System.out.println("*******************");*/

        //System.out.println(block);

    /*    var blocky = """
                squirrel \s
                pigeon   \
                termite""";
        System.out.println(blocky);*/
        /*int x = 3;
        int result = x++ + ++x * 2;
        System.out.println(result);

        int a = 5;
        int b = a-- + ++a + --a + a++;
        System.out.println(b);

        boolean isRaining = false;
        int num = 7;

        System.out.println(!isRaining);
        System.out.println(~num);

        boolean flag = true;
        int number = 10;*/

       /* // Which of these lines cause a compilation error?
        flag++;          // (A)
        --flag;          // (B)
        number++;        // (C)
        System.out.println(++number);  // (D)*/

       /* int parkAttendance = 5;
        System.out.println(parkAttendance++);  // (1)
        System.out.println(++parkAttendance);  // (2)
        System.out.println(parkAttendance);    // (3)
*/
        /*byte a1 = 5;
        short b1 = 10;
        var z1 = a1 + b1;  // Kiểu dữ liệu của z1 là gì?

        int c = 20;
        long d = 30;
        var z2 = c * d;  // Kiểu dữ liệu của z2 là gì?

        float e = 15.5f;
        double f = 2.5;
        var z3 = e / f;  // Kiểu dữ liệu của z3 là gì?

        char g = 'A';  // Giá trị là 65
        var z4 = g + 5;  // Kiểu dữ liệu của z4 là gì?

        System.out.println("z1: " + ((Object) z1).getClass().getSimpleName());
        System.out.println("z2: " + ((Object) z2).getClass().getSimpleName());
        System.out.println("z3: " + ((Object) z3).getClass().getSimpleName());
        System.out.println("z4: " + ((Object) z4).getClass().getSimpleName());*/

        /*short x1 = 8;
        short y1 = 9;
        short result = (x1 * y1);// Lỗi! Tại sao?
       // short result = (short) (x1 * y1);
        System.out.println("Result: " + result);*/

        /*int a = 10;
        int b = 4;
        System.out.println("a / b = " + a / b);
        System.out.println("type: " + ((Object) (a/b)).getClass().getSimpleName());
        System.out.println("a % b = " + a % b);   // Kết quả là gì?
        System.out.println("type: " + ((Object) (a%b)).getClass().getSimpleName());

        double x = 10.0;
        double y = 4.0;
        System.out.println("x / y = " + x / y);   // Kết quả là gì?
        System.out.println("type: " + ((Object) (x/y)).getClass().getSimpleName());
        System.out.println("x % y = " + x % y);   // Kết quả là gì?
        System.out.println("type: " + ((Object) (x%y)).getClass().getSimpleName());*/

     /*   int a = 5;
        int b = 2;
        int result = a++ * --b + b * a;
        System.out.println("Result: " + result);*/

        /*byte a = 10;
        float b = 2.5f;
        double c = 3.2;
        var result = a * b / c;  // Kiểu dữ liệu của result là gì?
        System.out.println("Result: " + result);*/

        /*double d = 12.5;
        int i = (int) (d / 2); // Ép kiểu hợp lệ hay không?
        System.out.println("i = " + i);*/

        /*short s = 5;
       // s = s + 10; // Lỗi! Vì s + 10 được thăng cấp lên int
        s = (short) (s + 10);
        System.out.println("s = " + s);*/

        /*float f = 9.99f;
        //int i = f; // Lỗi! Không thể gán float vào int mà không ép kiểu
        int i = (int) f;
        System.out.println("i = " + i);*/

       /* short x = 10;
        short y = 20;
        //short z = x + y; // Lỗi! Vì x + y được thăng cấp lên int
        short z = (short) (x + y);
        System.out.println("z = " + z);*/

        var monday = new File("schedule.txt");
        var tuesday = new File("schedule.txt");
        var wednesday = tuesday;
        System.out.println(monday == tuesday); // false
        System.out.println(tuesday == wednesday);//true


        System.out.print(null == null);

    }


}
