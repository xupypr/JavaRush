package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {

        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format2= new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Person buf=null;
        if (args.length>0)
        {
            if (args[0].equals("-c") && args.length == 4)
            {
                int index = allPeople.size();
                String name = args[1];
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(name, format.parse(args[3])));
                else allPeople.add(index, Person.createFemale(name, format.parse(args[3])));
                System.out.println(index);
            }
            if (args[0].equals("-u") && args.length == 5)
            {
                buf = allPeople.get(Integer.parseInt(args[1]));
                buf.setName(args[2]);
                buf.setSex(args[3] == "м" ? Sex.MALE : Sex.FEMALE);
                buf.setBirthDay(format.parse(args[4]));
            }
            if (args[0].equals("-d") && args.length == 2)
            {
                buf = allPeople.get(Integer.parseInt(args[1]));
                buf.setBirthDay(null);
                buf.setSex(null);
                buf.setName("");
            }
            if (args[0].equals("-i") && args.length == 2)
            {
                buf = allPeople.get(Integer.parseInt(args[1]));
                String sex = buf.getSex() == Sex.MALE ? "м " : "ж ";
                System.out.println(buf.getName() + " " + sex + format2.format(buf.getBirthDay()));
            }
        }
    }
}
