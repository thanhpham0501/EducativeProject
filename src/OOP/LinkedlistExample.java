package OOP;

import java.util.LinkedList;

/**
 *  Use case of linkedList:
 *   1. When frequent insertion and deletion required: Eg; implementing queues or stacks.
 *   2. When order matters: LinkedList maintains the order of insertion
 *   3. Dynamic data structures: Creating adjacency lists in graph algorithms.
 *
 *                        |   LinkedList               vs    ArrayList
 *
 *  Access Time:          |   Slower O(n)                    Faster O(1)
 *
 *  Insertion/Deletion:   |   Faster at head/middle          Slower (Shifting required)
 *
 *  Memory Usage:         |   Higher (Extra pointers)         Lower (Contiguous memory)
 */
public class LinkedlistExample {
    public static void main(String[] args) {
        LinkedList<String> ls = new LinkedList<>();
        // Add elements
        ls.add("2025");
        ls.add("Happy");
        ls.add("New");
        ls.add("Year");
        ls.add("!");

        //Removing Elements
//        ls.remove("!"); // remove element start with !
//        ls.remove(0); // remove the element at index 0
        ls.removeFirst();
        ls.removeLast();

        //Accessing Elements by index
        System.out.println("Accesses the element at index 2 is: " + ls.get(2));

        System.out.println(ls);
        System.out.println("Size of linked list ls is: "+ ls.size());
    }

}
