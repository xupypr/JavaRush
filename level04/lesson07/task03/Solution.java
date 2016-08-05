package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner=new Scanner(System.in);
        int[] a=new int[3];
        int b=0;
        for (int i=0;i<3;i++) {
            a[i]=scanner.nextInt();
            if (a[i]>0) b++;
        }
        System.out.println(b);
    }
}
