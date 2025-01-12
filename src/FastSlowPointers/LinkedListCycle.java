package FastSlowPointers;
/**
 * Check whether or nor a linked list contains a cycle. If a cycle exists, return TRUE. Otherwise, return FALSE.
 * The cycle means that at least one node can be reached again by traversing the next pointer.
 *
 * Constraints:
 *              Let n be the number of nodes in a linked list
 *              0 <= n <= 500
 *              -10^5 <= Node.data <= 10^5
 *
 *  Time Complexity: O(n) Where n is the number of nodes in the linkedList
 *
 *  Space Complexity: O(1)
 */
public class LinkedListCycle {
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

        public static boolean detectCycle(LinkedListNode head) {
            // check if linkedList contain only 1 node
            if (head == null) {
                return false;
            }
            // Initialize 2 pointers slow, fast to the head of linkedList
            LinkedListNode slow = head;
            LinkedListNode fast = head;

            // Run the loop until we reach the end of the linkedList
            while (fast != null && fast.next != null) {
                // Move slow pointer one step at a time
                slow = slow.next;
                // Move fast pointer two steps at a time
                fast = fast.next.next;

                // If there is a cycle, slow and fast pointer will meet-- > return true
                if (slow == fast) {
                    return true;
                }
            }
            // if we reach the end of linkedList and haven't found a cycle -> return false
            return false;
        }
    }
}

