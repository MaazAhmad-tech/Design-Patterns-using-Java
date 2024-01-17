public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {
        System.out.println("ThreadSafeSingleton Instantiated!");
    }

    public static ThreadSafeSingleton getInstance(){
        if(instance == null) {
            //making use of synchronized block so that only  thread executes the code
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) //double checking for threads in waiting state
                    instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
}
