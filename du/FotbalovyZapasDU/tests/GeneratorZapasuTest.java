import models.GeneratorZapasu;
import models.Tym;
import models.Zapas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorZapasuTest {

    @Test
    public void testGenZapasy() throws Exception {
        // Arrange
        Tym team1 = new Tym("TeamA");
        Tym team2 = new Tym("TeamB");
        Tym team3 = new Tym("TeamC");

        List<Tym> tymyList = new ArrayList<>();
        tymyList.add(team1);
        tymyList.add(team2);
        tymyList.add(team3);
        GeneratorZapasu generatorZapasu = new GeneratorZapasu(tymyList);

        // Act
        List<List<Zapas>> rozlosovanyList;

            rozlosovanyList = generatorZapasu.genZapasy();

            // Assert
            assertEquals(1, rozlosovanyList.size());
            List<Zapas> zapasyKola = rozlosovanyList.get(0);
            assertEquals(3, zapasyKola.size()); // n(n-1)/2 for n=3 teams
            assertEquals(new Zapas(team1, team2), zapasyKola.get(0));
            assertEquals(new Zapas(team1, team3), zapasyKola.get(1));
            assertEquals(new Zapas(team2, team3), zapasyKola.get(2));

    }

    @Test
    public void testGenZapasySnedostatkemTymu() {
        // Arrange
        Tym team1 = new Tym("TeamA");

        List<Tym> tymyList = Arrays.asList(team1);
        GeneratorZapasu generatorZapasu = new GeneratorZapasu(tymyList);

        // Act and Assert
        assertThrows(Exception.class, generatorZapasu::genZapasy);
    }


}
