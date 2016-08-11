package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str;
        Thread myThread;
        while (!(str=reader.readLine()).equals("exit"))
        {
            myThread=new ReadThread(str);
            myThread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName=fileName;
        }
        public void run()
        {
            int maxRateSymb=0, max=0;
            int symbol=0, count;
            HashMap<Integer,Integer> list=new HashMap<>();
            try
            {
                FileInputStream file=new FileInputStream(fileName);
                while (file.available()>0)
                {
                    try
                    {
                        symbol=file.read();
                        count=list.get(symbol);
                        count++;
                        list.put(symbol,count);
                        if (count>max)
                        {
                            max=count;
                            maxRateSymb=symbol;
                        }
                    }
                    catch (NullPointerException e)
                    {
                        list.put(symbol,1);
                    }
                }
                file.close();
                resultMap.put(fileName,maxRateSymb);
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File not found");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
