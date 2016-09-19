package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        BufferedReader fileReader=new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter=new BufferedWriter(new FileWriter(file2));
        String line;
        while ((line=fileReader.readLine())!=null)
        {
            String buf[]=line.trim().split(" ");
            for (int i=0;i<buf.length;i++)
            {
                try
                {
                    int a=Integer.parseInt(buf[i]);
                    fileWriter.write(buf[i]+" ");
                }
                catch (NumberFormatException e)
                {
                }
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
