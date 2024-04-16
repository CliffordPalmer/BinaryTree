/**
 * An Integer Binary Search Tree
 * @author: Nandhini Namasivayam and Clifford Palmer
 * @version: 04/15/2024
 */

import java.util.ArrayList;
import java.util.Stack;

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Call the recursive searchHelper() function on the root of the tree
        return searchHelper(val, root);
    }

    public boolean searchHelper(int val, BSTNode node){
        // Base Case: if the node is null, return false
        if(node == null){
            return false;
        }
        // If the node matches the value being searched for, return true
        if(node.getVal() == val){
            return true;
        }
        // Recursive cases
        // Call searchHelper() on the left branch from the node
        if(searchHelper(val, node.getLeft())){
            return true;
        }
        // Call searchHelper() on the right branch from the node
        if(searchHelper(val, node.getRight())){
            return true;
        }
        // If the value doesn't exist in either branch, return false
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // Create an arraylist to pass into the recursive inorderHelper() function
        ArrayList<BSTNode> traversal = new ArrayList<>();

        // Return the value returned by the recursive inorderHelper() function
        return inorderHelper(root, traversal);
    }

    public ArrayList<BSTNode> inorderHelper(BSTNode node, ArrayList<BSTNode> traversal){
        // Base case: if the node is a leaf, add the node to the traversal and return it
        if(node.isLeaf()){
            traversal.add(node);
            return traversal;
        }
        // Recursive cases
        // First the left branch
        if(node.getLeft() != null){
            inorderHelper(node.getLeft(), traversal);
        }
        // Then add the node
        traversal.add(node);
        // Then the right branch
        if(node.getRight() != null){
            inorderHelper(node.getRight(), traversal);
        }
        return traversal;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Create an arraylist to pass into the recursive inorderHelper() function
        ArrayList<BSTNode> traversal = new ArrayList<>();

        // Return the value returned by the recursive inorderHelper() function
        return preorderHelper(root, traversal);
    }

    public ArrayList<BSTNode> preorderHelper(BSTNode node, ArrayList<BSTNode> traversal){
        // Base case: if the node is a leaf, add the node to the traversal and return it
        if(node.isLeaf()){
            traversal.add(node);
            return traversal;
        }
        // First, add the current node to the traversal
        traversal.add(node);
        // Then add the left branch
        if(node.getLeft() != null) {
            preorderHelper(node.getLeft(), traversal);
        }
        // Then add the right branch
        if(node.getRight() != null) {
            preorderHelper(node.getRight(), traversal);
        }
        return traversal;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Create an arraylist to pass into the recursive inorderHelper() function
        ArrayList<BSTNode> traversal = new ArrayList<>();

        // Return the value returned by the recursive inorderHelper() function
        return postorderHelper(root, traversal);
    }

    public ArrayList<BSTNode> postorderHelper(BSTNode node, ArrayList<BSTNode> traversal){
        // Base case: if the node is a leaf, add the node to the traversal and return it
        if(node.isLeaf()){
            traversal.add(node);
            return traversal;
        }
        // First traverse the left branch
        if(node.getLeft() != null) {
            postorderHelper(node.getLeft(), traversal);
        }
        // Then the right branch
        if(node.getRight() != null) {
            postorderHelper(node.getRight(), traversal);
        }
        // Then add the current node
        traversal.add(node);
        return traversal;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Set the current node to the root to begin
        BSTNode node = root;
        // While loop which runs until the node at hand is a leaf
        while(!node.isLeaf()){
            // If the value being added is less than the current node, branch to the left
            if(val <= node.getVal()){
                node = node.getLeft();
            }
            // If the value being added is more than the current node, branch to the right
            else{
                node = node.getRight();
            }
        }
        // Current node is now the correct parent for the node being added
        // Add node to the left if the value is less than the current node
        if(val <= node.getVal()){
            node.setLeft(new BSTNode(val));
        }

        // Add node to the right if the value is greater than the current node
        else{
            node.setRight(new BSTNode(val));
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
