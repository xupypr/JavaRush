package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int weight;
    private int age;
    private String address;
    private String color;

    public Cat (String name) {
        this.name=name;
    }

    public Cat (String name, int weight, int age) {
        this.name=name;
        this.weight=weight;
        this.age=age;
    }

    public Cat (String name, int age) {
        this.name=name;
        this.weight=12;
        this.age=age;
    }

    public Cat (int weight, String color) {
        this.weight=weight;
        this.color=color;
        this.age=1;
        this.address=null;
        this.name=null;
    }

    public Cat (int weight, String color, String address,Cat otherCat) {
        this.weight=weight;
        this.color=color;
        this.age=otherCat.age;
        this.address=address;
        this.name=otherCat.name;
    }
}
