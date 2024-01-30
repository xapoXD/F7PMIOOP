package facade;

public class Facade {

    private SubSystem1 system1;
    private SubSystem2 system2;

    public Facade(){

        this.system1 = new SubSystem1();
        this.system2 = new SubSystem2();
    }

    public void wrapper(){
        system1.methodOne();
        system2.methodTwo();
    }
}
