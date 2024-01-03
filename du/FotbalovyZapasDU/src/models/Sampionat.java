package models;

import java.util.*;
import java.util.stream.Collectors;

public class Sampionat {

    public List<Tym> tymyList;

    public ArrayList<List<Zapas>> historieZapasu = new ArrayList<>();

    public Tym winWinnerVitez;

    public Sampionat(List<Tym> tymyList) throws Exception {
        this.tymyList = tymyList;
        winWinnerVitez = this.simulate();
    }

    public Tym simulate() throws Exception {

        List<Tym> koloTymList = tymyList;
        int couter = 0;

        while (koloTymList.size() >1){

            GeneratorZapasu genZapasu = new GeneratorZapasu(koloTymList);
            List<List<Zapas>> matches = genZapasu.genZapasy();

            //System.out.println("\n");
            //System.out.print("KOLO" + (couter+1) + " : " + matches.get(0)); // TODO: Printici metoda

            historieZapasu.add(couter,matches.get(0));


            List<Tym> aktualniKoloVitezove = new ArrayList<>();
            for (int i = 0; i < matches.get(0).size(); i++) {

                aktualniKoloVitezove.add(vypoctiZapas(matches.get(0).get(i).tym1, matches.get(0).get(i).tym2));

            }

            Map<Tym, Integer> tymCountMap = countElements(aktualniKoloVitezove);
            Map<Tym, Integer> sortedTymCountMap = sortMapByValueDescending(tymCountMap);
            //System.out.println("\nsize listu vitezu: " + sortedTymCountMap.size() + "size listu vsech tymu:" + koloTymList.size());

            //zkontroluj jestli jiz nejaky tym nevypadl tim ze neni v listu vitezu
            if(sortedTymCountMap.size() == koloTymList.size()){
                koloTymList.removeAll(koloTymList); //nuluji list kola abych do nej mohl pridat jineho viteze
                //System.out.println("Zadny tym jeste nevypadl POCITAM DAL\n");
                // Mam vypoctene viteze vsech kol v Listu: aktualniKoloVitezove  ==> ted spocitat kolikrat kdo vyhral

                // VYPIS SKORE PO UTKANICH: kolikrat kdo vyhral
                int lowest = sortedTymCountMap.values().iterator().next();
                List<Tym> loserBracket = new ArrayList<>();
                //System.out.println("\nVYPIS SKORE PO UTKANICH:");
                for (Map.Entry<Tym, Integer> entry : sortedTymCountMap.entrySet()) {

                    // pridej uz jiste viteze do listu pro dalsi kolo TYMy na stejnem miste pridej do loserbracketu
                    if(entry.getValue() == lowest && aktualniKoloVitezove.size() != 1){
                        loserBracket.add(entry.getKey());
                        //System.out.println("PRIDAVAM DO LOOSER BRACKETU:" + entry.getKey().nazev);
                    }else{
                        //System.out.println("PRIDAVAM DO WINNER BRACKETU:" + entry.getKey().nazev);
                        koloTymList.add(entry.getKey());
                    }

                  //  System.out.println(entry.getKey().getNazev() + ": " + entry.getValue());
                }

                    koloTymList = vypoctiPodminky(koloTymList,loserBracket);

            } else{ //jiz nejaky tym vypadl
                //System.out.println("Jiz nejaky tym vypadl NEpocitam DAL\n");

                koloTymList.removeAll(koloTymList); //nuluji list kola abych do nej mohl pridat jineho viteze

                for (Map.Entry<Tym, Integer> entry : sortedTymCountMap.entrySet()) {
                    koloTymList.add(entry.getKey()); //do list kol pridavam jen viteze
                }

                //System.out.println("Nyni jsou v tabulce vitezu tyto tymy: ");
                for (int i =0; i < koloTymList.size(); i++){
                  //  System.out.println("Tym: " + koloTymList.get(i).nazev);
                }

            }

          //  koloTymList.addAll(aktualniKoloVitezove); //pridej vsechny vypocetene viteze do listu pro dalsi run kola WHILE
            couter++;
        }

        winWinnerVitez = koloTymList.get(0);

        return winWinnerVitez;
    }

