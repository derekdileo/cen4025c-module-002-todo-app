package com.derekdileo;

// Basic Singleton Pattern for reference (please disregard)
public class SingletonPattern {

    private static SingletonPattern firstInstance = null;

    private SingletonPattern() {    }

    public static SingletonPattern getInstance() {
        if(firstInstance == null) {
            // Lazy instantiation (if instance isn't needed, it won't be created)
            firstInstance = new SingletonPattern();
        }
        return firstInstance;
    }
}
