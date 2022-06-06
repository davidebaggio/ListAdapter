package myAdapter;

/**
 * The collection interface at the root of all data structure interfaces. A
 * collection represents a group of objects, known as its elements. Some
 * collections allow duplicate elements and others do not. Some are ordered and
 * others unordered. The SDK does not provide any direct implementations of this
 * interface: it provides implementations of more specific subinterfaces like
 * Set and List. This interface is typically used to pass collections around and
 * manipulate them where maximum generality is desired.
 * 
 * @author Davide Baggio
 */
public interface HCollection {

	/**
	 * Ensures that this collection contains the specified element (optional
	 * operation). Returns true if this collection changed as a result of the call.
	 * (Returns false if this collection does not permit duplicates and already
	 * contains the specified element.)
	 * Collections that support this operation may place limitations on what
	 * elements may be added to this collection. In particular, some collections
	 * will refuse to add null elements, and others will impose restrictions on the
	 * type of elements that may be added. Collection classes should clearly specify
	 * in their documentation any restrictions on what elements may be added.
	 * 
	 * If a collection refuses to add a particular element for any reason other than
	 * that it already contains the element, it must throw an exception (rather than
	 * returning false). This preserves the invariant that a collection always
	 * contains the specified element after this call returns.
	 * 
	 * @param o - Object to add
	 * @return true if this collection changed as a result of the call
	 * 
	 * @throws UnsupportedOperationException - add is not supported by this
	 *                                       collection.
	 * 
	 * @throws ClassCastException            - class of the specified element
	 *                                       prevents it from being added to this
	 *                                       collection.
	 * 
	 * @throws NullPointerException          - if the specified element is null and
	 *                                       this collection does not support null
	 *                                       elements.
	 * 
	 * @throws IllegalArgumentException      - some aspect of this element prevents
	 *                                       it from being added to this collection.
	 */
	boolean add(Object o)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;

	/**
	 * Adds all of the elements in the specified collection to this collection
	 * (optional operation). The behavior of this operation is undefined if the
	 * specified collection is modified while the operation is in progress. (This
	 * implies that the behavior of this call is undefined if the specified
	 * collection is this collection, and this collection is nonempty.)
	 * 
	 * @param h - HCollection to add
	 * @return true if this collection changed as a result of the call
	 * 
	 * @throws UnsupportedOperationException - if this collection does not support
	 *                                       the addAll method.
	 * 
	 * @throws ClassCastException            - if the types of one or more elements
	 *                                       in the
	 *                                       specified collection are incompatible
	 *                                       with this
	 *                                       collection (optional).
	 * 
	 * @throws NullPointerException          - if the specified collection contains
	 *                                       one or more null elements and this
	 *                                       collection does not support null
	 *                                       elements, or if the specified
	 *                                       collection is null.
	 * 
	 * @throws IllegalArgumentException      - some aspect of an element of the
	 *                                       specified collection prevents it from
	 *                                       being added to this collection.
	 * 
	 */
	boolean addAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;

	/**
	 * Removes all of the elements from this collection (optional operation). This
	 * collection will be empty after this method returns unless it throws an
	 * exception.
	 * 
	 * @throws UnsupportedOperationException - if the clear method is not supported
	 *                                       by this collection.
	 * 
	 */
	void clear() throws UnsupportedOperationException;

	/**
	 * Search an object in the Collection
	 * 
	 * @param o - Object to search
	 * @return true if this collection contains the specified element
	 * 
	 * @throws ClassCastException   - if the type of the specified element is
	 *                              incompatible with this collection
	 *                              (optional).
	 * @throws NullPointerException - if the specified element is null and
	 *                              this collection does not support null
	 *                              elements (optional).
	 * 
	 */
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * Search all the given object in the collection
	 * 
	 * @param h - HCollection to search
	 * @return true if this collection contains all of the elements in the specified
	 *         collection
	 * 
	 * @throws ClassCastException   - if the types of one or more elements in the
	 *                              specified collection are incompatible with this
	 *                              collection (optional).
	 * 
	 * @throws NullPointerException - if the specified collection contains one or
	 *                              more null elements and this collection does not
	 *                              support null elements (optional) or the
	 *                              specified collection is null.
	 * 
	 */
	boolean containsAll(HCollection h) throws ClassCastException, NullPointerException;

	/**
	 * Compares the specified object with this collection for equality.
	 * 
	 * @param o - Object to compare
	 * @return Compares the specified object with this collection for equality.
	 * 
	 */
	boolean equals(Object o);

