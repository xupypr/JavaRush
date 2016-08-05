package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner=new Scanner(System.in);
        int[] a=new int[3];
        int b=0,c=0;
        for (int i=0;i<3;i++) {
            a[i]=scanner.nextInt();
            if (a[i]>0) b++;
            if (a[i]<0) c++;
        }
        System.out.println("количество отрицательных чисел: "+c);
        System.out.println("количество положительных чисел: "+b);
    }
}
