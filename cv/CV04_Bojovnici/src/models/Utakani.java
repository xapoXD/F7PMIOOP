package models;

public class Utakani {

    private Bojovnik bojovnik1;

    private Bojovnik bojovnik2;

    private Bojovnik bojovnik3;

    private Bojovnik bojovnik4;

    private Bojovnik bojovnik5;

    private Bojovnik bojovnik6;

    private Bojovnik bojovnik7;

    private Bojovnik bojovnik8;

    public Bojovnik WinWinnerVitez;

    private Souboj boj;


    public Utakani(Bojovnik bojovnik1, Bojovnik bojovnik2,Bojovnik bojovnik3,Bojovnik bojovnik4,Bojovnik bojovnik5,Bojovnik bojovnik6,Bojovnik bojovnik7,Bojovnik bojovnik8) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;

        this.bojovnik3 = bojovnik3;
        this.bojovnik4 = bojovnik4;

        this.bojovnik5 = bojovnik5;
        this.bojovnik6 = bojovnik6;

        this.bojovnik7 = bojovnik7;
        this.bojovnik8 = bojovnik8;


        WinWinnerVitez = this.simulate();

    }
    
    public Bojovnik simulate(){

        // kolo 1 
        System.out.println("\nZacina PRVNI kolo: ");
        Souboj kolo1 = new Souboj(bojovnik1,bojovnik2);
        Bojovnik vitez1 = kolo1.winner;

        Souboj kolo2 = new Souboj(bojovnik3,bojovnik4);
        Bojovnik vitez2 = kolo2.winner;

        Souboj kolo3 = new Souboj(bojovnik5,bojovnik6);
        Bojovnik vitez3 = kolo3.winner;

        Souboj kolo4 = new Souboj(bojovnik7,bojovnik8);
        Bojovnik vitez4 = kolo4.winner;

        System.out.printf("V prvmim kole zvitezil %s", kolo1.winner.getName());

        System.out.printf("V prvnim kole zvitezil %s", kolo2.winner.getName());

        System.out.printf("V prvnim kole zvitezil %s", kolo3.winner.getName());

        System.out.printf("V prvnim kole zvitezil %s", kolo4.winner.getName());

        //kolo 2
        System.out.println("\nZacina DRUHE kolo: ");
        Souboj kolo5 = new Souboj(vitez1,vitez2);
        Bojovnik vitez5 = kolo5.winner;
        System.out.printf("V druhem kole zvitezil %s", vitez5.getName());

        Souboj kolo6 = new Souboj(vitez3, vitez4);
        Bojovnik vitez6 = kolo6.winner;
        System.out.printf("V druhem kole zvitezil %s", vitez6.getName());


        // kolo 3
        System.out.println("\nZacina FINALE:");
        Souboj kolo7 = new Souboj(vitez5, vitez6);
        WinWinnerVitez = kolo7.winner;
        System.out.printf("Ve finále kole zvitezil %s \n", WinWinnerVitez.getName() );

         System.out.println("\nGraficky pavouk: \n");


        System.out.printf("%s --- | \n", bojovnik1.getName());

        System.out.printf("               | --- %s\n", vitez1.getName()); // ----------

        System.out.printf("%s --- | \n", bojovnik2.getName());

        System.out.printf("\n                                   | ---  %s \n", vitez5.getName());

        System.out.printf("%s --- | \n", bojovnik3.getName());

        System.out.printf("               | --- %s \n", vitez2.getName()); //-----------

        System.out.printf("%s --- |\n", bojovnik4.getName());

        System.out.printf("\n                                                       | ---  %s \n", WinWinnerVitez.getName());

        System.out.printf("%s --- | \n", bojovnik5.getName());

        System.out.printf("               | --- %s \n", vitez3.getName()); //------------

        System.out.printf("%s --- |\n", bojovnik6.getName());

        System.out.printf("\n                                   | ---  %s \n", vitez6.getName());

        System.out.printf("%s --- | \n", bojovnik7.getName());

        System.out.printf("                | --- %s \n", vitez4.getName()); //------------

        System.out.printf("%s --- |", bojovnik8.getName());

        System.out.println("\n");


       


        return WinWinnerVitez;
    }

}
