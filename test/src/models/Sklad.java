package models;

import models.observer.ZboziObservable;
import models.observer.ZboziObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sklad implements ZboziObservable, ZboziObserver {

    private static Map<String, Zbozi> zboziList = new HashMap<>();


    public Sklad() {

    }

    @Override
    public void addToSklad(Zbozi zbozi) {
       /* Zbozi getZbozi = getZboziByName(zboziName);

        if(zboziList.getOrDefault(zbozi.getJmeno(),null).getPocet() == 0){
            //inform users
            Zbozi zbozii = zboziList.getOrDefault(zbozi.getJmeno(),null);
            for (Uzivatel uzivatel : zbozii.getNotifikaceNastavene()) {

            }
        }
*/


        //System.out.println(zboziList.getOrDefault("chleba",null).getPocet());

        if(zboziList.containsKey(zbozi.getJmeno())){ //uz je nainicializovano pridej cislo

            zboziList.getOrDefault(zbozi.getJmeno(),null).setPocet(zbozi.getPocet()+1);
        }else{
            zboziList.put(zbozi.getJmeno(),zbozi);
        }

        //notifyZboziChanged();
    }

    @Override
    public void removeFromSklad(Zbozi zbozi) {


        if(zboziList.containsValue(zbozi)){ //uz je nainicializovano odeber cislo
            zboziList.getOrDefault(zbozi.getJmeno(),null).setPocet(zbozi.getPocet()-1);
            // zbozi.setPocet(zbozi.getPocet()-1);
        }

       // notifyZboziChanged();


    }

    @Override
    public void notifyZboziChanged() {
        System.out.println("Zbozi na sklade:");

        for (Map.Entry<String,Zbozi> entry : zboziList.entrySet()){
            System.out.println(entry.getValue().getJmeno() + " a jeho pocet je: " + entry.getValue().getPocet());
        }
        System.out.println("--------");
    }


    public Zbozi getZboziByName(String itemName) {
        return zboziList.getOrDefault(itemName,null);
    }


    public void getInfo(){
        for (Map.Entry<String,Zbozi> entry : zboziList.entrySet()){
            System.out.println(entry.getValue().getJmeno() + " a jeho pocet je: " + entry.getValue().getPocet());
        }
    }

}
