package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        String day="такого дня недели не существует";
        switch (a) {
            case 1: day="понедельник";break;
            case 2: day="вторник";break;
            case 3: day="среда";break;
            case 4: day="четверг";break;
            case 5: day="пятница";break;
            case 6: day="суббота";break;
            case 7: day="воскресенье";break;
        }
        System.out.println(day);


    }

}