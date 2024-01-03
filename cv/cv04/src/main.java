import com.sun.tools.javac.Main;
import model.Animal;
import model.Dog;

public class main{

    public static void main(String[] args){



        Dog labrador = new Dog("pablo",13,"labradoros"); // Object 1


        System.out.print(labrador.toString());
        labrador.sound();
    }

}