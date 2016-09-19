package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag=args[0];
        if (tag.equals("CDATA")) return;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuilder string=new StringBuilder();
        String line;
        while ((line=file.readLine())!=null)
        {
            string.append(line);
            if (string.toString().endsWith(tag)) string.append(" ");
        }
        file.close();
        new Solution().showTags(string.toString(),tag);
    }
    public void showTags(String string, String tag) throws IOException
    {
        if (string.length()==0) return;
        String buf[]=string.toString().split("<");
        String result="";
        int openedTags=0;
        int closedTags=0;
        boolean write=false;
        for (String s:buf)
        {
                try
                {
                    if (!write && s.substring(0,tag.length()+1).equals(tag+" ") || s.substring(0,tag.length()+1).equals(tag+">")) write=true;
                    if (s.length()>=tag.length()+2)
                        if (write && s.substring(0,tag.length()+2).equals("/"+tag+">") && (openedTags-1)==closedTags) {s="/"+tag+">";closedTags++;}
                        else if (write && s.substring(0,tag.length()+2).equals("/"+tag+">")) closedTags++;
                    if (write) result+="<" + s;
                    if (s.substring(0,tag.length()+1).equals(tag+" ") || s.substring(0,tag.length()+1).equals(tag+">")) openedTags++;

                    if (openedTags==closedTags && openedTags>0)
                    {
                        System.out.println(result);
                        if (openedTags>1) showTags(result.substring(tag.length(),result.length()-tag.length()),tag);
                        result="";
                        openedTags=0;
                        closedTags=0;
                        write=false;
                    }
                }
                catch (IndexOutOfBoundsException e){}
        }
    }
}