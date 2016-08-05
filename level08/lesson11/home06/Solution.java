package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1=new Human("Вася",true,12);
        Human child2=new Human("Лена",false,5);
        Human child3=new Human("Катя",false,3);
        Human father=new Human("Гена",true,33);
        father.addChild(child1);father.addChild(child2);father.addChild(child3);
        Human mother=new Human("Аня", false,31);
        mother.addChild(child1);mother.addChild(child2);mother.addChild(child3);
        Human grandMother1= new Human("Клава", false, 64);
        grandMother1.addChild(father);
        Human grandMother2= new Human("Иван", false, 66);
        grandMother2.addChild(mother);
        Human grandDad1= new Human("Соня", false, 61);
        grandDad1.addChild(father);
        Human grandDad2= new Human("Гурам", false, 60);
        grandDad2.addChild(mother);

        System.out.println(grandDad1);System.out.println(grandDad2);
        System.out.println(grandMother1);System.out.println(grandMother2);
        System.out.println(father);System.out.println(mother);
        System.out.println(child1);System.out.println(child2);System.out.println(child3);

    }


    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }

        public Human(String name, Boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public void addChild(Human child)
        {
            this.children.add(child);
        }
    }

}
