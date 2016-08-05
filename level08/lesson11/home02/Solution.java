package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        result.add(new Cat ("Вася",2));
        result.add(new Cat ("Барсик",1));
        result.add(new Cat ("Том",2));
        result.add(new Cat ("Жора",4));

        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> result = new HashSet<Dog>();

        result.add(new Dog("Шарик",5));
        result.add(new Dog("Бобик",2));
        result.add(new Dog("Барбос",3));

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        HashSet<Object> result= new HashSet<Object>();
        Iterator<Cat> catIterator=cats.iterator();
        while (catIterator.hasNext()) result.add(catIterator.next());
        Iterator<Dog> dogIterator=dogs.iterator();
        while (dogIterator.hasNext()) result.add(dogIterator.next());
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        for (Cat x : cats)
            pets.remove(x);

    }

    public static void printPets(Set<Object> pets)
    {
        Iterator<Object> petIterator = pets.iterator();
        while (petIterator.hasNext()) System.out.println(petIterator.next());
    }

    public static class Cat {
        String name;
        int age;



        public Cat(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
    }
    public static class Dog {
        String name;
        int age;



        public Dog(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
    }
}
