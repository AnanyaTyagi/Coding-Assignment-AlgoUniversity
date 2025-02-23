package WarmUp;

public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    public Singleton getInstance(){
        return  singleton;
    }
}
