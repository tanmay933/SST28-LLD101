# Singleton Design Pattern (LLD Notes - Java)

--------------------------------
WHAT IS SINGLETON
--------------------------------
Singleton ensures:
1. Only ONE instance of a class exists
2. Provides a GLOBAL access point to that instance

Common LLD use cases:
- Logger
- Configuration Manager
- Cache Manager
- Metrics Registry
- Database Connection Pool

Why?
Multiple instances of these can cause:
- inconsistent state
- resource waste
- synchronization issues


--------------------------------
CORE IDEA
--------------------------------
To implement Singleton we do 3 things:

1. Make constructor PRIVATE
   → prevents object creation using "new"

2. Create a STATIC instance variable
   → shared across entire program

3. Provide a STATIC method getInstance()
   → controls object creation


--------------------------------
1. BASIC LAZY SINGLETON
--------------------------------

Object is created ONLY when first requested.

Pros
- memory efficient
- created only when needed

Cons
- NOT thread safe

Example:

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}


--------------------------------
2. THREAD SAFE SINGLETON (SYNCHRONIZED)
--------------------------------

Problem with lazy singleton:
Two threads may create two objects.

Solution:
Use synchronized method.

Pros
- thread safe

Cons
- slower (method locked every call)

Example:

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static synchronized Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}


--------------------------------
3. DOUBLE CHECK LOCKING
--------------------------------

Optimization over synchronized method.

Idea:
Lock ONLY when instance is null.

Pros
- thread safe
- faster than full synchronization

Example:

class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static Singleton getInstance() {

        if (instance == null) {

            synchronized (Singleton.class) {

                if (instance == null) {
                    instance = new Singleton();
                }

            }
        }

        return instance;
    }
}


--------------------------------
4. EAGER INITIALIZATION SINGLETON
--------------------------------

Instance created when class loads.

Pros
- thread safe
- simple

Cons
- object created even if never used

Example:

class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static Singleton getInstance() {
        return instance;
    }
}


--------------------------------
SIMPLE TEST
--------------------------------

public class Main {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);

    }
}

Output:
true  (same object)


--------------------------------
REAL WORLD LLD EXAMPLES
--------------------------------

Logger
All services log to the same logger instance.

ConfigManager
Loads config once and shares across system.

CacheManager
Central cache object.

MetricsCollector
Collects application metrics globally.


--------------------------------
INTERVIEW ONE-LINER
--------------------------------

Singleton ensures a class has only one instance and provides a global access point to that instance.