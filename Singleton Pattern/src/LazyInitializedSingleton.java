public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance = null;

    private LazyInitializedSingleton() {
    }

    /**
     * Lazy initialization method to implement the singleton pattern creates the instance in the global access method.
     *
     * */
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

}
