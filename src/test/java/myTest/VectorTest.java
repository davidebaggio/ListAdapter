package myTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.*;

import myAdapter.*;

/**
 * Summary: This test suite provides information about the correct working of
 * the class {@link myAdapter.Vector}, which works as the adaptee of the
 * {@link myAdapter.ListAdapter} class.
 * <br>
 * <br>
 * Test Suite Design: The design of this thest suite is all about testing each
 * method of the Vector class. The reason is to isolate every type of operation
 * in order to validate each functionality.
 * <br>
 * <br>
 * 
 * Pre-condition: J2RE 1.4.2 and JUnit 4.13.1 installed and added to the path.
 * <br>
 * <br>
 * 
 * Post-Condition: All the test have to provide a positive outcome given true
 * logical expression
 * <br>
 * <br>
 * 
 * Test Cases:
 * {@link #testAddElement()}, {@link #testCapacity()}, {@link #testContains()},
 * {@link #testCopyInto()}, {@link #testElementAt()},
 * {@link #testEnsureCapacity()}, {@link #testFirstElement()},
 * {@link #testIndexOf()}, {@link #testInsertElementAt()},
 * {@link #testIsEmpty()}, {@link #testLastElement()},
 * {@link #testLastIndexOf()}, {@link #testRemoveElementAt()},
 * {@link #testSetElementAt()}
 * <br>
 * <br>
 * 
 * Test Suite Execution Records:
 * <br>
 * <br>
 * 
 * Execution Variables:
 * 
 * @author Davide Baggio
 * @see myAdapter.Vector
 */
public class VectorTest {
	Vector vec;

	/**
	 * Method for initializing execution variables before tests
	 * <p>
	 * A new and empty Collection is created before each test method,
	 * in this way the collection on which the various tested methods
	 * are invoked always has a valid state
	 * <br>
	 * <br>
	 * Preconditions: The constructor successfully instantiates a new object
	 * of the ListAdapter class
	 */
	@Before
	public void setup() {
		vec = new Vector();
	}

