package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Чиж", "Александр");
        map.put("Чиж2", "Александр");
        map.put("Чиж3", "Александр");
        map.put("Чиж4", "Александр");
        map.put("Чиж5", "Александр");
        map.put("Чиж6", "Александр");
        map.put("Чиж7", "Александр");
        map.put("Чиж8", "Александр");
        map.put("Чиж9", "Александр");
        map.put("Чиж0", "Александр");
        return (HashMap<String, String>) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getValue();
            if (key.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (key.equals(lastName)) count++;
        }
        return count;
    }
}
