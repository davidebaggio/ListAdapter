package myTest;

import static org.junit.Assert.assertEquals;

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
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void tetsAddElement() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertEquals(3, vec.size());
		assertEquals(4, vec.elementAt(1));
	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testCapacity() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testContains() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testCopyInto() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testElementAt() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testElements() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testEnsureCapacity() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testFirstElement() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testIndexOf() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testInsertElementAt() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testIsEmpty() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testLastElement() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testLastIndexOf() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testRemoveElementAt() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testSetElementAt() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testSetSize() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testSize() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testToString() {

	}

	/**
	 * Summary:
	 * <br>
	 * Test Case Design:
	 * <br>
	 * Test Description:
	 * <br>
	 * Pre-condition:
	 * <br>
	 * Post-Condition:
	 * <br>
	 * Expected Results:
	 */
	@Test
	public void testTrimToSize() {

	}
}
