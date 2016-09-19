package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName=args[0];
        BufferedReader file= new BufferedReader(new FileReader(fileName));
        String line="";
        GregorianCalendar calendar;
        while ((line=file.readLine())!=null)
        {
            String buf[]=line.trim().split(" ");
            String name="";
            for (int i=0;i<buf.length-3;i++)
            {
                name+=buf[i];
                if (i!=buf.length-4) name+=" ";
            }
            calendar=new GregorianCalendar(Integer.parseInt(buf[buf.length-1]),Integer.parseInt(buf[buf.length-2])-1,Integer.parseInt(buf[buf.length-3]));
            PEOPLE.add(new Person(name,calendar.getTime()));
        }
        file.close();
    }

}
