package ru.matyunin.inno.homework13.heapspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Артём Матюнин
 * Будем заполнять коллекцию случайными числами, периодиески удаляя некоторые эелементы,
 * таким образом GC сможет их удалить
 * -Xmx50m
 * -Xms50m
 */

public class OomHeapSpace {

    //в эту коллекцию будем закидывать случайные числа
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Нажмите Enter для старта");
        scanner.nextLine();
        Integer getElem;
        while (true) {

            //закинем 500 случайных чисел
            for (int i = 0; i < 500; i++) {
                list.add(random.nextInt());
            }

            //пробежимся по коллекции и удалим числа, которые делятся на 3 и на 5 без остатка
            for (int j = 0; j < list.size(); j++) {
                getElem = list.get(j);
                if (getElem % 3 == 0 && getElem % 5 == 0) {
                    list.remove(j);
                }
            }
            System.out.println("Осталось памяти: " + Runtime.getRuntime().freeMemory());
        }


    }
}
