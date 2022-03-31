package week8;

/**
 *  @author Jonathan Steele jonwhsteele@gmail.com
 * 	@author Malaka Walpola
 *	Implementation of AVL Tree
 */
public class AVLTree<E extends Comparable<E>> {

	private AVLTreeNode<E> root;

	/**
	 * @return the root
	 */
	public AVLTreeNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(AVLTreeNode<E> root) {
		this.root = root;
	}

	//Tree Method implementations
	/**
	 * Print the tree in preorder. 
	 */
	public void printPreOrder() {
		if(null == this.root)
			System.out.println("Tree is empty!");
		else {
			System.out.println("Preorder Traversal:");
			this.root.printPreOrder();
			System.out.println(" END");
		}
	}

	/**
	 * Print the tree in inorder. 
	 */
	public void printInOrder() {
		if(null == this.root)
			System.out.println("Tree is empty!");
		else {
			System.out.println("Inorder Traversal:");
			this.root.printInOrder();
			System.out.println(" END");
		}
	}

	/**
	 * Print the tree in postorder. 
	 */
	public void printPostOrder() {
		if(null == this.root)
			System.out.println("Tree is empty!");
		else {
			System.out.println("Postorder Traversal:");
			this.root.printPostOrder();
			System.out.println(" END");
		}
	}

	/**
	 * Returns the number of nodes in the tree.
	 * Uses a recursive helper that recurs down the tree and counts the nodes.
	 * @return number of nodes in the tree.
	 */
	public int size() {
		if(null == this.root)
			return 0;
		return AVLTreeNode.size(this.root);
	}

	/**
	 * Returns the height (max root-to-leaf depth) of the tree.
	 * Uses a recursive helper that recurs down to find the height (max depth).
	 * @return the height of the tree.
	 */
	public int height() {
		if(null == this.root)
			return -1;
		return this.root.getHeight();
	}

	/**
	 * Insert the new value to the AVL tree if it is not present.
	 * @param newValue value to be inserted.
	 */
	public void insert(E newValue) {
		if(null != newValue)
			this.root = AVLTreeNode.insert(this.root, newValue);
	}
		
	/**
	 * Delete the specified value from the AVL tree if it is present.
	 * @param value value to be deleted.
	 */
	public void delete(E value) {
		if(null != value)
			this.root = AVLTreeNode.delete(this.root, value);
	}
	
	/**
     * This method performs search on the AVL tree. 
     * Exactly same as the search in BST.
     * @return the node with the search value if exist. Otherwise null.
	 * @param value the search value.
	 * @return
	 */
	public AVLTreeNode<E> search(E value){
		if(null != value)
			return AVLTreeNode.search(this.root, value);
		return null;
	}
	
}
