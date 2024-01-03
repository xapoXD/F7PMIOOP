package com.company;

import model.Zvire;
import model.Predicate;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        // Creating predicate

        Predicate<Integer> lesserThan = i -> (i < 18);
        // Calling Predicate method
        System.out.println(lesserThan.test(20));


        List<Integer> ages = List.of(17, 18, 19, 28, 18, 28, 46, 7, 8, 9, 21, 12);
        NotLessThan18<Integer> isAdult = new NotLessThan18<>();
        ages.stream().filter(isAdult).forEach(System.out.println());
    }

}


class NotLessThan18<E> implements Predicate<Integer> {

    @Override
    public boolean test(Integer v) {
        Integer ADULT = 18;
        return v >= ADULT;
    }
}