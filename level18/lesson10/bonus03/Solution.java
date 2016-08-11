package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer,String> list=new TreeMap<>();
        if (args[0].equals("-u") || args[0].equals("-d"))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader file;
            StringBuilder result = new StringBuilder();
            String line;
            int count=0;
            if (args.length>2)
            {
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];
                result.append(args[1]);
                for (int i = result.length(); i < 8; i++) result.append(" ");
                if (productName.length() > 30) result.append(productName.substring(0, 30));
                else
                {
                    result.append(productName);
                    for (int i = productName.length(); i < 30; i++) result.append(" ");
                }
                result.append(price);
                for (int i = price.length(); i < 8; i++) result.append(" ");
                result.append(quantity);
                for (int i = quantity.length(); i < 4; i++) result.append(" ");
            }
            try
            {
                file = new BufferedReader(new FileReader(fileName));
                while ((line = file.readLine()) != null)
                {
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id==Integer.parseInt(args[1]))
                    {
                        if (args[0].equals("-u"))
                        {
                            list.put(count,result.toString());
                            count++;
                        }
                    }
                    else
                    {
                        list.put(count,line);
                        count++;
                    }
                }
                file.close();
            }
            catch (FileNotFoundException e)
            {
            }
            BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName));
            for (Map.Entry entry:list.entrySet())  {fileWrite.write((String) entry.getValue());fileWrite.newLine();}
            fileWrite.close();
        }
    }
}
