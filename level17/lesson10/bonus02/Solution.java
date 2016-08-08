package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public synchronized static void main(String[] args) throws ParseException
    {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2= new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int ind=1;
        Person buf=null;
        if (args.length>0)
        {
            if (args[0].equals("-c") && (args.length -1) % 3 == 0)
            {
                while (ind<args.length)
                {
                    int index = allPeople.size();
                    String name = args[ind];
                    if (args[ind+1].equals("м"))
                        allPeople.add(Person.createMale(name, format.parse(args[ind+2])));
                    else allPeople.add(index, Person.createFemale(name, format.parse(args[ind+2])));
                    System.out.println(index);
                    ind+=3;
                }
            }
            if (args[0].equals("-u") && (args.length -1) % 4 == 0)
            {
                while (ind<args.length)
                {
                    buf = allPeople.get(Integer.parseInt(args[ind]));
                    buf.setName(args[ind + 1]);
                    buf.setSex(args[ind + 2] == "м" ? Sex.MALE : Sex.FEMALE);
                    buf.setBirthDay(format.parse(args[ind + 3]));
                    ind += 4;
                }
            }
            if (args[0].equals("-d") && args.length >= 2)
            {
                while (ind<args.length)
                {
                    buf = allPeople.get(Integer.parseInt(args[ind]));
                    buf.setBirthDay(null);
                    buf.setSex(null);
                    buf.setName("");
                    ind++;
                }
            }
            if (args[0].equals("-i") && args.length >= 2)
            {
                while (ind<args.length)
                {
                    buf = allPeople.get(Integer.parseInt(args[ind]));
                    String sex = buf.getSex() == Sex.MALE ? "м " : "ж ";
                    System.out.println(buf.getName() + " " + sex + format2.format(buf.getBirthDay()));
                    ind++;
                }
            }
        }

    }
}
