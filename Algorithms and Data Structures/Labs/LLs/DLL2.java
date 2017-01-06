public class DLL2<E extends Comparable<E>> {
	// Each DLL object is the header of a
	// doubly-linked-list. 
	private DLL2.Node<E> first, last;

	public DLL2() {
		// Construct an empty DLL.
		this.first = null;
		this.last = null;
	}

	// //////// Inner class //////////
	private static class Node<E extends Comparable<E>> {
		// Each DLL.Node object is a node of a
		// doubly-linked-list.
		protected E element;
		protected Node<E> pred,succ;

		public Node(E elem, Node<E> pred, Node<E> succ) {
			this.element = elem;
			this.pred = pred;
			this.succ = succ;
		}
	}

	public void printLastToFirst() {
		// Print all elements in this DLL, in last-to-first order.
		DLL2.Node<E> curr = this.last;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.pred;
		}
	}

	
	
	public void delete(DLL2.Node<E> del){
		DLL2.Node<E> succ = del.succ;
		DLL2.Node<E> pred = del.pred;
		if(del==first) first = succ;
		else{
			pred.succ = succ;
			if(del==last) last =pred;
			else succ.pred = pred;
			}
		}
	
	//delete any node containing this value
	public void delete(E elem){
		if(first!=null){
			DLL2.Node<E> p =first;
			while(p!=null){
				if(p.element.equals(elem)){
					this.delete(p);
					p=this.first;
				}
				else p=p.succ;
			}
			
		}
		
	}
		
	

	public void insert(E elem, DLL2.Node<E> pred) {
		// Insert elem at a given point in this SLL, either after the
		// node pred, or before the first node if pred is null.
		DLL2.Node<E> ins = new DLL2.Node<E>(elem, null, null);
		if (first == null && last==null) {//list is empty
			first = ins;
			last = ins;
		} else {
			if (pred==null) {//inserting at head
				ins.succ=first;
				first.pred = ins;
				first = ins;
			} else {//inserting after last node
				if (pred==last) {
					ins.pred = last;
					last.succ = ins;
					last = ins;
				} else {
					DLL2.Node<E> succ = pred.succ;
					ins.pred = pred;
					ins.succ = succ;
					pred.succ = ins;
					succ.pred = ins;
				}

			}

		}
	}
	
	public void insert(E elem) { 
		insert(elem, null);
	}
	
	public void printFirstToLast () {
		// Print all elements in this SLL, in first-to-last order.
		DLL2.Node<E> curr = this.first;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.succ;
			}
		}

}
