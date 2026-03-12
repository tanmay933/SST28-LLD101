# Singleton Design Pattern (LLD Notes)

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
private:

    static Singleton* instance;

    Singleton() {
        cout << "Singleton Constructor Called!" << endl;
    }

public:

    static Singleton* getInstance() {

        if(instance == nullptr) {
            instance = new Singleton();
        }

        return instance;
    }
};

Singleton* Singleton::instance = nullptr;


--------------------------------
2. THREAD SAFE SINGLETON (LOCK)
--------------------------------

Problem with lazy singleton:
Two threads may create two objects.

Solution:
Use mutex locking.

Pros
- thread safe

Cons
- slower (lock every call)

Example:

class Singleton {
private:

    static Singleton* instance;
    static mutex mtx;

    Singleton() {
        cout << "Singleton Constructor Called!" << endl;
    }

public:

    static Singleton* getInstance() {

        lock_guard<mutex> lock(mtx);

        if(instance == nullptr) {
            instance = new Singleton();
        }

        return instance;
    }
};

Singleton* Singleton::instance = nullptr;
mutex Singleton::mtx;


--------------------------------
3. DOUBLE CHECK LOCKING
--------------------------------

Optimization over thread-safe version.

Idea:
Lock ONLY when instance is null.

Pros
- thread safe
- faster than full lock

Example:

class Singleton {
private:

    static Singleton* instance;
    static mutex mtx;

    Singleton() {
        cout << "Singleton Constructor Called!" << endl;
    }

public:

    static Singleton* getInstance() {

        if(instance == nullptr) {

            lock_guard<mutex> lock(mtx);

            if(instance == nullptr) {
                instance = new Singleton();
            }
        }

        return instance;
    }
};

Singleton* Singleton::instance = nullptr;
mutex Singleton::mtx;


--------------------------------
4. EAGER INITIALIZATION SINGLETON
--------------------------------

Instance created when program starts.

Pros
- thread safe
- simple

Cons
- object created even if never used

Example:

class Singleton {
private:

    static Singleton* instance;

    Singleton() {
        cout << "Singleton Constructor Called!" << endl;
    }

public:

    static Singleton* getInstance() {
        return instance;
    }
};

Singleton* Singleton::instance = new Singleton();


--------------------------------
SIMPLE TEST
--------------------------------

int main() {

    Singleton* s1 = Singleton::getInstance();
    Singleton* s2 = Singleton::getInstance();

    cout << (s1 == s2) << endl;

}

Output:
1  (true → same object)


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