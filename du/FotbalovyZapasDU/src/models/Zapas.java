package models;


import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.*;

public class Zapas {

    public Tym tym1;

    public Tym tym2;

    public Tym vitez;

    public ArrayList<ZapasovaUdalost> udalostList = new ArrayList<ZapasovaUdalost>();

    @Override
    public String toString() {
        return tym1.nazev + " vs " + tym2.nazev;
    }


    public Zapas(Tym tym1, Tym tym2 ) {
        this.tym1 = tym1;
        this.tym2 = tym2;
       // vitez = this.simulate();
       // VypisUdalosti();

    }

    public Tym getVitez(){

        vitez = prepoctiVysledky();

        return vitez;
    }


    public void startGame() {

        ZonedDateTime dateTime = ZonedDateTime.now();
        ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.ZACATEK, null, dateTime, 0);
        //    System.out.printf("V minute %d se stala udalost %s\n",gameEvent.minutaHernihoCasu, gameEvent.typUdalosti);
        udalostList.add(gameEvent);

        simulate();

    }

    public void endGame() {

        ZonedDateTime dateTime = ZonedDateTime.now();
        ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.KONEC, null, dateTime, 90);
        //    System.out.printf("V minute %d se stala udalost %s\n",gameEvent.minutaHernihoCasu, gameEvent.typUdalosti);
        udalostList.add(gameEvent);

        Tym vitezzz = prepoctiVysledky();
        vitez = vitezzz;

    }


    private void simulate() {

        // 1 iterace = 1 minuta => 25% sance na roll nejake z udalosti FAUL,OFFSIDE,GOL .. Start,End definovane udalosti na 1 a 90 minute/iteraci
        //System.out.println("Zapas zacina!\n");
        for (int i = 0; i < 90; i++) {

            int sanceNaUdalost = genSanceNaUdalost();


            if (sanceNaUdalost == 1) {
                ZonedDateTime dateTime = ZonedDateTime.now();
                ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.FAUL, null, dateTime, i);
             //   System.out.printf("V minute %d se stala udalost %s\n",i, gameEvent.typUdalosti);
                udalostList.add(gameEvent);
            }
            if (sanceNaUdalost == 2) {
                ZonedDateTime dateTime = ZonedDateTime.now();
                ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.OFFSIDE, null, dateTime, i);
             //   System.out.printf("V minute %d se stala udalost %s\n",i, gameEvent.typUdalosti);
                udalostList.add(gameEvent);
            }
            if (sanceNaUdalost == 3) {
                ZonedDateTime dateTime = ZonedDateTime.now();
                int kteryTymSkoruje = genGolproKoho();

                if (kteryTymSkoruje == 1) {
                    ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.GOL, tym1, dateTime, i);
                  //  System.out.printf("V minute %d se stala udalost %s, skoroval tym: %s\n",i, gameEvent.typUdalosti, gameEvent.proJakyTym.nazev);
                    udalostList.add(gameEvent);
                } else {
                    ZapasovaUdalost gameEvent = new ZapasovaUdalost(ZapasovaUdalost.UdalostEnum.GOL, tym2, dateTime, i);
                  //  System.out.printf("V minute %d se stala udalost %s, skoroval tym: %s\n",i, gameEvent.typUdalosti, gameEvent.proJakyTym.nazev);
                    udalostList.add(gameEvent);
                }

            }

        }

    }

    public void PridejUdalost(ZapasovaUdalost udalostNew){

        for(int i = 0; i < udalostList.size(); i++){

            ZapasovaUdalost aktualni = udalostList.get(i);
            ZapasovaUdalost pred;
            if(i !=0){
                pred = udalostList.get(i-1);
            }else {
                pred = udalostList.get(i);
            }

            if(udalostNew.minutaHernihoCasu > pred.minutaHernihoCasu && udalostNew.minutaHernihoCasu < aktualni.minutaHernihoCasu || udalostNew.minutaHernihoCasu == pred.minutaHernihoCasu){

                udalostList.add(udalostNew);
            }

        }

        if(udalostNew.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL){

            Tym moznostViteznehoTymu = prepoctiVysledky();
            vitez = moznostViteznehoTymu;
        }

        System.out.println("\n\nNovy vypis udalosti s pridanou udalosti:");

        Collections.sort(udalostList, Comparator.comparingInt(ZapasovaUdalost::getHerniCas));

        VypisUdalosti();
    }

    public Tym prepoctiVysledky(){

        int[] vysledky = skoreZapasu();

        int gol1tym = vysledky[0];
        int gol2tym = vysledky[1];

        if (gol1tym > gol2tym) {
            return tym1;
        }
        if (gol1tym < gol2tym) {
            // System.out.printf("Na skore vyhral tym %s s poctem golu %d : %d", tym2.nazev, gol2tym, gol1tym);
            return tym2;
        }

        int gol = genGolproKoho();
        if (gol == 0) {
            // System.out.printf("Skore je stejne rozhodnuti na penalty vyhral tym: %s", tym1.nazev);
            return tym1;
        } else {
            //  System.out.printf("Skore je stejne rozhodnuti na penalty vyhral tym: %s", tym2.nazev);
            return tym2;
        }

    }

    public void VypisUdalosti(){

        System.out.println("\nZapas zacina!\n");
        for(int i = 0; udalostList.size() > i; i++) {

            ZapasovaUdalost gameEvent = udalostList.get(i);

            if(gameEvent.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL){

                System.out.printf("V minute %d se stala udalost %s, skoroval tym: %s\n",gameEvent.minutaHernihoCasu, gameEvent.typUdalosti, gameEvent.proJakyTym.nazev);

            } else {
                System.out.printf("V minute %d se stala udalost %s\n",gameEvent.minutaHernihoCasu, gameEvent.typUdalosti);
            }


        }

        int[] vysledky = skoreZapasu();

        int gol1tym = vysledky[0];
        int gol2tym = vysledky[1];

        if (gol1tym > gol2tym) {
            System.out.printf("Na skore vyhral tym %s s poctem golu %d : %d", tym1.nazev, gol1tym, gol2tym);
        }
        if (gol1tym < gol2tym) {
            System.out.printf("Na skore vyhral tym %s s poctem golu %d : %d", tym2.nazev, gol2tym, gol1tym);
        }

        if (gol1tym == gol2tym) {
            Tym viteznytym = vitez;
            System.out.printf("Skore je stejne %d : %d rozhodnuti na penalty vyhral tym: %s", gol2tym, gol1tym, viteznytym.nazev);
        }


    }

    private int[] skoreZapasu(){

        int[] skoreProPrvniAdruhy = new int[2];

        int tym1goly = 0;
        int tym2goly = 0;

        for (int i = 0; udalostList.size() > i; i++){

            ZapasovaUdalost aktualni = udalostList.get(i);
            if( aktualni.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL && aktualni.proJakyTym == tym1){
                tym1goly++;
            }
            if( aktualni.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL && aktualni.proJakyTym == tym2){
                tym2goly++;
            }
        }

        skoreProPrvniAdruhy[0] = tym1goly;
        skoreProPrvniAdruhy[1] = tym2goly;

        return skoreProPrvniAdruhy;
    }




    private int genRandom(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max-min)+min;
    }

    private int genGolproKoho(){
        return genRandom(0,2);
    }


    private int genSanceNaUdalost(){
        return genRandom(0,11);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zapas zapas = (Zapas) o;
        return (Objects.equals(tym1, zapas.tym1) && Objects.equals(tym2, zapas.tym2)) ||
                (Objects.equals(tym1, zapas.tym2) && Objects.equals(tym2, zapas.tym1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(tym1, tym2);
    }

}
