package com.company;

import models.Bojovnik;
import models.Souboj;
import models.Utakani;

public class Main {

    public static void main(String[] args) {

        Bojovnik Svarta = new Bojovnik("Svarta",50,77,200,4);
        Bojovnik Woody = new Bojovnik("Woody",62,60,200,2);
        Bojovnik Pablo = new Bojovnik("Pablo",50,70,200,6);
        Bojovnik Mucus = new Bojovnik("Mucus",40,60,200,10);
        Bojovnik Nobody = new Bojovnik("Nobody",82,60,200,2);
        Bojovnik Viktor = new Bojovnik("Viktor",62,66,200,3);
        Bojovnik Yzo = new Bojovnik("Yzo",90,60,200,2);
        Bojovnik Five = new Bojovnik("Five",62,80,200,4);

       // Souboj boj1 = new Souboj(Svarta,Woody);
       // System.out.printf("Vítěz kola je: " + boj1.winner.getName() + "\n");

        Utakani utkani = new Utakani(Woody, Svarta, Pablo, Mucus, Viktor, Yzo, Nobody, Five);
        


    }
}
