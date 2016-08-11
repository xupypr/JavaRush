package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(file2);
        FileInputStream fileInputStream2 = new FileInputStream(file3);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        byte[] bufer;
        int count;
        while (fileInputStream1.available()>0)
        {
            bufer = new byte[fileInputStream1.available()];
            count=fileInputStream1.read(bufer);
            fileOutputStream.write(bufer,0,count);
        }
            fileOutputStream.close();
            FileOutputStream fileOutputStream1 = new FileOutputStream(file1, true);
        while (fileInputStream2.available()>0)
        {
            bufer = new byte[fileInputStream2.available()];
            count=fileInputStream2.read(bufer);
            fileOutputStream1.write(bufer,0,count);
        }
            fileInputStream1.close();
            fileInputStream2.close();
            fileOutputStream1.close();
            reader.close();
    }
}
