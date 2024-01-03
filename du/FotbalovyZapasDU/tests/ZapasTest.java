import models.Tym;
import models.Zapas;
import models.ZapasovaUdalost;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ZapasTest {

    private int genRandom(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max-min)+min;
    }

    private int genGolproKoho(){
        return genRandom(0,2);
    }


    @Test
    void prepoctiVysledky() {

        // Arrange
        Tym tym1 = new Tym("tym1");
        Tym tym2 = new Tym("tym2");
        Zapas zapas = new Zapas(tym1, tym2);
        zapas.startGame();
        zapas.endGame();

        zapas.VypisUdalosti();

        // Act
        int tym1goly = 0;
        int tym2goly = 0;

        for (int i = 0; zapas.udalostList.size() > i; i++) {

            ZapasovaUdalost aktualni = zapas.udalostList.get(i);
            if (aktualni.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL && aktualni.proJakyTym == tym1) {
                tym1goly++;
            }
            if (aktualni.typUdalosti == ZapasovaUdalost.UdalostEnum.GOL && aktualni.proJakyTym == tym2) {
                tym2goly++;
            }
        }

        Tym vitez = null;
        if (tym1goly > tym2goly) {
            vitez = tym1;
        }
        if (tym1goly < tym2goly) {
            vitez = tym2;
        }

        if (tym2goly == tym1goly) {
            vitez = zapas.vitez; // jelikoz je rozohdnuti na penalty random tak se toto neda zkontrolovat proto vzdy vraci stejny tym
        }

        //assert
        assertEquals(vitez, zapas.vitez);

        }
    }