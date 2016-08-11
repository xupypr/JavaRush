package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer,String> list=new TreeMap<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        FileInputStream fileIn;
        FileOutputStream fileOut;
        byte[] writeBuf=new byte[1000];
        while (!(fileName=reader.readLine()).equals("end"))
        {
            String buf[]=fileName.trim().split(".part");
            list.put(Integer.parseInt(buf[buf.length-1]),buf[0]);
        }
        reader.close();
        boolean firstOpen=false;
        for (Map.Entry entry: list.entrySet())
        {
            fileIn=new FileInputStream(entry.getValue()+".part"+entry.getKey());
            fileOut=new FileOutputStream((String)entry.getValue(),firstOpen);
            firstOpen=true;
            while (fileIn.available()>0)
            {
                int count=fileIn.read(writeBuf);
                fileOut.write(writeBuf,0,count);
            }
            fileIn.close();
            fileOut.close();
        }


    }
}
