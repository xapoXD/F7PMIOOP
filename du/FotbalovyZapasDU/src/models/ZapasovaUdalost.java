package models;


import java.time.ZonedDateTime;

public class ZapasovaUdalost{

    public enum UdalostEnum {

        GOL,
        ZACATEK,
        KONEC,
        FAUL,
        OFFSIDE
    }

    public UdalostEnum typUdalosti;

    public ZonedDateTime datumVytvoreniZaznamu;

    public int minutaHernihoCasu;

    public Tym proJakyTym;

    public ZapasovaUdalost(UdalostEnum typUdalosti,Tym tym, ZonedDateTime datumVytvoreniZaznamu, int minutaHernihoCasu) {
        this.proJakyTym = tym;
        this.typUdalosti = typUdalosti;
        this.datumVytvoreniZaznamu = datumVytvoreniZaznamu;
        this.minutaHernihoCasu = minutaHernihoCasu;
    }

    public int getHerniCas() {
        return minutaHernihoCasu;
    }

    @Override
    public String toString() {
        return "ZapasovaUdalost{" +
                "typUdalosti=" + typUdalosti +
                ", datumVytvoreniZaznamu=" + datumVytvoreniZaznamu +
                ", minutaHernihoCasu=" + minutaHernihoCasu +
                ", proJakyTym=" + proJakyTym +
                '}';
    }
}


