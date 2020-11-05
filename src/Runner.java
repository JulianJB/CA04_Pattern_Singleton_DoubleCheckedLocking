/**
 * This example aims to simulate the behavior of the registry editor
 * from Windows-based operating systems. The singleton pattern is applied
 * to guarantee that only a single instance of the system registry is
 * created as the possibility to have multiple copies of the system registry
 * may lead to inconsistencies and other issues.
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