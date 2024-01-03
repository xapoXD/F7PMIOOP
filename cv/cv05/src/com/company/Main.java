package com.company;

import model.Car;
import model.Hyundai;

public class Main {

    public static void main(String[] args) {

        Car c0=new Car("hneda",2020,5);
        Car c1 = new Hyundai("cervena",2010,3,10000,"Rychly");
        Hyundai h0 = new Hyundai("cerna",2011,2,"Mega rychly");
        System.out.println(c0.toString());
        System.out.println(c1.toString());
        System.out.println(h0.toString());





    }
}
