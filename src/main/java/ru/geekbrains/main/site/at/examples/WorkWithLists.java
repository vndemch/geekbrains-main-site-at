package ru.geekbrains.main.site.at.examples;

        import java.util.*;

public class WorkWithLists {
    public static void main(String[] args) {
        // Создаем список
        List srcList = new ArrayList();
        // Заоплняем список с повторами
        srcList.add("Первый");
        srcList.add("Второй");
        srcList.add("Третий");
        srcList.add("Четвертый");
        srcList.add("Пятый");
        srcList.add("Второй");
        srcList.add("Первый");
        srcList.add("Пятый");
        srcList.add("Шестой");
        srcList.add("Второй");
        srcList.add("Пятый");
        srcList.add("Седьмой");
        // Создаем набор
        Set destList = new HashSet();

        // Выводим элементы списка
        for (Object listElement: srcList){
            System.out.println(listElement.toString());
        }
        System.out.println();

        // Записываем элементы списка в набор
        destList.addAll(srcList);

        // Выводим получившийся набор
        for (Object listElement: destList){
//            System.out.println(listElement.toString());
            System.out.println(listElement.toString() +": "+ Collections.frequency(srcList,listElement.toString()));
        }

    }
}
