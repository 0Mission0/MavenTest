package idv.mission.example.MavenTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. Create a class named Node which is the essential element of Binary Search Tree (BST), the node value type is Integer
 * 2. You need to provide the following methods for this class:
 *    1. constructor
 *    2. add a node: the function is a Integer, and the function will find a suitable position
 *    3. creating a function for returning how many elements in this tree
 *    4. providing a function for output pre-order tree and in-order tree
 *    5. creating a function which accept a in-order array ex: {4, 2, 5, 1, 3}, but if the array is not in-order, ex: {1, 2, 4, 5, 3}, you need to throw an exception
 *
 * Constraints
 *    1. You will lose the following interview opportunity if we don't see your coding progress
 *    2. All the implementation need to be finished in Node class
 *    3. Solution class is only for test
 *
 * Hints
 *    1. Testing codes will be evaluated.
 *    2. Consider the all edge cases you can image.
 */

class Node {

    public static List<Integer> resultList = new ArrayList<Integer>();

    int value;
    Node parent;
    Node leftChild;
    Node rightChild;

    /*
     * Constructor
     */
    public Node(int value) {
        this.value = value;
    }

    /*
     * addNode(Integer nodeValue)
     */
    public void addNode(int inputValue) {
        Node child = new Node(inputValue);
        if( inputValue <= value && leftChild == null ) {
            leftChild = child;
            child.parent = this;
        }
        else if( inputValue <= value && leftChild != null ) {
            leftChild.addNode(inputValue);
        }
        else if( inputValue > value && rightChild == null ) {
            rightChild = child;
            child.parent = this;
        }
        else {
            rightChild.addNode(inputValue);
        }
    }

    // 3.
    public int num() {
        Node root = findRoot();
        int totalNum = num(root);
        return totalNum;
    }

    private int num(Node node) {
        int leftChildNum = 0;
        int rightChildNum = 0;

        if( leftChild != null ) {
            leftChildNum = num(leftChild);
        }
        if( rightChild != null ) {
            rightChildNum = num(rightChild);
        }
        if( leftChild == null && rightChild == null ) {
            return 1;
        }
        int totalNum = 1 + leftChildNum + rightChildNum;
        return totalNum;
    }

    private Node findRoot() {
        if( parent != null ) {
            return parent.findRoot();
        }
        else {
            return this;
        }
    }

    // 4.
    public void traverse() {
        Node root = findRoot();
        preOrderTraverse(root);
        System.out.println("");
        inOrderTraverse(root);
    }

    private void preOrderTraverse(Node node) {
        if( node == null ) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    private void inOrderTraverse(Node node) {
        if( node == null ) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.value + " ");
        inOrderTraverse(node.rightChild);
    }

    // 5.
    public void checkArrayInOrder(int[] intArray) throws Exception {
        List<Integer> intList = new ArrayList<Integer>();
        for (int x = 0; x < intArray.length; x++) {
            intList.add(intArray[x]);
        }

        List<Integer> sortedList = new ArrayList<Integer>(intList);
        Collections.sort(sortedList);
        Integer[] sortedArray = new Integer[sortedList.size()];
        sortedArray = sortedList.toArray(sortedArray);

        lvr(1, sortedArray);
        System.out.println(resultList);
        if( !intList.equals(resultList) ) {
            throw new Exception("Not an in-order array");
        }
    }

    public void lvr(int index, Integer[] intArray) {
        if( index > intArray.length ) {
            return;
        }
        // System.out.print(index + " ");
        int leftIndex = index * 2;
        int rightIndex = index * 2 + 1;
        int realIndex = index - 1;
        int realLeftIndex = leftIndex - 1;
        int realRightIndex = rightIndex - 1;

        if( realLeftIndex < intArray.length ) {
            lvr(leftIndex, intArray);
        }

        if( realIndex < intArray.length ) {
            resultList.add(intArray[realIndex]);
        }

        if( realRightIndex < intArray.length ) {
            lvr(rightIndex, intArray);
        }
    }

}

public class Solution {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.addNode(3);
        root.addNode(5);
        root.addNode(4);
        root.addNode(2);
        root.addNode(1);
        root.traverse();
    }
}