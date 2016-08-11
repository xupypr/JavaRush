package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        BufferedReader fileRead1=new BufferedReader(new FileReader(file1));
        BufferedReader fileRead2=new BufferedReader(new FileReader(file2));
        String tmp;
        reader.close();
        while ((tmp=fileRead2.readLine())!=null) list.add(tmp);
        fileRead2.close();
        while ((tmp=fileRead1.readLine())!=null) list.add(tmp);
        fileRead1.close();
        BufferedWriter fileWrite=new BufferedWriter(new FileWriter(file1));
        for (String s:list)
        {
            fileWrite.write(s);
            fileWrite.newLine();
        }
        fileWrite.close();

    }
}
