package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human pavel=new Human("Павел", true, 54, null, null);
        Human igor=new Human("Игорь", true, 57, null, null);
        Human katia= new Human("Катя", false, 55, null, null);
        Human liza= new Human("Лиза",false, 54, null, null);
        Human ania=new Human("Аня", false, 21,pavel, katia);
        Human gena= new Human("Гена", true, 23, igor, liza);
        Human goga=new Human("Гога", true, 1, gena, ania);
        Human nata=new Human("Настя", false, 2, gena, ania);
        Human ksu=new Human("Ксюша", false, 3, gena, ania);
        System.out.println(pavel);
        System.out.println(igor);
        System.out.println(katia);
        System.out.println(liza);
        System.out.println(ania);
        System.out.println(gena);
        System.out.println(goga);
        System.out.println(nata);
        System.out.println(ksu);

    }


    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
