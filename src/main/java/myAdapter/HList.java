package myAdapter;

/**
 * A collection (also known as a sequence). The user of this interface
 * has precise control over where in the list each element is inserted. The user
 * can access elements by their integer index (position in the list), and search
 * for elements in the list.
 */
public interface HList extends HCollection {
	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation). Shifts the element currently at that position (if any)
	 * and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index   - specific index to add a new element
	 * @param element - element to add
	 * @throws UnsupportedOperationException - if the addAll method is not supported
	 *                                       by this list.
	 * 
	 * @throws ClassCastException            - if the class of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws NullPointerException          - if the specified collection contains
	 *                                       one or more null elements and this list
	 *                                       does not support null elements, or if
	 *                                       the specified collection is null.
	 * 
	 * @throws IllegalArgumentException      - if some aspect of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws IndexOutOfBoundsException     - if the index is out of range
	 *                                       (index <
	 *                                       0 || index > size()).
	 * 
	 */
	void add(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;

	/**
	 * Inserts all of the elements in the specified collection into this list at the
	 * specified position (optional operation). Shifts the element currently at that
	 * position (if any) and any subsequent elements to the right (increases their
	 * indices). The new elements will appear in this list in the order that they
	 * are returned by the specified collection's iterator. The behavior of this
	 * operation is unspecified if the specified collection is modified while the
	 * operation is in progress. (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 * 
	 * @param index - specific index to add a new HCollection
	 * @param o     - HCollection to add
	 * @return true if this list changed as a result of the call.
	 * 
	 * @throws UnsupportedOperationException - if the addAll method is not supported
	 *                                       by this list.
	 * 
	 * @throws ClassCastException            - if the class of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws NullPointerException          - if the specified collection contains
	 *                                       one or more null elements and this list
	 *                                       does not support null elements, or if
	 *                                       the specified collection is null.
	 * 
	 * @throws IllegalArgumentException      - if some aspect of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws IndexOutOfBoundsException     - if the index is out of range
	 *                                       (index <
	 *                                       0 || index > size()).
	 * 
	 */
	boolean addAll(int index, HCollection o) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;

	/**
	 * Provides the element at a given position.
	 * 
	 * @param index - of the object to return
	 * @return the object present in the given index
	 * 
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0
	 *                                   || index >= size()).
	 * 
	 */
	Object get(int index) throws IndexOutOfBoundsException;

	/**
	 * Returns the index in this list of the first occurrence of the specified
	 * element, or -1 if this list does not contain this element. More formally,
	 * returns the lowest index i such that (o==null ? get(i)==null :
	 * o.equals(get(i))), or -1 if there is no such index.
	 * 
	 * @param o - Object to find in the HList
	 * @return the index in this list of the first occurrence of the specified
	 *         element, or -1 if this list does not contain this element.
	 * 
	 * @throws ClassCastException   - if the type of the specified element is
	 *                              incompatible with this list (optional).
	 * 
	 * @throws NullPointerException - if the specified element is null and this list
	 *                              does not support null elements (optional).
	 * 
	 */
	int indexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * Returns the index in this list of the last occurrence of the specified
	 * element, or -1 if this list does not contain this element. More formally,
	 * returns the highest index i such that (o==null ? get(i)==null :
	 * o.equals(get(i))), or -1 if there is no such index.
	 * 
	 * 
	 * @param o - Object to find in the HList
	 * @return the index in this list of the last occurrence of the specified
	 *         element, or -1 if this list does not contain this element.
	 * 
	 * @throws ClassCastException   - if the type of the specified element is
	 *                              incompatible with this list (optional).
	 * 
	 * @throws NullPointerException - if the specified element is null and this list
	 *                              does not support null elements (optional).
	 * 
	 */
	int lastIndexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * Provides an HListIterator of the HList
	 * 
	 * @return a list iterator of the elements in this list (in proper sequence).
	 * 
	 */
	HListIterator hListIterator();

	/**
	 * Returns a list iterator of the elements in this list (in proper sequence),
	 * starting at the specified position in this list. The specified index
	 * indicates the first element that would be returned by an initial call to the
	 * next method. An initial call to the previous method would return the element
	 * with the specified index minus one.
	 * 
	 * @param index - starting index of the returned HListIterator
	 * @return a list iterator of the elements in this list (in proper sequence),
	 *         starting at the specified position in this list.
	 * 
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0
	 *                                   || index > size()).
	 * 
	 */
	HListIterator hListIterator(int index) throws IndexOutOfBoundsException;

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation). Shifts any subsequent elements to the left (subtracts one from
	 * their indices). Returns the element that was removed from the list.
	 * 
	 * @param index - of the object to remove
	 * @return the removed object
	 * @throws UnsupportedOperationException - if the remove method is not supported
	 *                                       by this list.
	 * 
	 * @throws IndexOutOfBoundsException     - if the index is out of range
	 *                                       (index <
	 *                                       0 || index >= size()).
	 * 
	 */
	Object remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException;

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 * 
	 * @param index   - of the element to set
	 * @param element - to set
	 * @return the element previously at the specified position.
	 * 
	 * @throws UnsupportedOperationException - if the addAll method is not supported
	 *                                       by this list.
	 * 
	 * @throws ClassCastException            - if the class of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws NullPointerException          - if the specified collection contains
	 *                                       one or more null elements and this list
	 *                                       does not support null elements, or if
	 *                                       the specified collection is null.
	 * 
	 * @throws IllegalArgumentException      - if some aspect of one of elements of
	 *                                       the specified collection prevents it
	 *                                       from being added to this list.
	 * 
	 * @throws IndexOutOfBoundsException     - if the index is out of range
	 *                                       (index <
	 *                                       0 || index > size()).
	 * 
	 */
	Object set(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;

	/**
	 * Returns a view of the portion of this list between the specified fromIndex,
	 * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the
	 * returned list is empty.) The returned list is backed by this list, so
	 * non-structural changes in the returned list are reflected in this list, and
	 * vice-versa. The returned list supports all of the optional list operations
	 * supported by this list.
	 * 
	 * @param fromIndex - starting point of the subList
	 * @param toIndex   - ending point of the subList
	 * @return the subHList
	 * @throws IndexOutOfBoundsException - for an illegal endpoint index value
	 *                                   (fromIndex < 0 || toIndex > size ||
	 *                                   fromIndex > toIndex).
	 * 
	 */
	HList subHList(int fromIndex, int toIndex) throws IndexOutOfBoundsException;

}
