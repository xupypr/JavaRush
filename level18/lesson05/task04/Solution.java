package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        FileInputStream fileInputStream=new FileInputStream(file1);
        FileOutputStream fileOutputStream=new FileOutputStream(file2);
        if (fileInputStream.available()>0)
        {
            byte[] bufer=new byte[fileInputStream.available()];
            byte tmp;
            int count=fileInputStream.read(bufer);
            fileInputStream.close();
                for (byte i=0;i<count/2;i++)
                {
                    tmp=bufer[i];
                    bufer[i]=bufer[count-1-i];
                    bufer[count-1-i]=tmp;
                }
            fileOutputStream.write(bufer,0,count);
            fileOutputStream.close();
            reader.close();
        }
    }
}
