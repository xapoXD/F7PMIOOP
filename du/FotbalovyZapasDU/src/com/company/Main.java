package com.company;

import models.*;

import java.util.*;
import java.util.stream.Collectors;



public class Main {

    public static void main(String[] args) throws Exception {

        Tym pablo = new Tym("Pablo");
        Tym mucus = new Tym("Mucus");
        Tym sheen = new Tym("Sheen");
        Tym yzo = new Tym("Yzo");
        Tym svarta = new Tym("Svarta");
        Tym scott = new Tym("Scott");
        Tym travis = new Tym("Travis");
        Tym boomin = new Tym("Boomin");

        List<Tym> teams = new ArrayList<>();
        teams.add(pablo);
        teams.add(mucus);
        teams.add(sheen);
        teams.add(yzo);
        teams.add(svarta);
        teams.add(scott);
        teams.add(travis);
        teams.add(boomin);


        Sampionat monaco = new Sampionat(teams);
        monaco.historieZapasuVypis();


    }

}


