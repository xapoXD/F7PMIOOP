package decorator;

public class MilkSugarCoffee extends CoffeeDecorator {

    public MilkSugarCoffee(Coffee coffee){

        super(new MilkCoffee(new SugarCoffee(coffee)));
    }

    @Override
    public String prepareCoffee(){

        return super.prepareCoffee() + " nastackovano";
    }

    @Override
    public double getCost(){
        return super.getCost();
    }
}
