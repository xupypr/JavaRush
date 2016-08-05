package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandDadName = reader.readLine();
        Cat catGrandDad = new Cat(grandDadName);

        String grandMotherName = reader.readLine();
        Cat catGradMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGrandDad, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGradMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat (sonName, catFather,catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catGrandDad);
        System.out.println(catGradMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);

    }

    public static class Cat
    {
        private String name;

        public Cat getParentM()
        {
            return parentM;
        }

        public void setParentM(Cat parentM)
        {
            this.parentM = parentM;
        }

        public Cat getParentW()
        {
            return parentW;
        }

        public void setParentW(Cat parentW)
        {
            this.parentW = parentW;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        private Cat parentM;
        private Cat parentW;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentM, Cat parentW)
        {
            this.name = name;
            this.parentM = parentM;
            this.parentW = parentW;
        }


        @Override
        public String toString()
        {
            String returnString = "Cat name is " + name;
            if (parentW == null)
                returnString += ", no mother";
            else
                returnString += ", mother is " + parentW.getName();
            if (parentM == null)
                returnString += ", no father";
            else
                returnString += ", father is " + parentM.getName();
            return returnString;
        }
    }

}
