
public class SLL {

	// Each SLL object is the header of a 	// singly-linked-list. 
			private SLL.Node first;
			public SLL () {
				// Construct an empty SLL.
				this.first = null;
				}
			
			
	////////// Inner class //////////
			private static class Node {
				// Each SLL.Node object is a node of a 
				// singly-linked-list. 
				protected Object element;
				protected Node succ;
				public Node (Object elem, Node succ) {
					this.element = elem;
					this.succ = succ;
				}
			}
			
			public void printFirstToLast () {
				// Print all elements in this SLL, in first-to-last order.
				SLL.Node curr = this.first;
				while (curr != null) {
					System.out.println(curr.element);
					curr = curr.succ;
					}
				}
			
			public void deleteFirst () {
				// Delete this SLL’s first node (assuming length > 0).
				this.first = this.first.succ;
				}
			
			public void insert (Object elem,
					SLL.Node pred) {
				// Insert elem at a given point in this SLL, either after the 
				// node pred, or before the first node if pred is null.
				SLL.Node ins = new SLL.Node(elem, null);
				if (pred == null) {
					ins.succ = this.first;
					this.first = ins;
					} else {
						ins.succ = pred.succ;
						pred.succ = ins;
						}
				}
			
			public void insert(Object elem){
				//Insert elem at head of list
				insert(elem,null);
			}
			
			public SLL.Node search (Object target) {
				// Find which (if any) node of this SLL contains an 
				// element equal to target. Return a link to the 
				// matching node (or null if there is none).
				SLL.Node curr = this.first;
				while (curr != null) {
					if (target.equals(curr.element))
						return curr;
					curr = curr.succ;
					}
				return null;
					
			}
			
			public void reverse(){
				SLL.Node curr = this.first;
				SLL.Node pred = null;
				SLL.Node succ = null;
				while (curr!=null){
					succ = curr.succ;
					curr.succ = pred;
					pred = curr;
					curr = succ;
				}
				first=pred;
				
				
			}
				
	
}
