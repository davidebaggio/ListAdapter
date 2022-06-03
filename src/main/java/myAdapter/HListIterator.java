package myAdapter;

import java.util.NoSuchElementException;

/**
 * An iterator for lists that allows the programmer to traverse the list in
 * either direction, modify the list during iteration, and obtain the iterator's
 * current position in the list. A ListIterator has no current element; its
 * cursor position always lies between the element that would be returned by a
 * call to previous() and the element that would be returned by a call to
 * next(). In a list of length n, there are n+1 valid index values, from 0 to n,
 * inclusive.
 * 
 */
public interface HListIterator extends HIterator {

	/**
	 * Inserts the specified element into the list (optional operation). The element
	 * is inserted immediately before the next element that would be returned by
	 * next, if any, and after the next element that would be returned by previous,
	 * if any. (If the list contains no elements, the new element becomes the sole
	 * element on the list.) The new element is inserted before the implicit cursor:
	 * a subsequent call to next would be unaffected, and a subsequent call to
	 * previous would return the new element. (This call increases by one the value
	 * that would be returned by a call to nextIndex or previousIndex.)
	 * 
	 * @param o - object to add
	 * @throws UnsupportedOperationException - if the add method is not supported by
	 *                                       this list iterator.
	 * @throws ClassCastException            - if the class of the specified element
	 *                                       prevents it from being added to this
	 *                                       list.
	 * @throws IllegalArgumentException      - if some aspect of this element
	 *                                       prevents it from being added to this
	 *                                       list.
	 * 
	 */
	void add(Object o) throws UnsupportedOperationException, ClassCastException, IllegalArgumentException;

	/**
	 * Check if the HListIterator has another element before him
	 * 
	 * @return true if the list iterator has more elements when traversing the list
	 *         in the reverse direction.
	 */
	boolean hasPrevious();

	/**
	 * Provides the index of the element in his position
	 * 
	 * @return the index of the element that would be returned by a subsequent call
	 *         to next, or list size if list iterator is at end of list.
	 */
	int nextIndex();

	/**
	 * Returns the previous element in the list. This method may be called
	 * repeatedly to iterate through the list backwards, or intermixed with calls to
	 * next to go back and forth. (Note that alternating calls to next and previous
	 * will return the same element repeatedly.)
	 * 
	 * @return the previous element in the list
	 * @throws NoSuchElementException - if the iteration has no previous element.
	 */
	Object previous() throws NoSuchElementException;

	/**
	 * Provides the index of the element before him
	 * 
	 * @return the index of the element that would be returned by a subsequent call
	 *         to previous, or -1 if list iterator is at beginning of list.
	 */
	int previousIndex();

	/**
	 * Replaces the last element returned by next or previous with the specified
	 * element (optional operation). This call can be made only if neither
	 * ListIterator.remove nor ListIterator.add have been called after the last call
	 * to next or previous.
	 * 
	 * @param o - object to set
	 * @throws UnsupportedOperationException - if the set operation is not supported
	 *                                       by this list iterator.
	 * 
	 * @throws ClassCastException            - if the class of the specified element
	 *                                       prevents it from being added to this
	 *                                       list.
	 * 
	 * @throws IllegalArgumentException      - if some aspect of the specified
	 *                                       element prevents it from being added to
	 *                                       this list.
	 * 
	 * @throws IllegalStateException         - if neither next nor previous have
	 *                                       been called, or remove or add have been
	 *                                       called after the last call to next or
	 *                                       previous.
	 * 
	 */
	void set(Object o)
			throws UnsupportedOperationException, ClassCastException, IllegalArgumentException, IllegalStateException;

}
