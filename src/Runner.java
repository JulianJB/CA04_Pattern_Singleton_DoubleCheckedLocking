/**
 * 1) provide another example of an Object you feel should be implemented as a Singleton
 *
 * See example description in 19251549\EagerInitialization\src\Runner.java
 *
 * 2) research and produce a set of code-folders: DoubleCheckedLockingInitialization
 */

class Runner {

    public static void main(String[] args) {

        // Create the user windows of the registry editor
        SystemRegistry regeditWindow1 = SystemRegistry.getInstance();
        SystemRegistry regeditWindow2 = SystemRegistry.getInstance();

        // Print the active user windows for the registry editor,
        // notice how they are editing the same system registry file.
        System.out.println("A user is editing the registry file: "  + regeditWindow1); // :SystemRegistry@a1b23c4
        System.out.println("Another user is editing the registry file: " + regeditWindow2); // :SystemRegistry@a1b23c4

        System.exit(0);
    }
}