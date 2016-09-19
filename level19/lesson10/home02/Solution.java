package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=args[0];
        BufferedReader file= new BufferedReader(new FileReader(fileName));
        String line="";
        TreeMap<String,Double> list=new TreeMap<>();
        Double max=0.0;
        while ((line=file.readLine())!=null)
        {
            Double tmp;
            String buf[]=line.trim().split(" ");
            if (!list.containsKey(buf[0]))
            {
                tmp=Double.parseDouble(buf[1]);
            }
            else
            {
                tmp=list.get(buf[0]);
                tmp+=Double.parseDouble(buf[1]);
            }
            list.put(buf[0],tmp);
            if (max<tmp) max=tmp;
        }
        file.close();
        for (Map.Entry entry: list.entrySet()) if (entry.getValue()==max) System.out.println(entry.getKey());

    }
}
