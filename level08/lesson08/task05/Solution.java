package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Фам1", "Имя2");map.put("Фам5", "Имя");map.put("Фам8", "Имя");
        map.put("Фам2", "Имя2");map.put("Фам6", "Имя");map.put("Фам9", "Имя");
        map.put("Фам3", "Имя2");map.put("Фам7", "Имя");map.put("Фам0", "Имя");
        map.put("Фам4", "Имя2");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, Integer> repeatName = new HashMap<String, Integer>();
        for (Map.Entry<String, String> pair: map.entrySet())
        {
            String name= pair.getValue();
            if (repeatName.containsKey(name)) repeatName.put(name, repeatName.get(name)+1);
                else repeatName.put(name, 0);
        }
        for (Map.Entry<String, Integer> pair: repeatName.entrySet()) {
        if (pair.getValue()>0) removeItemFromMapByValue(map,pair.getKey());
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
