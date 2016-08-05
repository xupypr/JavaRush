package com.javarush.test.level13.lesson11.bonus02;

import java.util.List;

public class RepkaStory
{
    static void tell(List<Person> items) {

        Person first;
        Person second;
        for (int i = items.size() - 2; i >= 0; i--) {
            first = items.get(i + 1);
            second = items.get(i);
            System.out.println(first.getName() + " за "+ second.getNamePadezh());
        }
    }
}
