package TwoPointers.lca3;
import TwoPointers.SortColors;

import java.util.*;
/**
 * Given 2 nodes p and q. Return their lowest common ancestor (LCA). Both nodes have a reference to their parent node.
 * The tree's root is not provided. You must use the parent pointers to find the nodes' common ancestor.
 *
 * Note: - The lowest common ancestor of 2 nodes, p and q, is the lowest node in the binary tree,
 *       with both p and q as descendants.
 *      - In a tree, a descendant of a node is any node reachable by following edges downward from that node,
 *      including the node itself.
 *
 * Constraints: -10^4 <= Node.data <= 10^4
 *              The number of nodes in the tree is in the range [2, 500]
 *              all Node.data are unique.
 *              p != q
 *              both p and q are present in the tree
 *
 * Time Complexity: O(h) where h is the height of the tree, as in the worst case,
 *                  each pointer might traverse te entire height of the tree, including h steps
 *
 *  Space Complexity: O(1) there is no additional space being used
 */
public class LowestCommonAncestorOfBinaryTree {
    public static EduTreeNode LowestCommonAncestor(EduTreeNode p, EduTreeNode q){
        // initialize 2 pointers, one on each of the given nodes.
        EduTreeNode ptr1 = p;
        EduTreeNode ptr2 = q;
        // move both pointers upward along the tree using the parent node, one step at a time.
        while (ptr1 != ptr2) {
            if (ptr1.parent != null) {
                ptr1 = ptr1.parent;
            } else {
                // If a pointer reaches the root of the tree (when parent is NULL), move it to the starting position of the other node
                ptr1 = q;
            }

            if (ptr2.parent != null) {
                ptr2 = ptr2.parent;
            } else {
                // If a pointer reaches the root of the tree (when parent is NULL), move it to the starting position of the other node
                ptr2 = p;
            }
        }
        // continue moving until these pointers meet. The point where they meet is the lowest common ancestor of the p, q
        return ptr1;
    }

    public static void main(String[] args) {
        List<List<Integer>> input_trees = Arrays.asList(
                Arrays.asList(100, 50, 200, 25, 75, 350),
                Arrays.asList(100, 200, 75, 50, 25, 350),
                Arrays.asList(350, 100, 75, 50, 200, 25),
                Arrays.asList(100, 50, 200, 25, 75, 350),
                Arrays.asList(25, 50, 75, 100, 200, 350)
        );
        List<List<Integer>> input_nodes = Arrays.asList(
                Arrays.asList(25, 75),
                Arrays.asList(50, 350),
                Arrays.asList(100, 200),
                Arrays.asList(50, 25),
                Arrays.asList(350, 200)
        );

        for (int i = 0; i < input_trees.size(); i++) {
            EduBinaryTree tree = new EduBinaryTree(input_trees.get(i));
            System.out.println((i + 1) + ".\tBinary tree:");
            System.out.println("\n\tp = " + input_nodes.get(i).get(0));
            System.out.println("\tq = " + input_nodes.get(i).get(1));
            EduTreeNode p = tree.find(tree.getRoot(), input_nodes.get(i).get(0));
            EduTreeNode q = tree.find(tree.getRoot(), input_nodes.get(i).get(1));
            EduTreeNode lca = LowestCommonAncestor(p, q);
            System.out.println("\n\tLowest common ancestor: " + lca.data);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
