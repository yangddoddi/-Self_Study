package standardOfJava.Basic;

interface Carnivorous {
    void hunt();
}
interface Fierce {
    void makeThreat();
}
interface Carnivore extends Carnivorous, Fierce {
    void run();
}

class Lion implements Carnivore {
    public void hunt(){};
    public void makeThreat(){};
    public void run(){};
}

public class Interface {
    public static void main(String[] args) {
        Lion lion = new Lion();
        if ( lion instanceof Carnivore )
            System.out.println("Carnivore의 자손이다.");
        if ( lion instanceof Fierce )
            System.out.println("Fierce를 구현했다.");
        if ( lion instanceof Carnivorous )
            System.out.println("Carnivorous를 구현했다.");
        if ( lion instanceof Object)
            System.out.println("Object의 자손이다.");


    }
}
