package a1;

import java.util.ArrayList;
import java.util.LinkedList;
// **********************************************************
// Assignment1:
// Student1: Xia Tian
// UTORID user_name:xiatia18
// UT Student #:1004440410
// Author:xia Tian
//
// Student2: zhang ti
// UTORID user_name: zhan5263
// UT Student #: 1004424517
// Author: zhangti
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************


public class BinaryTree {

  private Node root;

  /*
   * adds data inside a binary tree level by level starting from left to right.
   */
  public void addData(int d) {
    Node toAdd = new Node(d);
    if (root == null) {
      root = toAdd;
    } else {
      LinkedList ll = new LinkedList();
      ll.add(root);
      while (!(ll.isEmpty())) {
        Node currentNode = (Node) ll.poll();
        if (currentNode.getLeftNode() == null) {
          currentNode.setLeftNode(toAdd);
          break;
        } else if (currentNode.getRightNode() == null) {
          currentNode.setRightNode(toAdd);
          break;
        } else {
          /*
           * remember, the queue is FIFO, and due to this we add first the left
           * node followed by the right node.
           */
          ll.add(currentNode.getLeftNode());
          ll.add(currentNode.getRightNode());
        }
      }
    }
  }


  /*
   * This function return back a textual representation of the binary tree The
   * textual representation of the binary tree is returning back a string such
   * that the string contains all the ints of the binary tree level by level and
   * moving from left to right.
   */
  public String toString() { // initialize a queue for store the node
    LinkedList<Node> queue = new LinkedList();
    // add the root to the queue to start the loop
    queue.add(this.root);
    // initialize the output
    String output = "";
    /*
     * remove the top node from the queue and push the left and right nodes of
     * the removed node, and pop the top one for output then the output will be
     * generalized as a depth order if the queue is empty or the temp node is
     * none, quit the loop
     */
    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      if (temp == null) {
        break;
      }
      output = output + temp.toString() + " ";
      queue.add(temp.getLeftNode());
      queue.add(temp.getRightNode());
    }

    return output;
  }


  /*
   * This method returns back an ArrayList that contains ints i.e, the data of
   * each of the Node of the binary tree in Inorder traversal. It inturn calls
   * the method addSubTree.
   */
  public ArrayList toList(Node root) {
    // create new ArrayList to store ints.
    ArrayList al = new ArrayList();
    // add in ints from the root
    addSubTree(root, al);
    return al;
  }


  /*
   * This method use recursion to populate the ArrayList using inOrder traversal
   * of the tree.
   */
  private void addSubTree(Node temp, ArrayList values) {
    if (temp != null) {
      // go through the tree (Inorder traversal) use recursion
      addSubTree(temp.getLeftNode(), values);
      values.add(temp.getData());
      addSubTree(temp.getRightNode(), values);
    }
  }


  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    /*
     * adding the following ints in a binary tree. Remember, the addData adds
     * the ints level by level and from left to right. I will first ask you to
     * run the starter code and debug out the addData so that you are familiar
     * with how it works and trace the creation of the tree using pen and paper.
     */
    bt.addData(1);
    bt.addData(2);
    bt.addData(3);
    bt.addData(4);
    bt.addData(5);
    bt.addData(6);
    bt.addData(7);

    System.out.println(bt); // must print 1 2 3 4 5 6 7

    /*
     * Printing the list of the binary tree. Remember the list of the binary
     * tree must contain the ints in inOrder traversal. The for loop below will
     * give you back a null pointer exception when trying to run the starer
     * code, this is because toList() method inside the BinaryTree returns back
     * a null.
     */
    for (Object d : bt.toList(bt.root)) {
      System.out.println((int) d);
    }
    /*
     * the above loop will print the following: 4 2 5 1 6 3 7
     */
  }
}
