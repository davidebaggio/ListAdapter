package myTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.*;

import myAdapter.*;

/**
 * Summary:
 * <br>
 * Test Suite Design:
 * <br>
 * Pre-condition:
 * <br>
 * Post-Condition:
 * <br>
 * Test Cases:
 * <br>
 * Test Suite Execution Records:
 * <br>
 * Execution Variables:
 */
public class IteratorTest {

	ListAdapter list;
	ListAdapter uList;
	HListIterator iter;
	HListIterator uIter;

	@Before
	public void setup() {
		list = new ListAdapter(true);
		iter = list.hListIterator();

		uList = new ListAdapter(false);
		uIter = uList.hListIterator();
	}

	@After
	public void clean() {
		list = null;
		iter = null;

		uList = null;
		uIter = null;
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#hasNext()} method
	 * <br>
	 * <br>
	 * Test Case Design: The test provides informations about the presence of
	 * another element in the next position of the iterator index.
	 * <br>
	 * <br>
	 * Test Description: Two elements are added in the List and the iterator through
	 * the method check if it has more elements in the list.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Iterator should find itself in the last position of the list.
	 * <br>
	 * <br>
	 * Expected Results: IteratorAdapter.hasNext() == true until last element
	 * included;
	 */
	@Test
	public void testHasNext() {

		list.add(2);
		list.add(8);
		assertTrue(iter.hasNext());
		iter.next();
		assertTrue(iter.hasNext());
		iter.next();
		assertFalse(iter.hasNext());

	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#next()} method
	 * <br>
	 * <br>
	 * Test Case Design: The test should return each element in the iterator
	 * position and an Exception if there are no elements at the end.
	 * <br>
	 * <br>
	 * Test Description: Some elements are added in the list. Then the next() method
	 * is call in a for loop until last element. Each loop is returning the object
	 * in the iterator position. At the end the next() method is called again in
	 * order to throw NoSuchElementException.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Iterator should find itself in the last position of the list.
	 * <br>
	 * <br>
	 * Expected Results: next() == list.get(index) each loop;
	 */
	@Test
	public void testNext() {

		list.add(2);
		list.add(8);
		list.add(2);
		list.add(4);
		list.add(5);

		int index = 0;
		while (iter.hasNext()) {
			assertEquals(list.get(index), iter.next());
			index++;
		}

		try {
			iter.next();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#remove()}
	 * <br>
	 * <br>
	 * Test Case Design: This test provides informations about all the possible
	 * {@link myAdapter.HIteratorState} that throw IllegalStateException. Then it
	 * tries to remove elements in the list.
	 * <br>
	 * <br>
	 * Test Description: In the first place we look for exceptions to be thrown such
	 * as UnsupportedOperationException then if the states are correct the remove
	 * method is called after 5 elements have been added to the list;
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Only three elements should be present in the List.
	 * <br>
	 * <br>
	 * Expected Results: Elements in the List: 2,4,5.
	 */
	@Test
	public void testRemove() {
		try {
			uIter.remove();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(UnsupportedOperationException.class, e.getClass());
		}
		try {
			iter.remove();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		list.add(2);
		list.add(8);
		list.add(2);
		list.add(4);
		list.add(5);
		iter.next();
		iter.remove();

		try {
			iter.remove();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		iter.next();
		iter.previous();
		iter.remove();

		assertEquals(3, list.size());
		assertArrayEquals(new Object[] { 2, 4, 5 }, list.toArray());

	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#add()}
	 * <br>
	 * <br>
	 * Test Case Design: This test tries to add elements in the list if that is a
	 * supported operation.
	 * <br>
	 * <br>
	 * Test Description: In the first place we look for exceptions to be thrown such
	 * as UnsupportedOperationException then the add method is called;
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Three elements should be present in the List.
	 * <br>
	 * <br>
	 * Expected Results: Elements in the List: 2,4,5.
	 */
	@Test
	public void testAdd() {
		try {
			uIter.add(2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(UnsupportedOperationException.class, e.getClass());
		}

		iter.add(2);
		iter.add(4);
		iter.add(5);

		assertArrayEquals(new Object[] { 2, 4, 5 }, list.toArray());
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#hasPrevious()} method
	 * <br>
	 * <br>
	 * Test Case Design: The test provides informations about the presence of
	 * another element in the previous position of the iterator index.
	 * <br>
	 * <br>
	 * Test Description: Two elements are added in the List and the iterator through
	 * the method check if it has more elements before him in the list.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Iterator should find itself in the first position of the
	 * list.
	 * <br>
	 * <br>
	 * Expected Results: IteratorAdapter.hasprevious() == true until first element
	 * included;
	 */
	@Test
	public void testHasPrevious() {
		list.add(2);
		list.add(8);
		iter.next();
		iter.next();

		assertTrue(iter.hasPrevious());
		iter.previous();
		assertTrue(iter.hasPrevious());
		iter.previous();
		assertFalse(iter.hasPrevious());
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#nextIndex()} method
	 * <br>
	 * <br>
	 * Test Case Design: This test provides information about nextIndex() calls. No
	 * exceptions are thrown.
	 * <br>
	 * <br>
	 * Test Description: Two elements are added to the list and the nextIndex()
	 * method is called.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Two elements are correctly added to the list and the iterator
	 * should return correct indexes.
	 * <br>
	 * <br>
	 * Expected Results: nextIndex() == 0, nextIndex() == 1;
	 */
	@Test
	public void testNextIndex() {
		list.add(2);
		list.add(8);

		assertEquals(0, iter.nextIndex());
		iter.next();
		assertEquals(1, iter.nextIndex());
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#previous()} method
	 * <br>
	 * <br>
	 * Test Case Design: The test should return each element in the iterator
	 * position and an Exception if there are no elements before index 0.
	 * <br>
	 * <br>
	 * Test Description: Some elements are added in the list. Then the previous()
	 * method
	 * is call in a for loop until first element. Each loop is returning the object
	 * in the iterator position. At the end the previous() method is called again in
	 * order to throw NoSuchElementException.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Iterator should find itself in the first position of the
	 * list.
	 * <br>
	 * <br>
	 * Expected Results: previous() == list.get(index) each loop;
	 */
	@Test
	public void testPrevious() {
		list.add(2);
		list.add(8);
		list.add(2);
		list.add(4);
		list.add(5);
		iter = list.hListIterator(list.size());

		int index = list.size() - 1;
		while (iter.hasPrevious()) {
			assertEquals(list.get(index), iter.previous());
			index--;
		}
		try {
			iter.previous();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#previousIndex()} method
	 * <br>
	 * <br>
	 * Test Case Design: This test provides information about previousIndex() calls.
	 * No
	 * exceptions are thrown.
	 * <br>
	 * <br>
	 * Test Description: Two elements are added to the list and the previousIndex()
	 * method is called.
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Two elements are correctly added to the list and the iterator
	 * should return correct indexes.
	 * <br>
	 * <br>
	 * Expected Results: previousIndex() == 1, previousIndex() == 0;
	 */
	@Test
	public void testPreviousIndex() {
		list.add(2);
		list.add(8);

		iter = list.hListIterator(list.size());
		assertEquals(1, iter.previousIndex());
		iter.previous();
		assertEquals(0, iter.previousIndex());
	}

	/**
	 * Summary: Tests the {@link myAdapter.IteratorAdapter#set()}
	 * <br>
	 * <br>
	 * Test Case Design: This test tries to set elements in the list if that is a
	 * supported operation.
	 * <br>
	 * <br>
	 * Test Description: In the first place we look for exceptions to be thrown such
	 * as UnsupportedOperationException then the set method is called;
	 * <br>
	 * <br>
	 * Pre-condition: List is initialize as Empty and has to initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * Post-Condition: Three elements should be present in the List.
	 * <br>
	 * <br>
	 * Expected Results: Elements in the List: 2,4,5.
	 */
	@Test
	public void testSet() {
		try {
			uIter.set(10);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(UnsupportedOperationException.class, e.getClass());
		}
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		list.add(2);
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}
		list.add(7);
		list.add(6);
		list.add(8);

		iter.next();
		iter.next();
		iter.remove();
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		iter.next();
		iter.set(4);

		iter = list.hListIterator(list.size());
		iter.previous();
		iter.set(5);

		assertArrayEquals(new Object[] { 2, 4, 5 }, list.toArray());

	}

}
