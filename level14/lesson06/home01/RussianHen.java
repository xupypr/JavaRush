package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 20;
    }
    public String getDescription() {return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
