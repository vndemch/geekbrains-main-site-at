package ru.geekbrains.main.site.at.exceptions;

public class StackOverflowExample {
    public static void main(String[] args) {
        example(0);
    }

    public static void example(int i){
        System.out.println("Итерация: " + i++);
        example(i);
    }
}