	/**
	 * Method for deleting all the operation on the vector in order to compute
	 * another test.
	 */
	@After
	public void clean() {
		this.vec = null;
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#addElement(Object)} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if elements are added
	 * to
	 * the Vector
	 * <br>
	 * <br>
	 * Test Description: Three elements have been added to the vector sequentially,
	 * then we check if the vector size and element at index 1 are present. If so
	 * the add
	 * methods works correctly
	 * <br>
	 * <br>
	 * Pre-condition: The vector has to be initialize as empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the Vector.
	 * <br>
	 * <br>
	 * Expected Results: Vector.size() == 3 && Vector.elementAt(1) == 4;
	 */
	@Test
	public void testAddElement() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertEquals(3, vec.size());
		assertEquals(4, vec.elementAt(1));
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#capacity()} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the capacity is
	 * grater
	 * than the size of the vector so it can store more elements.
	 * <br>
	 * <br>
	 * Test Description: Three elements have been added to the vector sequentially,
	 * then the Vector.size() and Vector.capacity() are called.
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialized as Empty
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and more
	 * elements can be stored.
	 * <br>
	 * <br>
	 * Expected Results: Vector.size() < Vector.capacity()
	 */
	@Test
	public void testCapacity() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertTrue(vec.size() < vec.capacity());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#contains(Object)} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the given element
	 * is present in the Vector.
	 * <br>
	 * <br>
	 * Test Description: Three elements have been added to the vector sequentially,
	 * then the Vector.contains(Object) method is called twice in order to prove
	 * that the element that has been passed is present.
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the Vector
	 * <br>
	 * <br>
	 * Expected Results: Vector.contains(1) == true && vector.contains(10) == false;
	 */
	@Test
	public void testContains() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertTrue("Element 1 is not present in the Vector", vec.contains(1));
		assertFalse("Element 10 is present in the Vector", vec.contains(10));
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#copyInto(Object[])} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the elements are
	 * correctly copied in the given array.
	 * <br>
	 * <br>
	 * Test Description: Three elements have been added to the Vector. Than a new
	 * array is created and it will be the parameter for the copyInto method. It
	 * checks if the array length is big enough to store all the elements and will
	 * print the results.
	 * <br>
	 * <br>
	 * Pre-condition: The vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and a
	 * new array with all the element is created.
	 * <br>
	 * <br>
	 * Expected Results: The array arr contains elements 1,4,1.
	 */
	@Test
	public void testCopyInto() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		Object[] arr = new Object[2];
		try {
			vec.copyInto(arr);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}
		Object[] arr2 = null;
		try {
			vec.copyInto(arr2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		arr = new Object[3];
		vec.copyInto(arr);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(vec.elementAt(i), arr[i]);
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#elementAt(int)} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It returns the element at a
	 * specific index considering the fact that the index has to be less than the
	 * Vector.size().
	 * <br>
	 * <br>
	 * Test Description: Three elements are added in the Vector sequentially, then
	 * two indexes are given in order to prove that the
	 * ArrayIndexoutOfBoundException is thrown and the other index can return an
	 * element.
	 * <br>
	 * <br>
	 * Pre-condition: The vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and an
	 * element has to be returned as the result of the call to this function.
	 * <br>
	 * <br>
	 * Expected Results: Vector.elementAt(8) throws an Exception &&
	 * Vector.elementAt(1) == 4;
	 */
	@Test
	public void testElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		try {
			vec.elementAt(8);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}
		assertEquals(4, vec.elementAt(1));
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#ensureCapacity(int)} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the capacity of the
	 * vector has been increased in order to
	 * <br>
	 * <br>
	 * Test Description: Three elements have been added to the Vector sequentially.
	 * Then the capacity is checked and we increase the minCapacity by the amount we
	 * need.
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the Vector and the
	 * min capacity is increased.
	 * <br>
	 * <br>
	 * Expected Results: n less than vec.capacity() && vec.capacity() == 100;
	 */
	@Test
	public void testEnsureCapacity() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		int n = vec.capacity();
		vec.ensureCapacity(100);

		assertTrue(n < vec.capacity());
		assertEquals(100, vec.capacity());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#firstElement()} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the first element
	 * is correctly returned by the call to this function. If the vec is empty
	 * NoSuchElementException is thrown.
	 * br>
	 * <br>
	 * Test Description: First the method is called to prove that the exception is
	 * thrown then we add three elements to the vector sequentially and the method
	 * is called again.
	 * <br>
	 * <br>
	 * Pre-condition: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and the
	 * first element is returned;
	 * <br>
	 * <br>
	 * Expected Results: Vector.firstElement() == 1;
	 */
	@Test
	public void testFirstElement() {
		try {
			vec.firstElement();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(1, vec.firstElement());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#indexOf(Object)},
	 * {@link myAdapter.Vector#indexOf(Object, int)} methods
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. For the first method we just
	 * check if the element is present in the Vector, then for the second method we
	 * also check if the ArrayIndexOutOfBoundException is thrown,
	 * <br>
	 * <br>
	 * Test Description: Three elements are added to the Vector sequentially. Then
	 * both of the methods are called to prove the claims as the test design
	 * explains.
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the Vector and the
	 * methods have to return indexes of the object passed as paramaters.
	 * <br>
	 * <br>
	 * Expected Results: vec.indexOf(1) == 0 && vec.indexOf(10) == -1 &&
	 * vec.indexOf(1,1) == 2 && vec.indexOf(10,1) == -1;
	 */
	@Test
	public void testIndexOf() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(0, vec.indexOf(1));
		assertEquals(-1, vec.indexOf(10));
		assertEquals(2, vec.indexOf(1, 1));
		assertEquals(-1, vec.indexOf(10, 1));

		try {
			vec.indexOf(3, -1);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#insertElementAt(Object, int)}
	 * method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * inserted in the correct position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * Test Description: Three elements are added to the Vector sequentially, then
	 * an element is inserted in the position of index = 2;
	 * Then another element is inserted at index = 5;
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: Four elements should be present in the Vector at the end of
	 * the test.
	 * <br>
	 * <br>
	 * Expected Results: vec.elementAt(2) == 3 && vec.size() == 4;
	 */
	@Test
	public void testInsertElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.insertElementAt(3, 2);
		assertEquals(3, vec.elementAt(2));

		try {
			vec.insertElementAt(10, 5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(4, vec.size());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#isEmpty()} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if there are no
	 * elements
	 * in the Vector.
	 * br>
	 * <br>
	 * Test Description: First the method is called to prove that the Vector is
	 * Empty and then three elements are added to the Vector in order to prove that
	 * it is not empty anymore.
	 * <br>
	 * <br>
	 * Pre-condition: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and the
	 * Vector is not Empty;
	 * <br>
	 * <br>
	 * Expected Results: Vector.isEmpty() == true && (at the end) Vector.isEmpty ==
	 * false;
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(vec.isEmpty());

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertFalse(vec.isEmpty());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#lastElement()} method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the last element
	 * is correctly returned by the call to this function. If the vec is empty
	 * NoSuchElementException is thrown.
	 * br>
	 * <br>
	 * Test Description: First the method is called to prove that the exception is
	 * thrown then we add three elements to the vector sequentially and the method
	 * is called again.
	 * <br>
	 * <br>
	 * Pre-condition: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the vector and the
	 * last element is returned;
	 * <br>
	 * <br>
	 * Expected Results: Vector.lastElement() == 1;
	 */
	@Test
	public void testLastElement() {
		try {
			vec.lastElement();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(1, vec.lastElement());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#lastIndexOf(Object)},
	 * {@link myAdapter.Vector#lastIndexOf(Object, int)} methods
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. For the first method we just
	 * check if the element is present in the Vector and return the last index of
	 * the occurance, then for the second method we also check if the
	 * IndexOutOfBoundException is thrown
	 * <br>
	 * <br>
	 * Test Description: Three elements are added to the Vector sequentially. Then
	 * both of the methods are called to prove the claims as the test design
	 * explains.
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: The three elements are correctly added to the Vector and the
	 * methods have to return the last indexes of the object passed as paramaters.
	 * <br>
	 * <br>
	 * Expected Results: vec.lastIndexOf(1) == 2 && vec.lastIndexOf(10) == -1 &&
	 * vec.lastIndexOf(1,1) == 0 && vec.indexOf(10,1) == -1;
	 */
	@Test
	public void testLastIndexOf() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(2, vec.lastIndexOf(1));
		assertEquals(-1, vec.lastIndexOf(10));
		assertEquals(0, vec.lastIndexOf(1, 1));
		assertEquals(-1, vec.lastIndexOf(10, 1));

		try {
			vec.lastIndexOf(3, 10);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#removeElementAt(int)}
	 * method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * removed from the given position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * Test Description: Three elements are added to the Vector sequentially, then
	 * an element is removed from the position of index = 1;
	 * Then another element is removed at index = 5;
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: Two elements should be present in the Vector at the end of
	 * the test.
	 * <br>
	 * <br>
	 * Expected Results: vec.elementAt(1) == 1 && vec.size() == 2;
	 */
	@Test
	public void testRemoveElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.removeElementAt(1);

		try {
			vec.removeElementAt(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(1, vec.elementAt(1));
		assertEquals(2, vec.size());
	}

	/**
	 * Summary: Tests the {@link myAdapter.Vector#setElementAt(Object, int)}
	 * method
	 * <br>
	 * <br>
	 * Test Case Design: the design is very simple as it is related to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * set at a given position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * Test Description: Three elements are added to the Vector sequentially, then
	 * an element is set at position of index = 1;
	 * Then another element is set at index = 5;
	 * <br>
	 * <br>
	 * Pre-condition: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * Post-Condition: Three elements should be present in the Vector at the end of
	 * the test.
	 * <br>
	 * <br>
	 * Expected Results: vec.elementAt(1) == 5 && vec.size() == 3;
	 */
	@Test
	public void testSetElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.setElementAt(5, 1);

		try {
			vec.setElementAt(6, 5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(5, vec.elementAt(1));
		assertEquals(3, vec.size());
	}
}
