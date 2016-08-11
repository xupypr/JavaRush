package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> bytesList= new TreeSet<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        while (file.available()>0)
        {
            int tmp=file.read();
            if (!bytesList.contains(tmp)) bytesList.add(tmp);
        }
        for (int a: bytesList) System.out.print(a + " ");
        file.close();
    }
}
