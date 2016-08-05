package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d;
        for (int i=1;i<=3;i++)
        {
            if (c > b)
            {
                d = b;
                b = c;
                c = d;
            }
            if (b > a)
            {
                d = a;
                a = b;
                b = d;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
