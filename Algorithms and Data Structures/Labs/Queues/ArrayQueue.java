package queues;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
	private E[] elems;
	private int size, front, rear;

	// ///////////// Constructor ///////////////
	public ArrayQueue(int cap) {
		elems = (E[]) new Object[cap];
		size = front = rear = 0;
	}

	// ///////////// Accessors ///////////////
	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public E getFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		return elems[front];
	}

	// ////////////Transformers ///////////////
	public void clear() {
		size = front = rear = 0;
	}

	public void addLast(E it) {
		if (size == elems.length)
			throw new ArrayIndexOutOfBoundsException();
		elems[rear++] = it;
		if (rear == elems.length)
			rear = 0;
		size++;
	}

	public E removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		E frontElem = elems[front];
		elems[front++] = null;
		if (front == elems.length)
			front = 0;
		size--;
		return frontElem;
	}
}
