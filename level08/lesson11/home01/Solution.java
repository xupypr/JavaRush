package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Iterator<Cat> catIterator=cats.iterator();
        catIterator.next();
        catIterator.remove();
        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> cat = new HashSet<Cat>();
        cat.add(new Cat("Вася",1));
        cat.add(new Cat("Петя",2));
        cat.add(new Cat("Барсик",3));
        return cat;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> catIterator=cats.iterator();
        while (catIterator.hasNext()) System.out.println(catIterator.next());
    }

    public static class Cat {
        String name;
        int age;

        Cat(String name, int age){
            this.name=name;
            this.age=age;
        }


    }
}
