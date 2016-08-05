package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int mount){
        String season="зима";
        if (mount<=5 && mount>=3) season="весна";
        if (mount<=8 && mount>=6) season="лето";
        if (mount<=11 && mount>=9) season="осень";
        System.out.println(season);
    }
}