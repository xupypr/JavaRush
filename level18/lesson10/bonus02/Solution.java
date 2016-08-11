package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-c") && args.length==4)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader file;
            StringBuilder result = new StringBuilder();
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            String line;
            int idEnd = 0;
            try
            {
                file = new BufferedReader(new FileReader(fileName));
                while ((line = file.readLine()) != null)
                {
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id > idEnd) idEnd = id;
                }
                file.close();
                idEnd++;
            }
            catch (FileNotFoundException e)
            {
            }
            result.append(String.valueOf(idEnd));
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
            BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName, true));
            fileWrite.write(result.toString());
            fileWrite.close();
        }
    }
}
