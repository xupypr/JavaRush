package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int c= scanner.nextInt();
        boolean aTrue=false, bTrue=false, cTrue=false;
        if (a==b) {aTrue=true;bTrue=true;}
        if (a==c) {aTrue=true;cTrue=true;}
        if (b==c) {bTrue=true;cTrue=true;}
        if (aTrue) System.out.print(a+ " ");
        if (bTrue) System.out.print(b+ " ");
        if (cTrue) System.out.print(c+ " ");

    }
}