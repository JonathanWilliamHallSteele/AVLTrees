/**
 * Test class for AVL Tree.
 */
package week8;

/**
 * @author Malaka Walpola
 * @author Jon Steele jonwhsteele@gmail.com
 */
public class AVLTreeTester {

	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	private static void test2() {
/**
 * a. Coding: Create an AVL tree with 5 to 7 nodes. You can assign values you like for the
nodes. However, in inserting make sure you insert values in the sorted order.
Report: Draw the structure of tree after each insertion (there should be 5 to 7
trees in your report). For each insertion, indicate the value inserted to tree,
whether a rotation occurred or not and height of the tree after insertion.
b. Report: Is the tree balanced after insertions? What are the heights of the left and right
subtrees?
c. Coding: Print the inOrder, preOrder and postOrder traversal results of the tree in
your test method.
Report: Include the output of the inOrder, preOrder and postOrder traversal results
in your report.
d. Coding: Insert three more values to your tree.
Report: Draw the tree after inserting the new value. Was there a rotation? For each
insertion, indicate the value inserted to the tree, whether a rotation occurred or not
and height of the tree after insertion. 
COMP 251: Data Structures and Algorithms – Lab 8 Page 3 of 3
e. Coding: Delete a leaf node from your tree.
Report: Draw the tree after deleting the value. Was there a rotation? Indicate the
value deleted, whether a rotation occurred or not and height of the tree after deletion.
f. Coding: Delete a node with two children from your tree.
Report: Draw the tree after deleting the value. Was there a rotation? Indicate the
value deleted, whether a rotation occurred or not and height of the tree after deletion.
g. Coding: Make sure your code is commented and properly indented.
 */
		
		int [] values = {1,2,3,4,5,6};
		AVLTree<Integer> myAVLT = new AVLTree<Integer>();
		for(int i=0; i<values.length; i++) {
			myAVLT.insert(values[i]);
		}
		System.out.println("InOrder Traversal: ");
		myAVLT.getRoot().printInOrder();
		System.out.println();
		System.out.println("PreOrder Traversal: ");
		myAVLT.getRoot().printPreOrder();
		System.out.println();
		System.out.println("PostOrder Traversal: ");
		myAVLT.getRoot().printPostOrder();
		System.out.println();
		
		int[] newValues = {7,8,9};
		for(int i=0; i<newValues.length; i++) {
			myAVLT.insert(newValues[i]);
		}
		
		myAVLT.delete(1);
		myAVLT.delete(4);
		System.out.println();
	}
	
	private static void test1() {
		int [] values = {25, 50, 75, 15, 35, 45, 30, 90, 80, 85};
		AVLTree<Integer> myAVLT = new AVLTree<Integer>();
		for(int i=0; i<values.length; i++) {
			myAVLT.insert(values[i]);
		}
		
		myAVLT.printPreOrder(); //Order of Nodes: 35, 25, 15, 30, 80, 50, 45, 75, 90, 85 END
		myAVLT.printInOrder();	//Order of Nodes: 15, 25, 30, 35, 45, 50, 75, 80, 85, 90 END
		myAVLT.printPostOrder(); //Order of Nodes: 15, 30, 25, 45, 75, 50, 85, 90, 80, 35 END

		myAVLT.delete(15);
		myAVLT.delete(30);
		myAVLT.printInOrder();	//Order of Nodes: 25, 35, 45, 50, 75, 80, 85, 90 END
		
		myAVLT.delete(90);
		myAVLT.printInOrder();	//Order of Nodes: 25, 35, 45, 50, 75, 80, 85 END
		
		myAVLT.insert(30);
		myAVLT.insert(40);
		myAVLT.insert(48);
		myAVLT.insert(82);
		myAVLT.insert(33);
		myAVLT.insert(43);
		myAVLT.insert(20);
		
		myAVLT.delete(35);
		myAVLT.printInOrder();	//Order of Nodes: 20, 25, 30, 33, 40, 43, 45, 48, 50, 75, 80, 82, 85,  END
		
		myAVLT.delete(82);
		myAVLT.printInOrder();	//Order of Nodes: 20, 25, 30, 33, 40, 43, 45, 48, 50, 75, 80, 85,  END
		
		int [] searchValues = { 33, 43, 82, 20, 22};
		for(int i=0; i<searchValues.length;i++) {
			AVLTreeNode<Integer> resultNode = myAVLT.search(searchValues[i]);
			System.out.println((resultNode==null)?("Value " + searchValues[i] + " Not Found!"):("Value " + resultNode.getValue() + " Found!"));
		}
	}

}
