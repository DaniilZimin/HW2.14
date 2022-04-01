package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();

        System.out.println(stringList.add("Медведь"));
        System.out.println(stringList.add("Рысь"));
        System.out.println(stringList.add("Тигр"));
        System.out.println(stringList.add("Лев"));
        System.out.println(stringList.add("Утка"));
        System.out.println(stringList.add("Жираф"));
        System.out.println(stringList.add("Слон"));
        System.out.println(stringList.add("Волк"));

        System.out.println(stringList.add(4, "Бегемот"));//2
        System.out.println(stringList.set(6, "Крокодил"));
        System.out.println(stringList.remove(1));
        System.out.println(stringList.remove("Лев"));
        System.out.println(stringList.contains("Медведь"));
        System.out.println(stringList.indexOf("Волк"));
        System.out.println(stringList.lastIndexOf("Жираф"));
        System.out.println(stringList.get(4));
        System.out.println(stringList.size);
        System.out.println(stringList.isEmpty());
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}
