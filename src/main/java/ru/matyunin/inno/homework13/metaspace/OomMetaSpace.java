package ru.matyunin.inno.homework13.metaspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * @author Артём Матюнин
 * многократно загружаем много класс CrashClass с помощью MyClassLoader
 * -XX:MaxMetaspaceSize=100m
 */


public class OomMetaSpace {

    public static void main(String[] args) throws IOException {
        List<Class<?>> classList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Runtime.getRuntime().exec("javac CrashClass.java");

        System.out.println("Нажмите Enter для старта");
        scanner.nextLine();
        while (true) {
            classList.add(loadMyClass("CrashClass"));

        }

    }

    //метод вызова загрузчика  и загрузки классов
    private static Class<?> loadMyClass(String className) {

        MyClassLoader myClassLoader = new MyClassLoader();

        Class<?> simpleClass = null;
        try {
            simpleClass = Class.forName(className, true, myClassLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Class.forName(className, true, myClassLoader);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return simpleClass;
    }
}
