package models;


import java.util.Random;

public class Bojovnik {

    private String name;

    private int attack;

    private int deff;

    public void setHp(int hp) {
        this.hp = hp;
    }

    private int hp;

    private int intel;

    public String toString(){
        return "Bojovnik{ " +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", deff=" + deff +
                ", hp=" + hp +
                ", intel=" + intel +
                " }";
    }

    public Bojovnik(String name, int attack, int deff, int hp, int intel) {
        this.name = name;
        this.attack = attack;
        this.deff = deff;
        this.hp = hp;
        this.intel = intel;
    }

    public void ChangeHp(int hp){
        hp-=hp;
        setHp(hp);
        System.out.print("HP zmeneno\n");
    }

    private int genRandom(int min, int max){

        Random rnd = new Random();
        return rnd.nextInt(max-min)+min;

    }

    public int genAttack(){

        return genRandom(attack/2, attack);
    }

    public int genDeff(){

        return genRandom(1,deff);
    }

    public int genInt(){

        return genRandom(intel/2, intel+intel/4);

    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDeff() {
        return deff;
    }

    public int getHp() {
        return hp;
    }

    public int getIntel() {
        return intel;
    }
}
