// A computer has many system files and registries,
// but there is only one system registry file.
class SystemRegistry {

    // The declaration of the instance as volatile is particularly important in
    // this scenario since the order of the assignation tasks may differ among threads.
    // These are considered to be out-of-order write operations and are handled during
    // runtime by the Just-in-time (JIT) compiler of Java.
    // Consider the following block of code:
    // _instance = new SystemRegistry();
    // In this example, a Thread A will execute the new SystemRegistry() call first and
    // then assign _instance, however, a Thread B could see those operations out of order.
    // By using volatile the changes made from Thread A become visible to Thread B, therefore
    // synchronizing the threads.
    // Source: https://stackoverflow.com/questions/60045133/why-java-double-check-lock-singleton-must-use-the-volatile-keyword

    // The unique instance of the singleton object now is volatile
    // to be correctly handled from multiple threads.
    private volatile static SystemRegistry _instance;

    // The private access modifier prevent the creation of
    // additional instances from this class.
    private SystemRegistry() {
        ; // Do nothing
    }

    // Double checked locking initialization in singletons works by only locking the
    // block of code from the getInstance method that actually creates the unique
    // instance of the singleton instead of locking the entire getInstance method.
    // To achieve this the method checks if there is not a single unique instance created yet
    // and then proceeds to lock the execution of the method until the thread that has
    // requested access creates the singleton instance. Further executions will not be locked
    // as the singleton unique instance would be available.
    // This approach provides a thread-safe implementation of the singleton pattern,
    // and prevents that multiple instances of the singleton are created which would break the pattern.
    // It is considered to be a smarter and not as resource-intensive implementation compared
    // to the Synchronized initialization.
    public static SystemRegistry getInstance() {
        // If the singleton has not been instantiated before create the unique instance
        if (_instance == null) {
            // The synchronized block of code now runs only once
            // when the singleton has not been created yet
            synchronized (SystemRegistry.class) {
                if (_instance == null) {
                    // Providing the singleton with a double checked locking initialization
                    _instance = new SystemRegistry();
                }
            }
        }
        // Return the singleton static instance
        return _instance;
    }

    // Other useful methods of the system registry singleton
    void writeEntry() {}

    void deleteEntry() {}

    void backupRegistry() {}
}