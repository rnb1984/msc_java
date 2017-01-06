package queues;

public interface Queue<E> {
	// Each Queue<E> object is a homogeneous queue 	// whose elements are of type E.
			/////////////// Accessors ///////////////
			public boolean isEmpty ();
			// Return true if and only if this queue is empty.
			public int size ();
			// Return this queue’s size.
			public E getFirst ();
			// Return the element at the front of this queue.
           //////////////Transformers //////////////
		    public void clear ();	
		    // Make this queue empty.
		    public void addLast (E it);	
		    // Add it as the rear element of this queue.
		   public E removeFirst ();
		   // Remove and return the front element of this queue.
	}



