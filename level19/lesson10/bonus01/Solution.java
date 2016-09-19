package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        List<String> file1Lines = new ArrayList<>();
        List<String> file2Lines = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1Name=reader.readLine();
        String file2Name=reader.readLine();
        reader.close();
        BufferedReader file1=new BufferedReader(new FileReader(file1Name));
        BufferedReader file2=new BufferedReader(new FileReader(file2Name));
        String line;
        while ((line=file1.readLine())!=null) file1Lines.add(line);
        while ((line=file2.readLine())!=null) file2Lines.add(line);
        file1.close();
        file2.close();
        int ind=0;
        for (int i=0;i<file2Lines.size();i++)
        {
            String tmp=file2Lines.get(i);
            if (file1Lines.contains(tmp))
            {
                while (!file1Lines.get(0).equals(tmp))
                {
                    lines.add(ind++,new LineItem(Type.REMOVED,file1Lines.get(0)));
                    file1Lines.remove(0);
                }
                lines.add(ind++,new LineItem(Type.SAME,tmp));
                file1Lines.remove(0);
            }
            else
            {
                lines.add(ind++,new LineItem(Type.ADDED,tmp));
            }
        }
        for (String s:file1Lines) lines.add(ind++,new LineItem(Type.REMOVED,s));

        for (LineItem a:lines) System.out.println(a.type + " " + a.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
