package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        String file3=reader.readLine();
        FileInputStream fileInputStream1=new FileInputStream(file1);
        FileOutputStream fileOutputStream1=new FileOutputStream(file2);
        FileOutputStream fileOutputStream2=new FileOutputStream(file3);
        if (fileInputStream1.available()>0)
        {
            byte[] bufer1 = new byte[fileInputStream1.available() / 2 + fileInputStream1.available() % 2];
            byte[] bufer2 = new byte[fileInputStream1.available() / 2];
            fileInputStream1.read(bufer1);
            fileInputStream1.read(bufer2);
            fileInputStream1.close();
            fileOutputStream1.write(bufer1);
            fileOutputStream2.write(bufer2);
        }
        fileOutputStream1.close();
        fileOutputStream2.close();
        reader.close();


    }
}
