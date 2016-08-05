package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String tmp;
        Double dblValue;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            tmp=reader.readLine();
            if (tmp.equals("exit")) break;
            try
            {
                if (tmp.contains(".")) print(Double.parseDouble(tmp));
                else
                {
                    Integer intVal=Integer.parseInt(tmp);
                    if (intVal>0 && intVal<128) print(Short.parseShort(tmp));
                    else if (intVal>=128) print(intVal);
                    else print(tmp);
                }
            }
            catch (Exception e)
            {
                print(tmp);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
