package queues;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
	private Node<E> front, rear;
	private int size;
	/////////////// Inner class ///////////////
	private  static class Node<E> {
		public E element;
		public Node<E> succ;
	
		public Node (E x, Node<E> s) {
			element = x; succ = s;
			}
		}
/////////////// Constructor ///////////////
public LinkedQueue () {
	front = rear = null;
	size = 0;
	}
/////////////// Accessors ///////////////
public boolean isEmpty () {
	return (front == null);
	}

public int size () {
	return size;
	}
public E getFirst () {
	if (front == null) throw new NoSuchElementException();
	return front.element;
	}

//////////////Transformers ///////////////
public void clear () {
	front = rear = null;
			size = 0;
	}
public void addLast (E it) {
	Node<E> newest = new Node<E>(it, null);
	if (rear != null) rear.succ = newest;
	else front = newest;
	rear = newest;
	size++;
	}
public E removeFirst () {
	if (front == null) throw new NoSuchElementException();
	E frontElem = front.element;
	front = front.succ;
	if (front == null) rear = null;
	size--;
	return frontElem;
	}
}



	
	


