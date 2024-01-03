import models.Sampionat;
import models.Tym;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampionatTest {

    @Test
    void simulate() throws Exception {

        //Arrange
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

        //Act
        monaco.historieZapasuVypis();
        Tym vitezUltimate = monaco.winWinnerVitez;
        Tym testovaciTym = new Tym("Testovaci");

        //Assert
        assertEquals(vitezUltimate.getClass(), testovaciTym.getClass());
    }
}