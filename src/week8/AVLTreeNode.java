package week8;
/**
 * 
 * 
 *@author Jonathan Steele jonwhsteele@gmail.com
 *
 * @param <E>
 */
public class AVLTreeNode <E extends Comparable<E>>{

	private E value;
	private AVLTreeNode<E> left; 
	private AVLTreeNode<E> right;
	private int height;

	//Getters and setters
	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public AVLTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(AVLTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public AVLTreeNode<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(AVLTreeNode<E> right) {
		this.right = right;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Return the height of the subtree rooted at the node t.
	 * @param <E>
	 * @param t root of the subtree.
	 * @return the height of the subtree rooted at the node t.
	 */
	public static <E extends Comparable<E>> int subTreeHeight(AVLTreeNode<E> t) {
		if(null == t)
			return -1;
		return t.getHeight();
	}
	
	//Constructors
	/**
	 * Constructor with value, left, right, and height.
	 * @param value
	 * @param left
	 * @param right
	 * @param height
	 */
	public AVLTreeNode(E value, AVLTreeNode<E> left, AVLTreeNode<E> right, int height) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
		this.height = height;
	}

	/**
	 * Constructor with value and height.
	 * @param value
	 * @param height
	 */
	public AVLTreeNode(E value, int height) {
		this(value, null, null, height);
	}
	
	/**
	 * Constructor with value.
	 * @param value
	 */
	public AVLTreeNode(E value) {
		this(value, null, null, 0);
	}
	
	/**
     * Print binary tree rooted at current node using preorder traversal.
     */
    public void printPreOrder(){
    	System.out.print(this.value + ", ");
    	if(null != this.left)
    		this.left.printPreOrder();
    	if(null != this.right)
    		this.right.printPreOrder();
    }
    
    /**
     * Print binary tree rooted at current node using inorder traversal.
     */
    public void printInOrder()
    {
    	if(null != this.left)
    		this.left.printInOrder();
    	System.out.print(this.value + ", ");
    	if(null != this.right)
    		this.right.printInOrder();
    }

    /**
     * Print tree rooted at current node using postorder traversal.
     */
    public void printPostOrder()
    {
    	if(null != this.left)
    		this.left.printPostOrder();
    	if(null != this.right)
    		this.right.printPostOrder();
    	System.out.print(this.value + ", ");
    }
    
    /**
	 * This method returns whether the node is a leaf node or not. 
	 * @return true if node is a leaf node and false otherwise.
	 */
	public boolean isLeaf() {
		return( null == this.left && null == this.right);
	}
	
	/**
	 * This method returns whether the node has two child nodes or not.
	 */
	public boolean hasTwoChildren() {
		return (this.left != null && this.right != null);
	}
    
	/**
     * Return the size of the tree rooted at t.
     * Note that the method is static, so we can call 
     * even before any object is created.
     */
    public static <E extends Comparable<E>> int size( AVLTreeNode<E> t )
    {
        if( null == t)
            return 0;
        else {
        	int retSize = 1;
        	//Add size of left-subtree
        	retSize += AVLTreeNode.size(t.left);
        	//Add size of right-subtree
        	retSize += AVLTreeNode.size(t.right);
        	return retSize;
        }
    }
    
    /**
     * Implementation of single (right) rotation.
     * Node switches/rotates with the left child and left-child becomes the root.
     * @param n - node to rotate right.
     * @return new root node after tree rotation.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> rotateWithLeftChild(AVLTreeNode<E> n){
    	if( null == n || null == n.left) { //Error in performing rotate.
    		return null;
    	}
    	//Rearrange nodes.
    	AVLTreeNode<E> nr = n.left; //select left-child as the new root. 
    	n.left = nr.right; // Set the right-child of the left-child (new root) as the left-child of node.
    	nr.right = n; //Set node as the right-child of new root.
    	//Update the heights of rearranged nodes
    	n.setHeight(Math.max(subTreeHeight(n.left), subTreeHeight(n.right)) + 1);
    	nr.setHeight(Math.max(subTreeHeight(nr.left), subTreeHeight(nr.right)) + 1);
    	return nr; //return new root.
    }
    
    /**
     * Implementation of single (left) rotation.
     * Node switches/rotates with the right-child and right-child becomes the root.
     * @param n - node to rotate left.
     * @return new root node after tree rotation.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> rotateWithRightChild(AVLTreeNode<E> n){
    	if( null == n || null == n.right) { //Error in performing rotate.
    		return null;
    	}
    	//Rearrange nodes.
    	AVLTreeNode<E> nr = n.right; //select right-child as the new root. 
    	n.right = nr.left; // Set the left-child of the right-child (new root) as the right-child of node.
    	nr.left = n; //Set node as the left child of new root.
    	//Update the heights of rearranged nodes
    	n.setHeight(Math.max(subTreeHeight(n.left), subTreeHeight(n.right)) + 1);
    	nr.setHeight(Math.max(subTreeHeight(nr.left), subTreeHeight(nr.right)) + 1);
    	return nr; //return new root.
    }
   
    /**
     * Implementation of (right-left) double rotation.
     * First, right-child node switches/rotates with its' left-child and 
     * then the node switches/rotates with the right child.
     * @param n - root node to perform rotation.
     * @return the new root node of the rotated (sub) tree.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> doubleRotateWithRightChild(AVLTreeNode<E> n){
    	n.right = rotateWithLeftChild(n.right); //Right rotation of right-child.
    	return rotateWithRightChild(n); //Left rotation of the node.
    }
    
    /**
     * Implementation of (left-right) double rotation.
     * First, left-child node switches/rotates with its' right-child and 
     * then the node switches/rotates with the left child.
     * @param n - root node to perform rotation.
     * @return the new root node of the rotated (sub) tree.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> doubleRotateWithLeftChild(AVLTreeNode<E> n){
    	n.left = rotateWithRightChild(n.left); //Left rotation of left-child.
    	return rotateWithLeftChild(n); //Right rotation of the node.
    }
	
    /**
     * This method inserts the value x to the AVL tree rooted at node n.
     * @param n root node of the tree.
     * @param x value to be inserted.
     * @return the new root node of the tree if insertion is success. Otherwise the same tree.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> insert(AVLTreeNode<E> t, E x){
    	AVLTreeNode<E> newRoot = t;
    	if(null == newRoot)
    		newRoot = new AVLTreeNode<E>(x); //Insert to empty tree. 
    	else if(x.compareTo(newRoot.value) < 0) { //Insert to left sub-tree
    		newRoot.left = insert(newRoot.left, x);
    		//If balance is affected, rotate and adjust the balance.
    		if(subTreeHeight(newRoot.left) - subTreeHeight(newRoot.right) == 2) {
    			if( x.compareTo(newRoot.left.value ) < 0 )
    				newRoot = rotateWithLeftChild(newRoot);
    			else
    				newRoot = doubleRotateWithLeftChild(newRoot);
    		}
    	}
    	else if( x.compareTo(newRoot.value) > 0) { //Insert to right sub-tree
    		newRoot.right = insert(newRoot.right, x);
    		//If balance is affected, rotate and adjust the balance.
    		if(subTreeHeight(newRoot.right) - subTreeHeight(newRoot.left) == 2) {
    			if( x.compareTo(newRoot.right.value ) > 0 )
    				newRoot = rotateWithRightChild(newRoot);
    			else
    				newRoot = doubleRotateWithRightChild(newRoot);
    		}
    	}
    	//else //Duplicate value. Return the same tree.
    	//Update the height of this node.
    	newRoot.setHeight(Math.max(subTreeHeight(newRoot.left), subTreeHeight(newRoot.right)) + 1);
    	return newRoot;
    }

    /**
     * This method finds the inorder predecessor for the complex deletion scenario (Case III) of BST deletion.
     * Precondition: We assume the node has a left child (left child is not null).
     * @param n node for which find the inorder predecessor
     * @return the inorder predecessor of node n
     */
    private static <E extends Comparable<E>> AVLTreeNode<E> inorderPredecessor(AVLTreeNode<E> n){
    	if( null == n || null == n.left) //Error this is not handled here for simplicity.
    		return null;
    	//Simply find the rightmost node in the left subtree and return it.
    	AVLTreeNode<E> pn = n.left;
    	while(null != pn.right)
    		pn = pn.right;
    	return pn;
    }
    
    /**
     * This method deletes the value x from the AVL tree rooted at node n if it is present.
     * @param n root node of the tree.
     * @param x value to be deleted.
     * @return the new root node of the tree after deletion.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> delete(AVLTreeNode<E> t, E x){
    	AVLTreeNode<E> newRoot = t;
    	if(null == newRoot) //Empty tree nothing to delete.
    		return null;
    	int comp = x.compareTo(newRoot.value);
    	if(comp < 0)
    		newRoot.left = delete(newRoot.left, x);
    	else if (comp > 0)
    		newRoot.right = delete(newRoot.right, x);
    	else {//This is the node to delete.
    		if(newRoot.hasTwoChildren()) {//Case III - Convert to case I or II and delete.
    			AVLTreeNode<E> ip = inorderPredecessor(newRoot);
    			newRoot.value = ip.value;
    			newRoot.left = delete(newRoot.left, ip.value); //This deletion will be case I or II.
    		}
    		else if(newRoot.isLeaf())//Deleting a leaf node. - Case I
    			newRoot = null;
    		else{ //Deleting a node with one child. - Case II
    			if(null == newRoot.left)
    				newRoot = newRoot.right;
    			else
    				newRoot = newRoot.left;
    		}
    	}
    	if(null == newRoot) //Tree had one node and it was deleted. 
    		return null;
    	//Update the height of the current node.
    	newRoot.setHeight(Math.max(subTreeHeight(newRoot.left), subTreeHeight(newRoot.right))+1);
    	//If balance is affected, rotate and adjust the balance.
		if(subTreeHeight(newRoot.left) - subTreeHeight(newRoot.right) == 2) {
			//Unbalanced with left subtree having higher height. balance factor = -2
			if(subTreeHeight(newRoot.left.right) > subTreeHeight(newRoot.left.left))
				newRoot = doubleRotateWithLeftChild(newRoot);
			else
				newRoot = rotateWithLeftChild(newRoot);
		}
		else if(subTreeHeight(newRoot.right) - subTreeHeight(newRoot.left) == 2) {
			//Unbalanced with right subtree having higher height. balance factor = 2
			if(subTreeHeight(newRoot.right.left) > subTreeHeight(newRoot.right.right))
				newRoot = doubleRotateWithRightChild(newRoot);
			else
				newRoot = rotateWithRightChild(newRoot);
		}
		return newRoot;
    }
  
    /**
     * This method performs search on the AVL tree rooted by node t	. 
     * Exactly same as the search in BST.
     * @param t root of the (sub)tree.
     * @param x the search value.
     * @return the node with the search value if exist. Otherwise null.
     */
    public static <E extends Comparable<E>> AVLTreeNode<E> search(AVLTreeNode<E> t, E x){   	
    	if(null == t)
    		return null;
    	int comp = x.compareTo(t.value);
    	if (0 == comp) //Root contains value. Return it.
    		return t;
    	else if( 0 > comp) //x less than root. Search in the left subtree.
    		return search(t.left, x);
    	else //x greater than root. Search in the right subtree.
    		return search(t.right, x);
    }
}
