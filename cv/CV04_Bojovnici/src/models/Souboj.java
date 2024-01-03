package models;

public class Souboj {

    private Bojovnik bojovnik1;

    private Bojovnik bojovnik2;

    public Bojovnik winner;

    public Souboj(Bojovnik bojovnik1, Bojovnik bojovnik2) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        winner = this.simulate();

    }

    public Bojovnik simulate(){

        while(bojovnik1.getHp()>0 && bojovnik2.getHp()>0)
        {
            int fi1Int = bojovnik1.genInt();
            int fi2Int = bojovnik2.genInt();

            if(fi1Int>fi2Int){
                attackRound(bojovnik1, bojovnik2);

            }else{
                attackRound(bojovnik2,bojovnik1);
            }
        }

        if(bojovnik1.getHp()>0){
            return bojovnik1;
        }else {
            return bojovnik2;
        }

    }

    public void attackRound(Bojovnik bojovnik1, Bojovnik bojovnik2){

        int atck = bojovnik1.genAttack();
        int deff = bojovnik2.genDeff();

        System.out.println(atck);
        System.out.println(deff);

        if(deff>atck){
            System.out.printf("Bojovnik %s s deff %d se uspesne ubranil bojovnikovi %s s attack %d\n", bojovnik2.getName(),deff, bojovnik1.getName(), atck);

        } else {
            bojovnik2.ChangeHp(deff-atck);
            System.out.printf("Bojovnik %s zautocil s utokem %d na bojovnika %s s deff %d, ted mu zbyva %d zivotu\n", bojovnik1.getName(), atck,bojovnik2.getName(),deff,bojovnik2.getHp());
        }

    }

    public Bojovnik getBojovnik1() {
        return bojovnik1;
    }

    public Bojovnik getBojovnik2() {
        return bojovnik2;
    }

    @Override
    public String toString() {
        return "Souboj{" +
                "bojovnik1=" + bojovnik1 +
                ", bojovnik2=" + bojovnik2 +
                '}';
    }


}
