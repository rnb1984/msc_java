package BSTs;

/*****************************************
 * 		**	Binary Search Tree	**
 * Data Structure
 * 
 * Contain left and right subtrees,
 * Recurrsive defination of a subtree.
 * Size of binarySearch tree is how many nodes.
 * Depth of a tree is by its deppest node
 * Depth is the links between Nodes
 * 
 * 
 ******************************************/
// Extends Comparable object??
public class BST<E extends Comparable<E>> {
	// Each BST object is a binary-search-tree header.
	private BST.Node<E> root;

	// Construct Method
	public BST() {
		// Construct an empty BST.
		root = null;
	}

	// //////// Inner class //////////
	// What are these Nodes
	// We want to do some Comparable
	private static class Node<E extends Comparable<E>> {
		protected E element;
		// Refers to the left and right children
		protected Node<E> left, right;

		// Similar to linked list
		protected Node(E elem) {
			element = elem;
			left = null;
			right = null;
		}
		
		public Node<E> deleteTopmost() {
			// If left empty delet the right
			if (this.left == null)
				return this.right;
			// Left is not empty but right is delete left
			else if (this.right == null)
				return this.left;
			else { // this node has two children
				// top element replaced with right element
				this.element = this.right.getLeftmost();
				this.right = this.right.deleteLeftmost();
				return this;
			}
		}
		// return the left most element
		private E getLeftmost() {
			Node<E> curr = this;
			while (curr.left != null)
				curr = curr.left;
			return curr.element;
		}
		// delete the left most element
		public Node<E> deleteLeftmost() {
			if (this.left == null)
				return this.right;
			else {
				Node<E> parent = this, curr = this.left;
				while (curr.left != null) {
					parent = curr;
					curr = curr.left;
				}
				parent.left = curr.right;
				return this;
			}
		}

	}

	// ///// end of inner class ///////////

	/********************************************
	 * 		*	Search Method	*
	 * 
	 * 		*	Algorthim	*
	 * 
	 * 1. Set curr to the BST’s root.
	 * 2. Repeat:
	 * 	2.1. If curr is null:
	 * 		2.1.1. Terminate yielding none.
	 * 	2.2. Else, if target is equal to curr’s element:
	 * 		2.2.1. Terminate yielding curr.
	 * 	2.3. Else, if target is less than curr’s element:
	 * 		2.3.1. Set curr to curr’s left child.
	 * 	2.4. Else, if target is greater than curr’s element:
	 * 		2.4.1. Set curr to curr’s right child.
	 * 
	 * Time complexity:
	 * Balanced, depth d at least 2d and at most 2d+1–1 nodes.
	 * Depth of balanced BST of size n = floor(log2 n)
	 * Best-case time complexity is O(log n).
	 * 
	 * Unbalanced BST of depth d could have as few as d+1 nodes.
	 * Max. depth of unbalanced BST of size n = n–1
	 * Worst-case time complexity is O(n).
	 * 
	 *********************************************/
	public BST.Node<E> search(E target) {
		int direction = 0;
		BST.Node<E> curr = root;
		// Keep looping
		for (;;) {
			if (curr == null)
				return null;
			// Compare to method <E> had to be comparable
			direction = target.compareTo(curr.element);
			if (direction == 0)
				// Keep going round till we find the value
				return curr;
			else if (direction < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	/********************************************
	 * 		*	insert Method	*
	 * 
	 * 		*	Algorthim	*
	 * 
	 * To insert the element elem into a BST:
	 * 1. Set parent to null, and set curr to the BST’s root.
	 * 2. Repeat:
	 * 	2.1. If curr is null:
	 * 		2.1.1. Replace the null link from which curr was taken (either the BST’s root or parent’s left child or parent’s right child) by a link to a newly-created leaf node with element elem.
	 * 		2.1.2. Terminate.
	 * 	2.2. Else, if elem is equal to curr’s element:
	 * 		2.2.1. Terminate
	 * 	2.3. Else, if elem is less than curr’s element:
	 * 		2.3.1. Set parent to curr, and set curr to curr’s left child.
	 * 	2.4. Else, if elem is greater than curr’s element:
	 * 		2.4.1. Set parent to curr, and set curr to curr’s right child.
	 * 
	 * Time complexity:
	 * Balanced,
	 * Max. no. of comparisons = floor(log2 n) + 1
	 * Best-case time complexity is O(log n).
	 * 
	 * Unbalanced .
	 * Max. no. of comparisons = n
	 * Worst-case time complexity is O(n).
	 * 
	 *********************************************/
	public void insert(E elem) {
		int direction = 0;
		BST.Node<E> parent = null, curr = root;
		// Keep Looping
		for (;;) {
			if (curr == null) {
				BST.Node<E> ins = new BST.Node<E> (elem);
				if (root == null)
					root = ins;
				else if (direction < 0)
					parent.left = ins;
				else
					parent.right = ins;
				return;
			}
			direction = elem.compareTo(curr.element);
			if (direction == 0)
				return;
			parent = curr;
			if (direction < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	public void delete(E elem) {
		int direction = 0;
		BST.Node<E> parent = null, curr = root;
		for (;;) {
			if (curr == null)
				return;
			direction = elem.compareTo(curr.element);
			if (direction == 0) {
				BST.Node<E> del = curr.deleteTopmost();
				if (curr == root)
					root = del;
				else if (curr == parent.left)
					parent.left = del;
				else
					parent.right = del;
				return;
			}

			parent = curr;
			if (direction < 0)
				curr = parent.left;
			else
				// direction > 0
				curr = parent.right;
		}
	}

	public void printInOrder () {
		printInOrder(root);
	}


	private static <E extends Comparable<E>>  void printInOrder (BST.Node<E> top) {
		// Print, in ascending order, all the elements in the BST 
		// subtree whose topmost node is top.
		if (top != null) {
			printInOrder(top.left);
			System.out.println(top.element);
			printInOrder(top.right);
		}




	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST<String> animals = new BST<String>();
		animals.insert("lion");
		animals.insert("fox");
		animals.insert("rat");
		animals.insert("cat");
		animals.insert("pig");
		animals.insert("dog");
		animals.insert("tiger");
		animals.printInOrder();
	}

}
