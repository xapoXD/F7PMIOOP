package models;

import java.util.ArrayList;
import java.util.List;

public class GeneratorZapasu {

    public List<Tym> tymyList;

    public GeneratorZapasu(List<Tym> tymyList) {
        this.tymyList = tymyList;
        //  rozlosovanyList = this.genZapasy();
    }


    public List<List<Zapas>> genZapasy() throws Exception {

        if (tymyList.size() <= 1) {
            Exception IllegalStateException = new Exception("Nedostatečný počet týmů pro losování");
            throw IllegalStateException;
        } else {

            List<List<Zapas>> rozlosovanyList = new ArrayList<>();
            List<Zapas> zapasyKola = new ArrayList<>();
            for (int i = 0; i < tymyList.size() - 1; i++) {

                for (int j = i + 1; j < tymyList.size(); j++) {

                    Tym team1 = tymyList.get(i);
                    Tym team2 = tymyList.get(j);

                    zapasyKola.add(new Zapas(team1, team2));

                }

            }
            rozlosovanyList.add(zapasyKola);

            return rozlosovanyList;

        }

    }



}
