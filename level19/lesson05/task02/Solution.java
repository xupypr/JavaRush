package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();
        BufferedReader file;
        try
        {
            file=new BufferedReader(new FileReader(fileName));
            String line="";
            int count=0;
            while ((line=file.readLine())!=null)
            {
                String buf[]=line.split("[., !?;:-]");
                for (int i=0;i<buf.length;i++) if (buf[i].equals("world")) count++;
            }
            file.close();
            System.out.println(count);
        }
        catch (FileNotFoundException e)
        {

        }
    }
}
