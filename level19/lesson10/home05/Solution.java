package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1=args[0];
        String fileName2=args[1];
        BufferedReader file= new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2= new BufferedWriter(new FileWriter(fileName2));
        String line="";
        while ((line=file.readLine())!=null)
        {
            String buf[]=line.trim().split(" ");
            for (String a:buf) if (a.matches(".*\\d.*")) file2.write(a+ " ");
        }
        file.close();
        file2.close();
    }
}
