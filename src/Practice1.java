public class Practice1 {
    public static void main (String[] args){
        System.out.println(18/5);
        System.out.println(18.0/5.0);
        // using '%' operator to get remainder
        System.out.println(18%5); // because 18 and 5 are integers,thus the remainder is 0
        System.out.println(18.0%5.5);
        // Widening casting
        int intNumber = 7;
        double doubleNumber = intNumber;  // automatic casting: int to double

        System.out.println(intNumber);
        System.out.println(doubleNumber);

        // Narrowing casting
        double myDouble = 9.9;
        int myInt = (int) myDouble; // Manual casting: double to int

        System.out.println(myDouble);
        System.out.println(myInt);


        System.out.print("Hello, hello");
        System.out.println("I dont know why you say goodbye.");
        System.out.print("I say hello.");

        /*
            Example:
            // include educative 's simple graphics library:
            import com.educative.graphics.*;

            class DrawCircle {
              public static void main(String[] args) {
                // set up a canvas for drawing:
                Canvas c;
                c = new Canvas(200, 200);

                // call some graphics commands:
                c.fill("yellow");
                c.stroke("black");
                c.circle(100, 100, 50);

                // nothing is actually drawn on the screen until
                // the `draw` method is called:
                c.draw();
            z
              }
            }
         */
        /*
        note
        1. Single line comments begin with //
        2. All functions in Java called methods. For example, c.circle(100, 100, 50) called the method circle
            with parameters 100, 50, 50 specifying x and y coordinates for the center, and the radius.
        3. Some method called need an object. circle needs a Canvas object to draw with. The first few lines set up
            a reference to a Canvas object in the variable c. Then the c.circle() method call acts on that canvas object.
        4. The method main is defined using the keywords public static void. The method named main is special:
            Java starts running the code at the first line of the method named main.
        5. Method definitions are grouped into classes.
        6. Most lines of code end in a semicolon. Method and class definitions do not.
         */





    }
}
