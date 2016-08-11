package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> bytesList= new HashMap<Integer,Integer>();
        int max=1;
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
                if (count>max) max=count;
            }
            else
            {
                bytesList.put(tmp,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry: bytesList.entrySet())
        {
            if (entry.getValue()==max) System.out.print(entry.getKey()+" ");
        }
            file.close();
    }
}
