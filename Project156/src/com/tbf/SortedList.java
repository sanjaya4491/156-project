package com.tbf;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A sorted list that uses a linked list for its structure.
 * Parameterized to hold any type T
 *
 * @param <T>
 */

public class SortedList<T> implements Iterable<T>{

	private Node<T> head;
	private int size;
	private Comparator<T> comparator;
	
	public SortedList(Comparator<T> comparator) {
		this.comparator = comparator;
		this.head = null;
		this.size = 0;
	}


	/**
	 * Returns the size of the list, the number of elements currently stored in it.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Clears out the contents of the list, making it an empty list.
	 */
	public void clear() {
		while(this.head != null) {
			this.head = this.head.getNext();
			this.size--;
		}
	}
	
	/**
	 * Inserts a node with the given key into the list and maintains order by using a comparator
	 * to place the key into the right place.
	 * 
	 * @param key
	 */
	public void insert(T key) {
		Node<T> newNode = new Node<T>(key);
		Node<T> curr = this.head;
		Node<T> prev = null;
		while(curr != null && comparator.compare(newNode.getItem(), curr.getItem()) > 0) {
			prev = curr;
			curr = curr.getNext();
		}
		if(prev == null) {
			this.head = newNode;
		} else {
			prev.setNext(newNode);
		}
		newNode.setNext(curr);
		this.size++;
	}
	
	/**
	 * This method removes the node with the given key, indices start at 0.
	 * Remaining elements' indices are reduces.
	 * 
	 * @param key
	 */
	public void removeWithValue(T key) {
		if(this.size == 0) {
			throw new IllegalStateException("You cannot remove from an empty list");
		} else if(this.head == getNodeWithValue(key)) {
			this.head = this.head.getNext();
			size--;
			return;
		}
		Node<T> curr = getNodeWithValue(key);
		Node<T> prev = null;
		prev.setNext(curr.getNext());
		this.size--;
	}

	/**
	 * This method removes the node from the given position, indices start at 0.
	 * Remaining elements' indices are reduced.
	 * 
	 * @param position
	 */
	public void removeAtIndex(int position) {
		if(this.size == 0) {
			throw new IllegalStateException("You cannot remove from an empty list");
		} else if(position == 0) {
			this.head = this.head.getNext();
			size--;
			return;
		}
		Node<T> prev = getNodeAtIndex(position-1);
		Node<T> curr = prev.getNext();
		prev.setNext(curr.getNext());
		this.size--;
	}
	
	/**
	 * This is a private helper method that returns a corresponding node
	 * to the given position.
	 * 
	 * @param position
	 * @return
	 */
	private Node<T> getNodeAtIndex(int position) {
		if(position < 0 || position >= this.size) {
			throw new IndexOutOfBoundsException("Invalid Position Provided");
		}
		Node<T> curr = this.head;
		for(int i=0; i<position; i++) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	/**
	 * Returns the node with the given key
	 * 
	 * @param item
	 * @return
	 */
	private Node<T> getNodeWithValue(T key) {
		Node<T> curr = this.head;
		while(curr != null && !curr.getItem().equals(key)) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	/**
	 * Returns the element stored at the given position.
	 * 
	 * @param position
	 * @return
	 */
	public T getItemAtIndex(int position) {
		return getNodeAtIndex(position).getItem();
	}
	
	/**
	 * Prints this list to the standard output.
	 */
	public void print() {
		Node<T> curr = this.head;
		while(curr != null) {
			System.out.println(curr.getItem().toString());
			curr = curr.getNext();
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> curr = head;
			@Override
			public boolean hasNext() {
				if(curr == null)
					return false;
				else
					return true;
			}
			@Override
			public T next() {
				T item = curr.getItem();
				curr = curr.getNext();
				return item;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("not implemented");
			}};	}
}
