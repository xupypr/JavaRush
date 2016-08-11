package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=args[0];
        TreeMap<Integer,Integer> list=new TreeMap<>();
        FileInputStream file=new FileInputStream(fileName);
        while (file.available()>0)
        {
            int buf=file.read();

                try
                {
                    int count = list.get(buf);
                    count++;
                    list.put(buf,count);
                }
                catch (NullPointerException e)
                {
                    list.put(buf,1);
                }
        }
        file.close();
        for (Map.Entry<Integer,Integer> entry: list.entrySet())
        {
            int charBuf=entry.getKey();
            System.out.println((char) charBuf + " " + entry.getValue());
        }
    }
}
