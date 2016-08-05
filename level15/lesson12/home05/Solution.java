package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(Double a) {};
    private Solution(int a) {};
    private Solution(String a) {};
    protected Solution(Integer a) {};
    protected Solution(Number a) {};
    protected Solution(Boolean a) {};
    public Solution() {};
    public Solution(float a) {};
    public Solution(Exception a) {};
    Solution (Object a) {};
    Solution (char a) {};
    Solution (Character a) {};
}


