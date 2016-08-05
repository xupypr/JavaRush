package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String buf="";
        int intBuf=0;
        int ind=0;
        TreeSet<Integer> list=new TreeSet<>();
        while ((buf = file.readLine()) != null)
        {
            intBuf=Integer.parseInt(buf);
            if (intBuf%2==0) list.add(intBuf);
        }
        file.close();
            for (int a: list)
            {
            System.out.println(a);
            }
    }
}
