package FastSlowPointers;

import java.util.LinkedList;

/**
 * Statement: Given the head of a singly linked list, return the middle node of the linked list. If the number of nodes
 * in the linked list is even, there will be two middle nodes,so return the second one.
 *
 * Constraints: Let n be number of nodes in a linked list.
 *              1 <= n <= 100
 *              1<= node.data <= 100
 *              head != NULL
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 */
public class MiddleNodeLinkedList {

    public class PrintList {
        public static void printListWithForwardArrow(LinkedListNode head) {
            LinkedListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data); // print node value
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" → ");
                } else{
                    // if this is the last node, print null at the end
                    System.out.print(" → null \n ");
                }
            }
        }
    }

    class LinkedListNode {
        public int data;
        public LinkedListNode next;
        // Constructor will be used to make a LinkedListNode type object
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    class LinkedList<T> {
        public LinkedListNode head;
        // constructor will be used to make a LinkedList type object
        public LinkedList() {
            this.head = null;
        }
        // insertNodeAtHead method will insert a LinkedListNode at head
        // of a linked list.
        public void insertNodeAtHead(LinkedListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }
        // createLinkedList method will create the linked list using the
        // given integer array with the help of InsertAthead method.
        public void createLinkedList(int[] lst) {
            for (int i = lst.length - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst[i]);
                insertNodeAtHead(newNode);
            }
        }


    }
    public static LinkedListNode middleNode(LinkedListNode head) {
        // Create two pointers, slow and fast, initially at the head of the linked list.
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        // Traverse the linked list while moving the slow pointer one step forward and the fast pointer two steps forward.
        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // When the fast pointer reached the last node or NULL, the slow pointer will point to the middle node of the linked list

        // Return the node that the slow pointer points to
        return slow;
    }

    // Driver code
//    public static void main( String args[] ) {
//
//        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};
//
//        for(int i=0; i<input.length; i++){
//            System.out.print(i+1);
////            LinkedList<Integer> list = new LinkedList<>();
////            list.createLinkedList(input[i]);
//            System.out.print(".\tInput linked list:  ");
////            PrintList.printListWithForwardArrow(list.head);
//            System.out.print("\tMiddle of the linked list is:  " );
////            System.out.println(middleNode(list.head).data);
//            System.out.println(new String(new char[100]).replace('\0', '-'));
//        }
//    }

}
