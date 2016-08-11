package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max=0;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        while (file.available()>0)
        {
            int tmp;
            if ((tmp=file.read())>max) max=tmp;
        }
        file.close();
        reader.close();
        System.out.println(max);
    }
}
