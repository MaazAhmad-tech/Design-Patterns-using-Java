import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonRunner {
    public static void main(String[] args) {

        System.out.println("Testing Singleton pattern");
//        EagerIinitializedSingleton obj1 = EagerIinitializedSingleton.getInstance();
//        EagerIinitializedSingleton obj2 = EagerIinitializedSingleton.getInstance();

//        LazyInitializedSingleton obj1 = LazyInitializedSingleton.getInstance();
//        LazyInitializedSingleton obj2 = LazyInitializedSingleton.getInstance();

        /*
        * The preceding implementation works fine in the case of the single-threaded environment,
        *  but when it comes to multi-threaded systems, it can cause issues if multiple threads
        *  are inside the if condition at the same time. It will destroy the singleton pattern
        *  and both threads will get different instances of the singleton class.
        */

        try( ExecutorService executorService = Executors.newFixedThreadPool(2)){
            executorService.execute(()->{
                System.out.println(ThreadSafeSingleton.getInstance());
            });
            executorService.execute(()->{
                System.out.println(ThreadSafeSingleton.getInstance());
            });
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}