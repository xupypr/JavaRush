package com.javarush.test.level15.lesson12.bonus01;


public class Plane implements Flyable
{
    int passCount=0;
    public Plane(int passCount) {
        this.passCount=passCount;
    }

    @Override
    public void fly()
    {

    }
}
