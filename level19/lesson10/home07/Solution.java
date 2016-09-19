package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1=args[0];
        String fileName2=args[1];
        BufferedReader file= new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2= new BufferedWriter(new FileWriter(fileName2));
        String line="";
        StringBuilder writeLine=new StringBuilder();
        while ((line=file.readLine())!=null)
        {
            String buf[]=line.trim().split(" ");
            for (String a:buf) if (a.length()>6) writeLine.append(a+",");
        }
        file2.write(writeLine.toString().substring(0,writeLine.length()-1));
        file.close();
        file2.close();


    }
}
