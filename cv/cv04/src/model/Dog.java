package model;

import java.sql.SQLOutput;

public class Dog extends Animal{

    private String race;
    public Dog(String name, int age, String race){

        super(name,age);
        this.race = race;
    }

    @Override
    public String toString(){
        return "Dog{" +
                "race='" + race + '\'' +
                ", age=" + age +
                '}';

    }

    public void sound() {
        System.out.print("haf haff");
    }
}
