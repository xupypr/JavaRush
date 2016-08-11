package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count=0;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream file=new FileInputStream(fileName);
        while (file.available()>0)
        {
            if (file.read()==44) count++;
        }
        System.out.println(count);
        file.close();
        reader.close();
    }
}
