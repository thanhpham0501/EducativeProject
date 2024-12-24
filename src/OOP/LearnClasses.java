package OOP; /** in Java, object is an instance and class is its definition.
 For example, a car have behavior like drive, park, refuel as method and its state are name, speed, color, brand,
 type of fuel as fields
 Classes are building blocks of programs built using the object-oriented methodology. Such programs consist of
 independent self-managing modules and their interactions **/


/**  why use CLass? - create complex objects, easier to maintain the different parts of an application since it is easier
 to make changes in classes **/

public class LearnClasses { // CLass Name

    // Class Data members stores state of an object or a class, it can include: Instance and Static Variables
    // Instance Variables: hold data specific to an instance of the class

    // Non-Static Field
    String topic;
    String accessModifier1 = "Public";
    String accessModifier2 = "Private";
    String accessModifier3 = "Protected";
    String accessModifier4 = "Default";

    // Static field: resides in a class. All obj will share this field and its value
    static int duration = 3;
    // Final Field. Final keyword is a modifier that can applied to variables, methods, classes
    final int numberOfAccessModifier = 4;
    /**
     * Access Modifiers are tags which are associate with each member to define which parts of the program can access it directly
     * Private : A private member cannot be accessed directly from outside the class.
     * Public : - Members can be accessed directly by anything which is in the same scope as the class object.
     *          - Member functions are usually public as they provide the interface through which the application can
     *          communicate with our private member.
     *          - Public members of a class can be accessed by a class object using . operator
     * Protected : - Access level to the protected members lies somewhere between private and public.
     *             - The primary use of the protected tag can be found using inheritance, which is the process of creating
     *             classes out of the classes.
     *             - The protected data members can be accessed inside a Java package. However, outside the package, they
     *             can only be referred to through an inherited class.
     * Default : if we do not mention any access modifier, then it is considered to be default access.
     *            the default access is similar to the protected. it also has package level access, but it also applies to
     *            inherited classes as well ,unlike protected. So, you can say that its access is more limited.
     */
    // Static Variables: Shared across all instances of the class
    private static String courseName = "Java Basics"; // Share by all instance
    // Constant
    public static final int MAX_DURATION = 120;
    class Demo {
        // Static Fields
        static int number = 9;
        static String tile = "Learn how to declare a class in Java";
    }

    /**
     *
     * @param args
     */

    // Main class
    public static void main(String args[]) {
        // name of the class. in this case OOP.LearnClasses will be used to create an instance of the class (object)
        // in our main program, using keyword "new"
        LearnClasses obj = new LearnClasses(); // Object Created
        obj.topic = " topic of this course is Access Modifiers";
        // Static fields can accessible in the main class
        System.out.println(Demo.number);
        System.out.println(Demo.tile);
        System.out.println("Duration to learn classes in Java is: " + LearnClasses.duration);

        // Access non-static fields: as Non-static field doesn't reside in the class,
        // so we need an instance of the class to access non-static fields
        System.out.println(obj.topic);
        System.out.println(obj.numberOfAccessModifier);
    }
}
