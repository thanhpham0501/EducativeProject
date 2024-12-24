package TwoPointers;

/**
 *    Given a singly linked list, remove the n th node from the end of the list and return its head
 *
 *     This approach: two pointers
 *     Solution summary
 *         - Two pointers, right and left, are set at the head node.
 *         - Move the right pointer n steps forward.
 *         - If right reaches NULL, return head's next node.
 *         - Move both right and left pointers forward till right reaches the last node.
 *         - Relink the left node to the node at left's next to the next node.
 *         - Return head.
 *
 *    Time Complexity : O(n) where n is number of nodes in linked list.
 *    Space Complexity : O(1) because we use constant space to store two for pointers.
 *
 */
public class RemoveNthNode {
    // at this point the left pointer will be pointing to the node behind the nth last node
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        // Set two pointers, right and left, at the head of the linked list.
        LinkedListNode right = head;
        LinkedListNode left = head;

        // Move right pointer n elements away from the left pointer.
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        // Removal of the head node.
        if (right == null) {
            return head.next;
        }

        // Move both pointers until right pointer reaches the last node.
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        // At this point, left pointer points to (n-1)th element.
        // So link it next to next element of left.
        left.next = left.next.next;
        return head;
    }

    // Template for printing the linked list with forward arrows
    class PrintList
    {
        public static void printListWithForwardArrow(LinkedListNode head)
        {
            LinkedListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data); // print node value
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" → ");
                }
            }
            // if this is the last node, print null at the end
            System.out.print(" → null ");
        }
    }
    class LinkedListNode {
        public int data;
        public LinkedListNode next;
        // LinkedListNode() will be used to make a LinkedListNode type object.
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Template for the linked list
    class LinkedList<Integer> {
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
        // given integer array with the help of Insert At head method.
        public void createLinkedList(int[] lst) {
            for (int i = lst.length - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst[i]);
                insertNodeAtHead(newNode);
            }
        }
    }
    // Driver Code
//    public static void main(String[] args) {
//        int[][] inputs = {
//                {23, 89, 10, 5, 67, 39, 70, 28},
//                {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
//                {288, 224, 275, 390, 4, 383, 330, 60, 193},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9},
//                {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
//        };
//
//        int[] n = {4, 1, 6, 9, 11};
//
//        for (int i = 0; i < inputs.length; i++) {
//            LinkedList <Integer>inputLinkedList = new LinkedList<Integer>();
//            inputLinkedList.createLinkedList(inputs[i]);
//            System.out.print((i + 1) + ".\tLinked List:\t\t");
//            PrintList.printListWithForwardArrow(inputLinkedList.head);
//            System.out.print("\n\tn = " + n[i]);
//            System.out.print("\n\tUpdated Linked List:\t");
//            PrintList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n[i]));
//            System.out.println();
//            System.out.println(new String(new char[100]).replace('\0', '-'));
//        }
//    }
}

