package singleton;

public class SingletonWithEagerInit {
    private static SingletonWithEagerInit uniqueInstance;
    private SingletonWithEagerInit() {

    }

    public static SingletonWithEagerInit getUniqueInstance() {
        return uniqueInstance;
    }
}
