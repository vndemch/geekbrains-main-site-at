package ru.geekbrains.main.site.at.exceptions;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExample {
    public static void main(String[] args) {
        try {
            System.out.println("Блок Try");
            new FileReader(new File("./file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Блок Catch");
            e.printStackTrace();
        } finally {
            System.out.println("Блок Finally");

        }
    }
}
