package com.javarush.test.level14.lesson08.home09;

public class Hirva extends Money
{
    public Hirva(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