	/**
	 * Returns the hash code value for this collection. While the Collection
	 * interface adds no stipulations to the general contract for the
	 * Object.hashCode method, programmers should take note that any class that
	 * overrides the Object.equals method must also override the Object.hashCode
	 * method in order to satisfy the general contract for the
	 * Object.hashCodemethod. In particular, c1.equals(c2) implies that
	 * c1.hashCode()==c2.hashCode().
	 * 
	 * @return the hash code
	 */
	int hashCode();

	/**
	 * Check if the collection is empty.
	 * 
	 * @return true if this collection has no elements, otherwise false
	 */
	boolean isEmpty();

	/**
	 * Provides an HIterator of the Collection
	 * 
	 * @return an iterator over the element in this collection
	 */
	HIterator hIterator();

	/**
	 * Removes a single instance of the specified element from this collection, if
	 * it is present (optional operation). More formally, removes an element e such
	 * that (o==null ? e==null : o.equals(e)), if this collection contains one or
	 * more such elements.
	 * 
	 * @param o - Object to remove
	 * @return true if this collection contained the specified
	 *         element (or equivalently, if this collection changed as a result of
	 *         the
	 *         call).
	 * @throws ClassCastException            - if the type of the specified element
	 *                                       is incompatible with this collection
	 *                                       (optional).
	 * 
	 * @throws NullPointerException          - if the specified element is null and
	 *                                       this collection does not support null
	 *                                       elements (optional).
	 * 
	 * @throws UnsupportedOperationException - remove is not supported by this
	 *                                       collection.
	 * 
	 */
	boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException;

	/**
	 * Removes all this collection's elements that are also contained in the
	 * specified collection (optional operation). After this call returns, this
	 * collection will contain no elements in common with the specified collection.
	 * 
	 * @param h - HCollection to remove
	 * @return true if this collection changed as a result of the call
	 * 
	 * @throws UnsupportedOperationException - if the removeAll method is not
	 *                                       supported by this collection.
	 * 
	 * @throws ClassCastException            - if the types of one or more elements
	 *                                       in this collection are incompatible
	 *                                       with the specified collection
	 *                                       (optional).
	 * 
	 * @throws ClassCastException            - if the types of one or more elements
	 *                                       in this collection are incompatible
	 *                                       with the specified collection
	 *                                       (optional) or the specified collection
	 *                                       is null.
	 * 
	 */
	boolean removeAll(HCollection h) throws UnsupportedOperationException, ClassCastException, NullPointerException;

	/**
	 * Retains only the elements in this collection that are contained in the
	 * specified collection (optional operation). In other words, removes from this
	 * collection all of its elements that are not contained in the specified
	 * collection.
	 * 
	 * @param h - HCollection to retain.
	 * @return true if the dimension of the list changes.
	 * @throws UnsupportedOperationException - if the retainAll method is not
	 *                                       supported by this Collection.
	 * 
	 * @throws ClassCastException            - if the types of one or more elements
	 *                                       in this collection are incompatible
	 *                                       with the specified collection
	 *                                       (optional).
	 * 
	 * @throws NullPointerException          - if this collection contains one or
	 *                                       more null elements and the specified
	 *                                       collection does not support null
	 *                                       elements (optional) or the specified
	 *                                       collection is null.
	 * 
	 */
	boolean retainAll(HCollection h) throws UnsupportedOperationException, ClassCastException, NullPointerException;

	/**
	 * Provides the size of the collection
	 * 
	 * @return the number of elements in this collections. If it si grater
	 *         than Integer.MAX_VALUE returns Integer.MAX_VALUE
	 */
	int size();

	/**
	 * Returns an array containing all of the elements in this collection. If the
	 * collection makes any guarantees as to what order its elements are returned by
	 * its iterator, this method must return the elements in the same order.
	 * The returned array will be "safe" in that no references to it are maintained
	 * by this collection. (In other words, this method must allocate a new array
	 * even if this collection is backed by an array). The caller is thus free to
	 * modify the returned array.
	 * 
	 * @return an array containing all of the elements in this collection
	 * 
	 */
	Object[] toArray();

	/**
	 * Returns an array containing all of the elements in this collection; the
	 * runtime type of the returned array is that of the specified array. If the
	 * collection fits in the specified array, it is returned therein. Otherwise, a
	 * new array is allocated with the runtime type of the specified array and the
	 * size of this collection.
	 * 
	 * @param a - runtime type of array to store elements
	 * @return an array containing all of the elements in this collection with the
	 *         array having the same runtime type of the given array
	 * @throws ArrayStoreException  - the runtime type of the specified array is not
	 *                              a supertype of the runtime type of every element
	 *                              in this collection.
	 * 
	 * @throws NullPointerException - if the specified array is null.
	 * 
	 */
	Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException;

}