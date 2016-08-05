package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> result= new HashMap<String, Cat>();
        result.put("Вася", new Cat("Вася"));result.put("Вася2", new Cat("Вася2"));result.put("Вася3", new Cat("Вася3"));
        result.put("Вася4", new Cat("Вася4"));result.put("Вася5", new Cat("Вася5"));result.put("Вася6", new Cat("Вася6"));
        result.put("Вася7", new Cat("Вася7"));result.put("Вася8", new Cat("Вася8"));result.put("Вася9", new Cat("Вася9"));
        result.put("Вася10", new Cat("Вася10"));
        return  result;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> listCats = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair: map.entrySet())
        listCats.add(pair.getValue());
        return listCats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
