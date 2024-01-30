package com.company;

import com.company.model.Singleton;

public class Main {

    public static void main(String[] args) {

        Singleton sin= Singleton.getInstance("Prvni");
        System.out.println(sin.value);
        Singleton sin2 = Singleton.getInstance("druhy");
        System.out.println(sin2.value);


    }
}
