package myAdapter;

import java.util.NoSuchElementException;

/**
 * An iterator over a collection. Iterator takes the place of Enumeration in the
 * Java collections framework.
 * 
 * @author Davide Baggio
 */
public interface HIterator {

	/**
	 * Check if the HIterator has another element in his position
	 * 
	 * @return true if the iterator has more elements
	 */
	boolean hasNext();

	/**
	 * Provides the element in his position
	 * 
	 * @return the next element in the iteration
	 * @throws NoSuchElementException - Iteration has no more elements
	 */
	Object next() throws NoSuchElementException;

	/**
	 * Removes from the underlying collection the last element returned by the
	 * iterator (optional operation). This method can be called only once per call
	 * to next. The behavior of an iterator is unspecified if the underlying
	 * collection is modified while the iteration is in progress in any way other
	 * than by calling this method.
	 * 
	 * @throws UnsupportedOperationException - if the remove operation is not
	 *                                       supported by this iterator
	 * @throws IllegalStateException         - if the next method has not yet been
	 *                                       called, or the remove method has
	 *                                       already been called after the last call
	 *                                       to the next method.
	 */
	void remove() throws UnsupportedOperationException, IllegalStateException;

}
