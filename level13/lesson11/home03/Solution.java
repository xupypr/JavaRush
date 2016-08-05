package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String filename=reader.readLine();
        InputStream fileInput = new FileInputStream(filename);
        while (fileInput.available()>0)
        {
            System.out.print(Character.toChars(fileInput.read()));
        }
        fileInput.close();
    }
}
