package com.javarush.test.level04.lesson10.task03;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int a=scanner.nextInt();
        while (a>0) {System.out.println(str);a--;}

    }
}
