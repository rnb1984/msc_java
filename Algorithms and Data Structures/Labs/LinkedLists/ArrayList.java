package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] elems;
	private int size;

	// ////////// Constructor ////////////
	public ArrayList(int cap) {
		elems = (E[]) new Object[cap];
		size = 0;
	}
	
	public ArrayList(){
		this(10);
	}

	public boolean isEmpty() {

		return (size == 0);
	}

	public int size() {
		return size;
	}

	// Return the element at position p in this list.
	public E get(int p) {
		if (p < 0 || p >= size)
			throw new NoSuchElementException();
		return elems[p];

	}

	// Return true if and only if this list and that have the
	// same length, and each element of this list equals
	// the corresponding element of that.
	public boolean equals(List<E> that) {
		if (that.size() != size)
			return false;
		for (int i = 0; i < size; i++) {
			if (!this.get(i).equals(that.get(i)))
				return false;
		}
		return true;
	}

	// Make this list empty.
	public void clear() {
		size = 0;

	}

	// Replace the element at position p in
	// this list by it.
	public void set(int p, E it) {
		if (p < 0 || p >= size)
			throw new NoSuchElementException();
		else
			elems[p] = it;

	}

	// Add it at position p in this list
	// if no room, double size of the array
	public void add(int p, E it) {
		if(size==elems.length) doubleArray(); 
		for (int i = size; i >= p; i--)
			elems[i + 1] = elems[i];
		elems[p] = it;
		size++;

	}

	// Add it after the last element of this list.
	public void addLast(E it) {
		elems[size++] = it;

	}

	// Add all the elements of that after the
	// last element of this list.
	public void addAll(List<E> that) {
		int newCapacity = this.size() + that.size();
		while (elems.length < newCapacity)
			doubleArray();
		for (int j = 0; j < that.size(); j++)
			elems[size + j] = that.get(j);
	}

	public E[] getElems() {
		return elems;
	}

	public void setElems(E[] elems) {
		this.elems = elems;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// Remove and return the element at
	// position p in this list.
	public E remove(int p) {
		E val = elems[p];
		for (int i = p + 1; i < size; i++)
			elems[i] = elems[i + 1];
		size--;
		return val;
	}

	// return an iterator that will visit all
	// elements of this list, in left-to-right order.
	public Iterator<E> iterator() {
		return new LRIterator();
	}

	// //////////Inner class ////////////
	private class LRIterator implements Iterator<E> {
		private int position;

		// position is the index of the slot containing the
		// next element to be visited.
		private LRIterator() {
			position = 0;
		}

		public boolean hasNext() {
			return (position < size);
		}

		public E next() {
			if (position >= size)
				throw new NoSuchElementException();
			return elems[position++];
		}

		@Override
		public void remove() {
			// omitting this one

		}

	}

	public void doubleArray() {
		int doub = 2 * elems.length;
		E[] newElems = (E[]) new Object[doub];
		for (int i = 0; i < size; i++)
			newElems[i] = elems[i];
		elems = newElems;
	}

}
