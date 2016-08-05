package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age, length;
        Human father, mother, kids;

        Human() {this.name="Nobody";}
        Human(String name) {this.name=name;}
        Human(int age) {this.name="Nobody";this.age=age;}
        Human(int age,int length) {this.age=age;this.length=length;}
        Human(String name, int age) {this.name=name;this.age=age;}
        Human(String name, int age, int length) {this.age=age;this.name=name;this.length=length;}
        Human(int length, String name) {this.length=length;this.name=name;}
        Human(String name, Human father, Human mother, Human kids) {this.father=father;this.mother=mother;this.kids=kids;this.name=name;}
        Human(String name, Human kids) {this.name=name;this.kids=kids;}
        Human(String name, Human father, Human mother) {this.father=father;this.mother=mother;this.name=name;}
    }
}
