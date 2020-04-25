package ru.geekbrains.main.site.at.examples;

import java.util.HashMap;
import java.util.Map;

public class PhoneRegistry {
    private Map<String,String> phonebook = new HashMap<>();

    // Инициализируем список
    PhoneRegistry(){
        this.phonebook.put("111111","Иванов");
        this.phonebook.put("111112","Петров");
        this.phonebook.put("222222","Васечкин");
        this.phonebook.put("222221","Сидоров");
        this.phonebook.put("333300","Иванова");
        this.phonebook.put("333301","Петрова");
        this.phonebook.put("444400","Федин");
        this.phonebook.put("444401","Иванов");
    }

    // Добавить новую запись
    // Если такой номер уже существует, выводится сообщение об ошибке
    public void add(String num,String fio){
        System.out.println("Добавляем номер: "+num+ " и абонента: "+fio);
        if (!phonebook.containsKey(num)) {
            phonebook.put(num,fio);} else System.out.println("Такой номер ("+num+") уже есть");
    }

    // Вывести весь список
    public void numList(){
        phonebook.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    // Получить список номеров по фамилии
    public void get(String fio){
        if(phonebook.containsValue(fio)){
            for(Map.Entry<String, String> item : phonebook.entrySet()){
                    if(item.getValue().equals(fio))
                        System.out.printf("Фамилия: %s  Номер: %s \n", item.getValue(), item.getKey());
            }
        }
    }

    public static void main(String[] args) {
        PhoneRegistry phones = new PhoneRegistry();

        phones.numList();
        System.out.println();

        phones.add("555555","Яблочкин");

        phones.numList();
        System.out.println();

        phones.add("555555","Грушкин");
        System.out.println();

        phones.get("Иванов");
    }
}
