package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private static int cnt=0;
    private int a=0;
    private static Singleton newSingleton;

    private Singleton(int a) {
        this.a=a;
        cnt++;
    }

    public static Singleton getInstance() {
        if (cnt==0) newSingleton=new Singleton(25);
        return newSingleton;
    }
}
