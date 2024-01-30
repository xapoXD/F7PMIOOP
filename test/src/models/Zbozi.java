package models;

import java.util.ArrayList;
import java.util.List;

public class Zbozi {

    private String jmeno;
    private int pocet;
    private List<Uzivatel> notifikaceNastavene = new ArrayList<>();

    public Zbozi(String jmeno, int pocet) {
        this.jmeno = jmeno;
        this.pocet = pocet;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }


    public List<Uzivatel> getNotifikaceNastavene() {
        return notifikaceNastavene;
    }


    public void addNotifikace(Uzivatel uzivatel){
        notifikaceNastavene.add(uzivatel);

    }

}

