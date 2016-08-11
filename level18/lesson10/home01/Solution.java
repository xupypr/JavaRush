package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count=0;
        int tmp;
        String fileName=args[0];
        String english= "abcdefghijklmnopqrstuvwxyz";
        FileInputStream file = new FileInputStream(fileName);
        while ((tmp=file.read())!=-1) {
            if (english.contains((char)tmp + "".toLowerCase())) count++;
        }
        file.close();
        System.out.println(count);
    }
}
