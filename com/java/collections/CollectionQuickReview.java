package com.java.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class CollectionQuickReview {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 30);
        map.put("Cherry", 20);
        map.put("Date", 40);
        map.put("Mango", 11);

        //sort the key based on the value and then print

        map.forEach((k, v) -> System.out.println("Normal print key " + k + " value " + v));
        System.out.println("------------------------------------------");

        HashMap<String,Integer> newLinkedHashMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1,e2) -> e1,
                                LinkedHashMap::new));

        newLinkedHashMap.forEach((k, v) -> System.out.println("Assending order key " + k + " value " + v));

        //sort the key based on the value and then print in reverse sorted order
        System.out.println("------------------------------------------");

        LinkedHashMap lm = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) ->e2, LinkedHashMap::new));
        lm.forEach((k, v) -> System.out.println("Decending order key " + k + " value " + v));

        System.out.println("------------------------------------------");

        // sort a list of employee class based on employee salary
        Person p1 = new Person("Tim", 49,102000);
        Person p2 = new Person("John", 23,202000);
        Person p3 = new Person("Kong", 38,190000);
        Person p4 = new Person("Song", 39,78000);
        Person p5 = new Person("Li", 41,101000);

        HashMap<String, Person> personMap = new HashMap<>();
        personMap.put("P1", p1);
        personMap.put("P2", p2);
        personMap.put("P3", p3);
        personMap.put("P4", p4);

        LinkedHashMap linkM = personMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Person::getSalary)))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1, LinkedHashMap::new));
        linkM.forEach((k,v) -> System.out.println(
                "The name of the employee in sorted order based on salary "+((Person)v).getName()+
                " and the salary is "+((Person)v).getSalary()));
    }
}

class Person{
    int age;
    String name;
    int salary;

    public Person(String name, int age, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}