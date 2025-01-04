package TwoPointers.lca3;

public class EduTreeNode {
    int data;
    EduTreeNode left;
    EduTreeNode right;
    EduTreeNode parent;

    EduTreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}