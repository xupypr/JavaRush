package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        while ((line=file.readLine())!=null)
        {
            String buf[]=line.trim().split(" ");
            if (!list.containsKey(buf[0]))
            {
                list.put(buf[0],Double.parseDouble(buf[1]));
            }
            else
            {
                Double tmp=list.get(buf[0]);
                tmp+=Double.parseDouble(buf[1]);
                list.put(buf[0],tmp);
            }
        }
        file.close();
        for (Map.Entry entry: list.entrySet()) System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