    public void historieZapasuVypis(){

        System.out.println("\nHISTORIE:");
        System.out.println("Vypis zapasu :");

        for(int i = 0; historieZapasu.size() > i; i++){


            if(i !=0){
                List<Zapas> predchoziKolo = historieZapasu.get(i-1);
                List<Zapas> aktualniKolo = historieZapasu.get(i);

                List<Tym> predchoziKoloTym = vypoctiTymy(predchoziKolo);
                List<Tym> aktualniKoloTym =  vypoctiTymy(aktualniKolo);

                List<Tym> difference = predchoziKoloTym.stream()
                        .filter(element -> !aktualniKoloTym.contains(element))
                        .collect(Collectors.toList());

                System.out.println("V tomto kole vypadl tym: " + difference.get(0).nazev);
            }

            System.out.println("KOLO " + (i+1) + " : " + historieZapasu.get(i));
        }

        System.out.println("\nUltimatni vitez SAMPIONATU je : " + winWinnerVitez.nazev);

    }


    private List<Tym> vypoctiPodminky(List<Tym> koloTymList,List<Tym> loserBracket){

        // v Listu loserBracket jsou nyni Tymy co maji nejmensi skore...
        // jen jeden tym je posldni vyhod ho!!
        if(loserBracket.size() ==1){

           // System.out.printf("Tym %s je posledni v tabulce, vypadava!\n", loserBracket.get(0).nazev);

            //System.out.println("Nyni jsou v tabulce vitezu tyto tymy: ");
            for (int i =0; i < koloTymList.size(); i++){

               // System.out.println("Tym: " + koloTymList.get(i).nazev);

            }

        }

        // dva tymy jsou na poslednim miste
        if(loserBracket.size() ==2){
            Tym vitezRozstrel = vypoctiZapas(loserBracket.get(0),loserBracket.get(1));
            koloTymList.add(vitezRozstrel); // pridej viteze do listu

            if(vitezRozstrel == loserBracket.get(0)){
                //System.out.printf("Tym %s je posledni v tabulce, prohral zapas a vypadava!!\n", loserBracket.get(1).nazev);
            }else{
                //System.out.printf("Tym %s je posledni v tabulce, prohral zapas a vypadava!!\n", loserBracket.get(0).nazev);
            }

            //System.out.println("Nyni jsou v tabulce vitezu tyto tymy: ");
            for (int i =0; i < koloTymList.size(); i++){

                //System.out.println("Tym: " + koloTymList.get(i).nazev);

            }

            //pridej to do historie
            //couter++;
            //historieZapasu.add(couter,matches.get(0));
        }

        // 2 a vice tymu jsou na poslednim miste
        if(loserBracket.size() >2){
            //odeber prvniho losera
            Tym vypadava = loserBracket.get(0);
            loserBracket.remove(0);
            koloTymList.addAll(loserBracket);
            //System.out.printf("Tym %s je posledni v tabulce, vypadava!!!\n", vypadava.nazev);

            //System.out.println("Nyni jsou v tabulce vitezu tyto tymy: ");
            for (int i =0; i < koloTymList.size(); i++){

                //System.out.println("Tym: " + koloTymList.get(i).nazev);

            }
        }



        return koloTymList;
    }

    private Tym vypoctiZapas(Tym tym1, Tym tym2){

        Zapas kolo1 = new Zapas(tym1,tym2);
        kolo1.startGame();
        kolo1.endGame();
        kolo1.getVitez();
        //kolo1.VypisUdalosti();

        //aktualniKolo.add(); //pablo,pablo,mucus,viktor,sheen,yzo
        //System.out.println("\nTYM: " + aktualniKolo.get(i).nazev);

        return kolo1.vitez;

    }

    public List<Tym> vypoctiTymy(List<Zapas> listZapasu){
        List<Tym> listTymu = new ArrayList<>();
        List<Tym> listTymuReturn = new ArrayList<>();

        for(int i = 0; i < listZapasu.size(); i++){
            listTymu.add(listZapasu.get(i).tym1);
            listTymu.add(listZapasu.get(i).tym2);
        }

        Map<Tym, Integer> tymCountMap = countElements(listTymu);
        Map<Tym, Integer> sortedTymCountMap = sortMapByValueDescending(tymCountMap);
        for (Map.Entry<Tym, Integer> entry : sortedTymCountMap.entrySet()) {
            listTymuReturn.add(entry.getKey()); //do list kol pridavam jen viteze
        }

        return listTymuReturn;
    }

    private static <T> Map<T, Integer> countElements(List<T> list) {
        Map<T, Integer> countMap = new HashMap<>();

        for (T element : list) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        return countMap;
    }

    private static <T, U extends Comparable<? super U>> Map<T, U> sortMapByValueDescending(Map<T, U> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<T, U>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }



}


