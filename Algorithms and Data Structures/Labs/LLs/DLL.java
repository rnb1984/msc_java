public class DLL {
	// Each DLL object is the header of a
	// doubly-linked-list. 
	private DLL.Node first, last;

	public DLL() {
		// Construct an empty DLL.
		this.first = null;
		this.last = null;
	}

	// //////// Inner class //////////
	private static class Node {
		// Each DLL.Node object is a node of a
		// doubly-linked-list.
		protected Object element;
		protected Node pred, succ;

		public Node(Object elem, Node pred, Node succ) {
			this.element = elem;
			this.pred = pred;
			this.succ = succ;
		}
	}

	public void printLastToFirst() {
		// Print all elements in this DLL, in last-to-first order.
		DLL.Node curr = this.last;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.pred;
		}
	}

	
	
	public void delete(DLL.Node del){
		DLL.Node succ = del.succ;
		DLL.Node pred = del.pred;
		if(del==first) first = succ;
		else{
			pred.succ = succ;
			if(del==last) last =pred;
			else succ.pred = pred;
			}
		}
	
	//delete any node containing this value
	public void delete(Object elem){
		if(first!=null){
			DLL.Node p =first;
			while(p!=null){
				if(p.element.equals(elem)){
					this.delete(p);
					p=this.first;
				}
				else p=p.succ;
			}
			
		}
		
	}
		
	

	public void insert(Object elem, DLL.Node pred) {
		// Insert elem at a given point in this SLL, either after the
		// node pred, or before the first node if pred is null.
		DLL.Node ins = new DLL.Node(elem, null, null);
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
					DLL.Node succ = pred.succ;
					ins.pred = pred;
					ins.succ = succ;
					pred.succ = ins;
					succ.pred = ins;
				}

			}

		}
	}
	
	public void insert(Object elem) { 
		insert(elem, null);
	}
	
	public void printFirstToLast () {
		// Print all elements in this SLL, in first-to-last order.
		DLL.Node curr = this.first;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.succ;
			}
		}

}
