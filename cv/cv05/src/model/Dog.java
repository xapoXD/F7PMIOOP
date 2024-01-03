package model;

public class Dog implements BehavioralPattern{


    public String sound() {
       return ("Haf haf.");
    }

    @Override
    public void favouriteToy() {
        System.out.println("Plysak");
    }

}
