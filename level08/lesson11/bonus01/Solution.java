package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Jan",1); map.put("Feb",2); map.put("Mar",3); map.put("Apr",4); map.put("May",5); map.put("Jun",6); map.put("Jul",7); map.put("Aug",8); map.put("Sep",9); map.put("Oct",10); map.put("Nov",11); map.put("Dec",12);
        String month = reader.readLine();
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            if (month.contains(pair.getKey()) )
            {
                System.out.println(month + " is " + pair.getValue() + " month");
                break;
            }
        }
    }

}
