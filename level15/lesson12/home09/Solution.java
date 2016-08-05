package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            ArrayList<String> paramList=new ArrayList<>();
            ArrayList<String> paramValueList=new ArrayList<>();
            String str=reader.readLine();
            String[] splitStr=str.trim().split("\\?");
            String paramStr="";
            for (String s: splitStr) paramStr=s;
            splitStr=paramStr.trim().split("&");
            for (String s:splitStr)
            {
                boolean first=true;
                String firstValue="";
                String[] tmp=s.trim().split("=");
                for (String a:tmp)
                {

                    if (first)
                    {
                        paramList.add(a);
                        first=false;
                        firstValue=a;
                    }
                    else
                    {
                        if (firstValue.equals("obj")) paramValueList.add(a);
                        break;
                    }

                }
            }
            for (String s: paramList) System.out.print(s + " ");
            System.out.println();
            for (String s: paramValueList)
            {
                try
                {
                    alert(Double.parseDouble(s));
                }
                catch (NumberFormatException e)
                {
                    alert(s);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
