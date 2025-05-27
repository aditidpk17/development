package com.dev.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    List<List<String>> listOfStrings;

    public Map() {
        listOfStrings = new ArrayList<>();

        List<String> innerList1 = new ArrayList<>();
        innerList1.add("lorem");
        innerList1.add("ipsum");

        List<String> innerList2 = new ArrayList<>();
        innerList2.add("dolor");
        innerList2.add("sit");
        innerList2.add("amet");

        listOfStrings.add(innerList1);
        listOfStrings.add(innerList2);
    }

    public static void main(String[] args) {
        Map map = new Map();

        // Using a lambda expression to print each string in the nested lists
        map.listOfStrings.forEach(innerList -> 
            innerList.forEach(str -> System.out.println(str))
        );

        map.listOfStrings.stream()
            .flatMap(List::stream)                  // {" loren", "ipsum", "dolor", "sit", "amet"}
            .sorted()                               // {"amet", "dolor", "ipsum", "loren", "sit"}
            .filter(str -> str.contains("s"))     // {"ipsum", "sit"}
            .map(String::toUpperCase)               // {"IPSUM", "SIT"}
            .collect(Collectors.toList())
            .forEach(str -> System.out.println(str));
    }
}
