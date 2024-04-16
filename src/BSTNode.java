/**
 * The Node for an Integer Binary Tree
 *
 * @author: Nandhini Namasivayam and Clifford Palmer
 * @version: 04/15/2024
 */

public class BSTNode {
    private BSTNode left;
    private BSTNode right;
    private int val;

    public BSTNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    /** Getters and Setters **/
    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    // Function which returns a boolean for whether the node is a leaf of the tree or not
    public boolean isLeaf(){
        return (left == null && right == null);
    }
    public String toString() {
        return Integer.toString(this.val);
    }

    public boolean equals(BSTNode other) {
        return this.val == other.val;
    }
}
