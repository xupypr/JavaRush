package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int a= Integer.parseInt(bufferedReader.readLine());
        int b= Integer.parseInt(bufferedReader.readLine());
        int c= Integer.parseInt(bufferedReader.readLine());
        int d= Integer.parseInt(bufferedReader.readLine());
        int max=d;
        if (a>=b && a>=c && a>=d) max=a;
        if (b>=a && b>=c && b>=d) max=b;
        if (c>=a && c>=b && c>=d) max=c;
    System.out.println(max);

    }
}
