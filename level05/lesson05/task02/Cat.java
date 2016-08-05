package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight(Cat anotherCat)
    {
        int rate1=this.weight * this.strength;
        if (this.age >1 && this.age <8) rate1*=(1+this.age/10); else rate1/=2;
        int rate2=anotherCat.weight * anotherCat.strength;
        if (anotherCat.age >1 && anotherCat.age <8) rate2*=(1+anotherCat.age/10); else rate2/=2;
        if (rate1>=rate2) return true; else return false;

    }
}
