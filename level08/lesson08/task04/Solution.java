package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map=createMap();
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key=pair.getKey();
            System.out.println(key);
        }
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key=pair.getKey();
            System.out.println(key);
        }

    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Kag", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("AUG 2 1980"));
        map.put("Stallone3", new Date("JAN 3 1980"));
        map.put("Stallone4", new Date("JAN 5 1980"));
        map.put("Stallone5", new Date("JAN 4 1980"));
        map.put("Stallone6", new Date("JAN 1 1980"));
        map.put("Stallone7", new Date("JAN 1 1980"));
        map.put("Stallone8", new Date("JAN 1 1980"));
        map.put("Stallone9", new Date("JAN 3 1980"));
        return  map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        ArrayList<String> list= new ArrayList<String >();
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key=pair.getKey();
            Date date = pair.getValue();
            if (date.getMonth()>4 && date.getMonth()<8) list.add(key);
        }
        for (String s: list) map.remove(s);
    }
}
