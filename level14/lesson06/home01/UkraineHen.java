package com.javarush.test.level14.lesson06.home01;


public class UkraineHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 18;
    }
    public String getDescription() {return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
