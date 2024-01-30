import models.Sklad;
import models.Uzivatel;
import models.Zbozi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Zbozi chleba = new Zbozi("chleba",5);
        Zbozi sul = new Zbozi("sul",2);
        Zbozi pepr = new Zbozi("pepr",1);

        Sklad sklad = new Sklad();
        sklad.addToSklad(chleba);
        sklad.addToSklad(sul);
        sklad.addToSklad(pepr);

        sklad.getInfo();

        System.out.println("TADY pridavam---------------");
        Uzivatel uzivatel1 = new Uzivatel("Pablo", sklad);
        uzivatel1.addToKosik("chleba");
        uzivatel1.addToKosik("chleba");
        uzivatel1.addToKosik("chleba");
        uzivatel1.addToKosik("chleba");
        uzivatel1.addToKosik("chleba");
        uzivatel1.getKosik();

        uzivatel1.addNotifikace("pepr");
        //uzivatel1.removeAllKosik();
        sklad.getInfo();


        uzivatel1.removeAllKosik();
        sklad.getInfo();
    }
}
