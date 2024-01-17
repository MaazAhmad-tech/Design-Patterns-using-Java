public class EagerIinitializedSingleton {

    private static final EagerIinitializedSingleton instance = new EagerIinitializedSingleton();


    //We make this constructor private so that applications cant call constructors to construct object more than once
    private EagerIinitializedSingleton() {}

    //Instead they will use this public static method to get instance of the Singleton Object
    //Method is static since we cannot create an object of this class(whole point of Singleton pattern)
    public static EagerIinitializedSingleton getInstance(){
        return instance;
    }


}
