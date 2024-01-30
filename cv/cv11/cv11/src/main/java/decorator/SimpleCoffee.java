package decorator;

public class SimpleCoffee implements Coffee {

    @Override
    public String prepareCoffee(){
        return "KAVA";
    }

    @Override
    public double getCost(){
        return 40;
    }


}
