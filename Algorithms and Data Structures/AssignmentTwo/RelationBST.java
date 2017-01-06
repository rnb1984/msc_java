
/*****************************************
 * 		**	Relation Binary Search Tree	**
 * 
 * Uses a Binary Search Tree Data Structure
 * implmenting all of Relation's Methods
 * 
 ******************************************/
public class RelationBST<X extends Comparable<X>, Y extends Comparable<Y>> implements Relation<X,Y>{
	// BST Variables
	private RelationBST.Node<X, Y> root;
	// BST Construct Method
	public RelationBST() {
		root = null;
	}

	// //////// Inner Node class //////////
	// Set up nodes for BST
	private static class Node<X extends Comparable<X>, Y extends Comparable<Y>> {
		// Node Varaibles
		protected X elementX;
		protected Y elementY;
		protected Tuple<X, Y> element;
		protected Node<X,Y> left, right;
		// Node Constructor for passing X and Y
		protected Node(X  elemX, Y elemY) {
			elementX = elemX;
			elementY = elemY;
			element = new Tuple<X, Y>(elementX, elementY);
			left = null;
			right = null;
		}
		// Node Constructor for passing Tuple
		public Node(Tuple<X, Y> elem) {
			elementX = elem.getX();
			elementY = elem.getY();
			element = elem;
		}
		// deleteTopmost BST Method
		public Node<X, Y> deleteTopmost() {
			if (this.left == null)
				return this.right;
			else if (this.right == null)
				return this.left;
			else { 
				this.element = this.right.getLeftmost();
				this.right = this.right.deleteLeftmost();
				return this;
			}
		}
		// getLeft BST Method
		private Tuple<X, Y> getLeftmost() {
			Node<X, Y> curr = this;
			while (curr.left != null)
				curr = curr.left;
			return curr.element;
		}
		// deleteLeftmost BST Method
		public Node<X, Y> deleteLeftmost() {
			if (this.left == null)
				return this.right;
			else {
				Node<X, Y> parent = this, curr = this.left;
				while (curr.left != null) {
					parent = curr;
					curr = curr.left;
				}
				parent.left = curr.right;
				return this;
			}
		}

	}

