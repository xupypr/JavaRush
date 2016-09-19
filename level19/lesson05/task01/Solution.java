package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        boolean even=false;
        FileReader fileReader=new FileReader(file1);
        FileWriter fileWriter=new FileWriter(file2);
        while (fileReader.ready())
        {
            if (even)
            {
                fileWriter.write(fileReader.read());
                even=false;
            }
            else
            {
                even=true;
                fileReader.read();
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
