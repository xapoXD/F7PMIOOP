package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uzivatel {

    public String name;
    private List<Zbozi> kosik = new ArrayList<>();
    private Sklad sklad;

    public Uzivatel(String name, Sklad sklad) {
        this.name = name;
        this.sklad = sklad;
    }

    public void addToKosik(String zboziName){

        //check jestli tam je!!!!
        if(sklad.getZboziByName(zboziName).getPocet() <= 0){
            System.out.println("Zbozi jiz neni na sklade");
        }else{
            Zbozi getZbozi = sklad.getZboziByName(zboziName);  //balance sklad
            kosik.add(getZbozi);
            sklad.removeFromSklad(getZbozi);
        }

    }

    public void getKosik(){

        System.out.println("Zbozi v kosiku uzivatele:");
        for(Zbozi zbozi : kosik){

            System.out.println(zbozi.getJmeno());
        }
        System.out.println("--------");
    }


    public void removeAllKosik(){

        if(kosik.size() >= 0){

            for(Zbozi zboziKosik : kosik){

                sklad.addToSklad(zboziKosik);
            }
            System.out.println("Zbozi z kosiku vyprazdneno");
        }

    }

    public void addNotifikace(String zboziName){

        Zbozi getZbozi = sklad.getZboziByName(zboziName);
        getZbozi.getNotifikaceNastavene().add(this);

    }


}
