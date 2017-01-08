
public interface Relation<X,Y> {
	// Accessors
	 /*************************************************
	  *			contains Method
	  * It will be possible to test whether
	  * the relation contains a given pair (x, y)
	  *************************************************/ 
	public boolean contains (X x,Y y);
	
	 /*************************************************
	  *			determineAllY Method
	  * When given X, it will be possible to 
	  * determine all values Y such that 
	  * the relation contains (x, y)
	  *************************************************/ 
	public Y determineAllY(X x);
	
	 /*************************************************
	  *			determineAllX Method
	  * When given Y, it will be possible to
	  * determine all values X such that 
	  * the relation contains (x, y)
	  *************************************************/ 
	public X determineAllX(Y y);

	// Transformers
	/*************************************************
	  *			clear Method
	  *  It will be possible to make the relation empty
	  *************************************************/
	public void clear();
	
	/*************************************************
	  *			insert Method
	  * It will be possible to add a given pair (x, y)
	  * to the relation
	  *************************************************/
	public void insert(X x ,Y y);
	
	/*************************************************
	  *			delete Method
	  * It will be possible to remove a given pair (x, y)
	  * to the relation
	  *************************************************/
	public void delete(X x,Y y);
	
	/*************************************************
	  *			removeAllX Method
	  * When given X, it will be possible to remove 
	  * all pairs (x, y) from the relation
	  *************************************************/
	public void removeAllX(X x);
	
	/*************************************************
	  *			removeAllY Method
	  * When given Y, it will be possible to remove 
	  * all pairs (x, y) from the relation
	  *************************************************/
	public void removeAllY(Y y);
	
	/*************************************************
	  *			printInOrder Method
	  * It will be possible to render the relation’s 
	  * contents as a string, in a suitable format
	  *************************************************/
	public void printInOrder (); 
}
