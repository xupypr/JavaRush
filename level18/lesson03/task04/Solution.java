package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> bytesList= new HashMap<Integer,Integer>();
        int min=65000;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        while (file.available()>0)
        {
            int tmp=file.read();
            if (bytesList.containsKey(tmp))
            {
                int count=bytesList.get(tmp)+1;
                bytesList.put(tmp, count);
            }
            else
            {
                bytesList.put(tmp,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry: bytesList.entrySet()) if (entry.getValue()<min) min=entry.getValue();

            for (Map.Entry<Integer,Integer> entry: bytesList.entrySet())
        {
            if (entry.getValue()==min) System.out.print(entry.getKey()+" ");
        }
        file.close();
    }
}
