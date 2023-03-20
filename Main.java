import java.util.*;

public class Main {
 /**
 * @param args
 */
public static void main(String args[]) {
 Scanner sc = new Scanner(System.in);
 BinarySearchTree tree = new BinarySearchTree();
 System.out.print("Enter total number of nodes: ");
 int N = sc.nextInt();
 for (int i = 0; i < N; i++) {
 System.out.print("Enter node: ");
 int node = sc.nextInt();
 tree.add(node);
 }
 int choice;
 do {
 System.out.println("\n1.postorder traversal");
 System.out.println("2.preorder traversal");
 System.out.println("3.inorder traversal");
 System.out.println("4.search");
 System.out.println("5.exit");
 System.out.print("choice : ");
 choice = sc.nextInt();
 if (choice == 1) {
 tree.printPostorder();
 System.out.println();
 }
 else if (choice == 2) {
 tree.printPreorder();
 System.out.println();
 }
 else if (choice == 3) {
 tree.printInorder();
 System.out.println();
 }
 else if (choice == 4) {
 System.out.print("\nEnter node to search: ");
 int toSearch = sc.nextInt();
 System.out.println( toSearch + " is " + (tree.contains(toSearch) ? "present" : "not present") + "in the BST");
 }
 else if (choice == 5) {
 break;
 }
 else {
 System.out.println("Wrong choice");
 }
 } while (choice != 5);
 }
};
class BinarySearchTree {
 private int nodeCount = 0;
 private Node root = null;
 private class Node {
 int data;
 Node left, right;
 public Node(Node left, Node right, int elem) {
 this.data = elem;
 this.left = left;
 this.right = right;
 }
 }
 public boolean isEmpty() {
 return size() == 0;
 }
 public int size() {
 return nodeCount;
 }
 public boolean add(int elem) {
 if (contains(elem)) {
 return false;
 }
 else {
 root = add(root, elem);
 nodeCount++;
 return true;
 }
 }
 private Node add(Node node, int elem) {
 if (node == null) {
 node = new Node(null, null, elem);
 }
 else {
 if (elem < (node.data)) {
 node.left = add(node.left, elem);
 }
 else {
 node.right = add(node.right, elem);
 }
 }
 return node;
 }
private Node findMin(Node node) {
 while (node.left != null)
 node = node.left;
 return node;
 }
 private Node findMax(Node node) {
 while (node.right != null)
 node = node.right;
 return node;
 }
 public boolean contains(int elem) {
 return contains(root, elem);
 }
 private boolean contains(Node node, int elem) {
 if (node == null)
 return false;
 if (elem < (node.data))
 return contains(node.left, elem);
 else if (elem > (node.data))
 return contains(node.right, elem);
 else
 return true;
 }
 /*
 * Given a binary tree, print its nodes according to the "bottom-up" postorder
 * traversal.
 */
 void printPostorder(Node node) {
 if (node == null)
 return;
 printPostorder(node.left);
 printPostorder(node.right);
 System.out.print(node.data + " ");
 }
 /* Given a binary tree, print its nodes in inorder */
 void printInorder(Node node) {
 if (node == null)
 return;
 printInorder(node.left);
 System.out.print(node.data + " ");
 printInorder(node.right);
 }
 /* Given a binary tree, print its nodes in preorder */
 void printPreorder(Node node) {
 if (node == null)
 return;
 System.out.print(node.data + " ");
 printPreorder(node.left);
 printPreorder(node.right);
 }
 public void printPostorder() {
 printPostorder(root);
 }
 public void printInorder() {
 printInorder(root);
}
 public void printPreorder() {
 printPreorder(root);
 }
}