	/********************************************
	 * 		*	Search Method	*
	 * 
	 * 1. Set curr to the BST’s root.
	 * 2. Repeat:
	 * 	2.1. While curr is not null:
	 * 		2.1.1. if targetX is equal to curr’s element:
	 * 			2.1.1.1 if targetY is equal to 0:
	 * 				2.1.1.1.1 return yeilding curr’s element.
	 *  		2.1.1.2 else if targetY is greater than curr’s element:
	 *  			2.1.1.2.1 Set curr to curr’s left child.
	 *  		2.1.1.3 else if targetY is less than curr’s element:
	 *   			2.1.1.3.1 Set curr to curr’s right child.
	 * 		2.1.2. Else, if targetX is less than curr’s element:
	 * 			2.1.2.1. Set curr to curr’s left child.
	 * 		2.1.3. Else, if target is greater than curr’s element:
	 * 			2.1.3.1. Set curr to curr’s right child.
	 * 	2.2. return null if curr is null.
	 * 
	 * Time complexity:
	 *  Best-case time complexity is O(log n).
	 * 	Worst-case time complexity is O(n).
	 * 
	 *********************************************/
	public RelationBST.Node<X, Y> search(X targetX, Y targetY) {

		int directionX = 0;
		int directionY = 0;
		RelationBST.Node<X, Y> curr = root;
		// Keep looping
		while(curr != null){
			// Compare to method <X> values
			directionX = targetX.compareTo(curr.elementX);
			if (directionX == 0){
				// Compare to method <Y> values
				directionY = targetY.compareTo(curr.elementY);
				if (directionY== 0)
					// Keep going round till we find the value
					return curr;
				else if (directionY > 0)
					curr = curr.left;
				else if (directionY < 0)
					curr = curr.right;
			}
			else if (directionX < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return null;
	}

	/********************************************
	 * 		*	insert Method	*
	 * 	Using the BST insert Method
	 *  Inserts X and Y within a Tuple, with X as the key.
	 *  
	 *  Time complexity:
	 * 	Best-case time complexity is O(log n)
	 * 	Worst-case time complexity is O(n).
	 *  
	 *********************************************/
	public void insert(X elemX, Y elemY) {
		Tuple<X, Y> elem = new Tuple<X, Y>(elemX, elemY);
		int directionX = 0;
		RelationBST.Node<X, Y> parent = null, curr = root;
		for (;;) {
			if (curr == null) {
				RelationBST.Node<X, Y> ins = new RelationBST.Node<X, Y> (elem);
				if (root == null)
					root = ins;
				else if (directionX < 0)
					parent.left = ins;
				else
					parent.right = ins;
				return;
			}
			// compare X value so X is the key for the BST
			directionX = elem.getX().compareTo(curr.elementX);
			// if X is equal check for Y
			if (directionX == 0){
				// compare Y values
				int directionY = elem.getY().compareTo(curr.elementY);
				// if equal don't insert
				if (directionY==0)
					return;
				parent = curr;
				if (directionY > 0){
					curr = curr.left;
					directionX --;
				}
				else if (directionY < 0){
					curr = curr.right;
					directionX ++;
				}
			}		
			else if (directionX < 0){
				parent = curr;
				curr = curr.left;
			}
			else{
				parent = curr;
				curr = curr.right;
			}
		}
	}

	/*************************************************
	 *			delete Method
	 *  BST deletion Method
	 *  
	 *  Time complexity:
	 * 	Best-case time complexity is O(log n)
	 * 	Worst-case time complexity is O(n).
	 *************************************************/
	public void delete(X elemX, Y elemY) {
		int directionX = 0;
		int directionY = 0;
		RelationBST.Node<X, Y> parent = null, curr = root;
		for (;;) {
			if (curr == null)
				return;
			directionX = elemX.compareTo(curr.elementX);
			if (directionX == 0) {
				directionY = elemY.compareTo(curr.elementY);
				if (directionY == 0){
					RelationBST.Node<X, Y> del = curr.deleteTopmost();
					if (curr == root)
						root = del;
					else if (curr == parent.left)
						parent.left = del;
					else
						parent.right = del;
					return;
				}
				else if(directionY > 0)
					curr = parent.left;
				else if(directionY < 0)
					curr = parent.right;
			}
			parent = curr;
			if (directionX < 0)
				curr = parent.left;
			else
				curr = parent.right;
		}
	}

	////////////Accessors ////////////
	/*************************************************
	 *			contains Method
	 *
	 * Using BST search,if the relation contains
	 * a given pair (x, y), return true.
	 * 
	 * Time complexity:
	 * 	Best-case time complexity is O(log n)
	 * 	Worst-case time complexity is O(n).
	 *************************************************/ 
	public boolean contains(X x, Y y) {
		if (search(x,y) != null)
			return true;
		return false;
	}

	/*************************************************
	 *			determineAllY Method
	 * When given X, determine all values Y such that 
	 * the relation contains (x, y).
	 * 
	 * 1. Set curr to the BST’s root.
	 * 2. Repeat:
	 * 	2.1. While curr is not null:
	 * 		2.1.1. if targetX is equal to curr’s element:
	 * 			2.1.1.1 pass curr and targetX to getAllY Helper Method.
	 * 			2.1.1.2 curr’s element = null.
	 * 		2.1.2. Else, if targetX is less than curr’s element:
	 * 			2.1.2.1. Set curr to curr’s left child.
	 * 		2.1.3. Else, if target is greater than curr’s element:
	 * 			2.1.3.1. Set curr to curr’s right child.
	 * 	2.2. return null.
	 * 
	 * Time complexity:
	 * 	Best-case time complexity is O(log n)
	 * 	Worst-case time complexity is O(n).
	 * 
	 *************************************************/
	public Y determineAllY(X x) {
		int directionX = 0;
		RelationBST.Node<X, Y> curr = root;
		while(curr != null){
			directionX = x.compareTo(curr.elementX);
			if (directionX == 0){
				getAllY(curr,x);
				curr = null;
			}
			else if (directionX < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return null;
	}

	/*************************************************
	 *			determineAllX Method
	 * When given Y, determine all values X such that 
	 * the relation contains (x, y).
	 * 
	 * 1. pass curr and Y to getAllX Helper Method.
	 * 2. return null.
	 * 
	 * Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 * 
	 *************************************************/
	public X determineAllX(Y y) {
		getAllX(root, y);
		return null;
	}

	////////////Transformers ////////////
	/*************************************************
	 *			clear Method
	 *  set root to null
	 *************************************************/
	public void clear() {
		root = null;
	}

	/*************************************************
	 *			removeAllX Method
	 * When given X, it will be possible to remove 
	 * all pairs (x, y) from the relation
	 * 
	 * 1. Set curr to the BST’s root.
	 * 2. Repeat:
	 * 	2.1. While curr is not null:
	 * 		2.1.1. if targetX is equal to curr’s element:
	 * 			2.1.1.1 pass curr and targetX to deleteAllX Helper Method.
	 * 			2.1.1.2 curr’s element = null.
	 * 		2.1.2. Else, if targetX is less than curr’s element:
	 * 			2.1.2.1. Set curr to curr’s left child.
	 * 		2.1.3. Else, if target is greater than curr’s element:
	 * 			2.1.3.1. Set curr to curr’s right child.
	 * 
	 * Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 *************************************************/
	public void removeAllX(X targetX) {
		int directionX = 0;
		RelationBST.Node<X, Y> curr = root;
		while(curr != null){
			directionX = targetX.compareTo(curr.elementX);
			if (directionX == 0){
				deleteAllX(curr,targetX);
				curr = null;
			}
			else if (directionX < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	/*************************************************
	 *			 removeAllY Method
	 * When given Y, it will be possible to remove 
	 * all pairs (x, y) from the relation
	 * 
	 * 1. pass curr and Y to deleteAllY Helper Method.
	 * 
	 *  Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 *************************************************/
	public void removeAllY(Y y) {
		deleteAllY(root, y);
	}

	/*************************************************
	 *			printInOrder Method
	 * This will render the relation’s 
	 * contents as a string, in a suitable format
	 * using BST traversal printInOrder Method.
	 * 
	 * Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 * 
	 *************************************************/
	public void printInOrder () {
		printInOrder(root);
	}
	
	////////////Helpers ////////////
	/*************************************************
	 *			getALLY Method
	 * Retreives all the X values when passed X with 
	 * a start point Node.
	 * 
	 * 1. If Node<X,Y> top is not null:
	 * 	1.1. Pass top's left node back through getAllY with X
	 * 2. If X to top's element X are equal:
	 * 	2.1. Print top elements X and Y relation to System.
	 * 3.Pass top's right node back through getAllY with X.
	 * 
	 *  Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 *************************************************/
	private void getAllY(Node<X, Y> top, X x) {
		if (top != null) {
			getAllY(top.left,x);
			if (x.compareTo(top.elementX) == 0)
				System.out.println(top.elementX + ", " + top.elementY);
			getAllY(top.right, x);
		}
	}
	/*************************************************
	 *			getALLX Method
	 * Retreives all the Y values when passed Y with 
	 * a start point Node.
	 * 
	 * 1. If Node<X,Y> top is not null:
	 * 	1.1. Pass top's left node back through getAllX with Y.
	 * 2. If Y to top's element Y are equal:
	 * 	2.1. Print top elements X and Y relation to System.
	 * 3.Pass top's right node back through getAllX with Y.
	 * 
	 *  Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 * 
	 *************************************************/
	private void getAllX(RelationBST.Node<X,Y> top, Y y) {
		if (top != null) {
			getAllX(top.left,y);
			if (y.compareTo(top.elementY) == 0)
				System.out.println(top.element.getX() + ", " + top.element.getY());
			getAllX(top.right, y);
		}
	}

	/*************************************************
	 *			deleteAllY Method
	 *  A recursive method,deletes all the Y relations
	 *  when passed Y with a start point Node.
	 * 
	 * 1. If Node<X,Y> top is not null:
	 * 	1.1. Pass top's left node back through deleteAllY with Y
	 * 2. If Y to top's element Y are equal:
	 * 	2.1. delete top elements X and Y relation.
	 * 3.Pass top's right node back through deleteAllY with Y.
	 * 
	 *  Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 * 
	 *************************************************/
	private void deleteAllY(RelationBST.Node<X,Y> top, Y y) {
		if (top != null) {
			deleteAllY(top.left,y);
			if (y.compareTo(top.elementY) == 0)
				delete(top.elementX, y);
			deleteAllY(top.right, y);
		}
	}
	/*************************************************
	 *			deleteAllX Method
	 *  A recursive method,deletes all the X relations
	 *  when passed X with a start point Node.
	 * 
	 * 1. If Node<X,Y> top is not null:
	 * 	1.1. Pass top's left node back through deleteAllY with X
	 * 2. If X to top's element X are equal:
	 * 	2.1. delete top elements X and Y relation.
	 * 3.Pass top's right node back through deleteAllY with X.
	 * 
	 *  Time complexity:
	 * 	Best-case time complexity is O(n'log n)
	 * 	Worst-case time complexity is O(n'n).
	 * 
	 *************************************************/
	private void deleteAllX(Node<X, Y> top, X x) {
		// Recursive
		if (top != null) {
			deleteAllX(top.left,x);
			if (x.compareTo(top.elementX) == 0)
				delete(x, top.elementY);
			deleteAllX(top.right, x);
		}
	}

	// BST recursive printInOrder Method
	private  <X extends Comparable<X>, Y extends Comparable<Y>>  void printInOrder (RelationBST.Node<X,Y> top) {
		// Print, in ascending order, all the elements in the BST 
		// subtree whose topmost node is top.
		if (top != null) {
			printInOrder(top.left);
			System.out.println(top.element.getX() + ", " + top.element.getY());
			printInOrder(top.right);
		}
	}

	// //////// Inner Tuple class //////////
	// A Tuple to store Y with X
	private static class  Tuple<X, Y>{ 
		// Tuple Varaibles
		private X x; 
		private Y y;
		public Tuple(X x, Y y) { 
			this.setX(x); 
			this.setY(y); 
		}

		////Transformers ///
		public void setX(X x) {
			this.x = x;
		}
		public void setY(Y y) {
			this.y = y;
		}

		////Accessors ///
		public X getX() {
			return x;
		}
		public Y getY() {
			return y;
		}
	} 
	// ///// end of inner Tuple class ///////////

	/*************************************************
	 * Main method with test for ADT
	 ************************************************/
	public static void main(String[] args) {
		RelationBST<String, String> countryLanguage = new RelationBST<String, String>();
		// add all new relationships
		countryLanguage.insert("FR","French");
		countryLanguage.insert("DE","German");
		countryLanguage.insert("IT","Italain");
		countryLanguage.insert("BE","French");
		countryLanguage.insert("BE","Flemish");
		countryLanguage.insert("NL","Dutch");
		countryLanguage.insert("UK","English");
		countryLanguage.insert("IE","English");
		countryLanguage.insert("IE","Irish");
		// show if countryLanguage contins relations ("BE", "Flemish")
		if (countryLanguage.contains("BE", "Flemish"))
			System.out.println("Country Language Contains Relations (BE, Flemish)\n");
		// show all relationships
		countryLanguage.printInOrder();		
		System.out.println("\n\n IE Relations");
		// show all IE relationships
		countryLanguage.determineAllY("IE");
		// show all BE relationships
		countryLanguage.removeAllX("BE");
		// show if countryLanguage contins relations ("BE", "Flemish")
		if (countryLanguage.contains("BE", "Flemish") !=true)
			System.out.println("\n\n BE Relations removed");
		// show all after removing BE Relations
		countryLanguage.printInOrder();
		// remove all French relationships
		countryLanguage.removeAllY("French");
		System.out.println("\n\n French Relations removed");
		// show all after removing French Relations
		countryLanguage.printInOrder();
		// show all English relationships
		System.out.println("\n\n English Relations");
		countryLanguage.determineAllX("English");
		// remove all NL relationships
		countryLanguage.removeAllX("NL");
		System.out.println("\n\n with no NL Relations");
		// show all after removing NL Relations
		countryLanguage.printInOrder();
		// clear all Relations
		countryLanguage.clear();
		countryLanguage.printInOrder();
		// show all after clearing all
		System.out.println("\n\n this is cleared");
		countryLanguage.printInOrder();
		// Re-insert
		countryLanguage.insert("FR","French");
		countryLanguage.insert("DE","German");
		countryLanguage.insert("IT","Italain");
		countryLanguage.insert("BE","French");
		// show after re-inserted
		System.out.println("\n\n re-inserted");
		countryLanguage.printInOrder();
	}


}
