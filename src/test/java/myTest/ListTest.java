package myTest;

import org.junit.*;

import myAdapter.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Summary: This test suite provides tests for the {@link myAdapter.ListAdapter}
 * class methods.
 * <br>
 * <br>
 * Design test: The design of this thest suite is all about testing each
 * method of the Vector class. The reason is to isolate every type of operation
 * in order to validate each functionality.
 * <br>
 * <br>
 * Pre-condition: J2RE 1.4.2 and JUnit 4.13.1 installed and added to the path. A
 * new empty object of type ListAdapter must always be instantiated before
 * each test. All execution variables are never in an uninitialized state (i.e.
 * list = null) unless explicitly desired
 * Methods that take as parameters classes that implement HCollection are passed
 * suitable objects for this interface, therefore they do not throw the
 * exception ClassCastException.
 * All the elements contained in the list are known a priori in order to allow
 * the verification after the invocation of the tested methods
 * <br>
 * <br>
 * Postconditions: the methods implemented must always modify the list so that
 * the elements contained are exactly those expected starting from their manual
 * insertion and have to provide a positive outcome.
 * <br>
 * <br>
 * Test Cases:
 * {@link #testConstructorWithParameter()}, {@link #testAdd()},
 * {@link #testAddAll()}, {@link #testClear()}, {@link #testContains()},
 * {@link #testContainsAll()}, {@link #testIsEmpty()},
 * {@link #testIterator()}, {@link #testRemove()},
 * {@link #testRemoveAll()}, {@link #testRetainAll()},
 * {@link #testSize()}, {@link #testToArray()},
 * {@link #testToArrayWithParameter()}, {@link #testGet()},
 * {@link #testIndexOf()}, {@link #testLastIndexOf()},
 * {@link #testSet()}, {@link #testSubList()}, {@link #testEquals()},
 * {@link #testHashCode()}, {@link #testListIteratorIndex()}.
 * <br>
 * <br>
 * Execution record: each tested method is correct if all the tests that verify
 * the correct functioning give positive results. Correct execution of the
 * entire test method can then be considered the execution record
 * <br>
 * <br>
 * Execution variables: HCollection coll (sopports optional operation), uColl
 * (doesn't support optional operation)
 * <br>
 * HList list, listWithData (support optional operation), uList (doesn't support
 * optional operations).
 * <br>
 * <br>
 *
 * @author Davide Baggio
 * @see myAdapter.ListAdapter
 * @see myAdapter.HCollection
 * @see myAdapter.HList
 */
public class ListTest {
    HCollection coll, uColl;
    private HList list, listWithData, uList;

    /**
     * setup before each test.
     */
    @Before
    public void setup() {
        coll = new ListAdapter(true);
        uColl = new ListAdapter(false);
        list = new ListAdapter(true);
        uList = new ListAdapter(false);
        listWithData = new ListAdapter(true);

        for (int i = 0; i < 5; i++)
            listWithData.add(i + 1);
    }

    /**
     * cleanup after each test
     */
    @After
    public void clean() {
        coll = null;
        uColl = null;

        list = null;
        listWithData = null;
        uList = null;
    }

    /**
     * Summary: tests the
     * {@link myAdapter.ListAdapter#ListAdapter(boolean, HCollection)} constructor,
     * which is a copy constructor.
     * <br>
     * <br>
     * Design test: adding elements to a test collection, the constructor is invoked
     * passing the collection
     * containing the elements as a parameter and the respective
     * arrays obtained with toArray () are compared
     * <br>
     * <br>
     * Preconditions:
     * <br>
     * the passed Collection object is non-null
     * <br>
     * The toArray () method must be working correctly
     * <br>
     * <br>
     * Postconditions: the created object must be the same as the object passed as a
     * parameter
     * <br>
     * <br>
     * 
     * Expected results: the same elements of the test collection
     * must be present in the main test collection
     */
    @Test
    public void testConstructorWithParameter() {
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);

        HCollection newCollection = new ListAdapter(true, coll);

        assertArrayEquals(coll.toArray(), newCollection.toArray());
    }

    /**
     * Summary: tests the {@link myAdapter.ListAdapter#add(Object)} and
     * {@link myAdapter.ListAdapter#add(int, Object)} methods.
     * <br>
     * <br>
     * Design test: elements are added and the array returned by toArray () is
     * analyzed. Exception are thrown first.
     * <br>
     * <br>
     * Description: after adding two values it is verified with the inspection of
     * the array returned by toArray () that the elements have been inserted and are
     * in the right position
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: the collections must contain the value passed as a parameter
     * <br>
     * <br>
     * Expected results: coll.toArray()[0] == 3 && listWithData has to contain the
     * added values.
     */
    @Test
    public void testAdd() {

        // for the HCollections
        try {
            uList.add(1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            coll.add(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
        coll.add(3);
        assertEquals(3, coll.toArray()[0]);

        // for the HList
        try {
            uList.add(0, 5);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            listWithData.add(0, null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
        try {
            listWithData.add(-1, "Exception");
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        listWithData.add(0, 0);
        assertArrayEquals(new Object[] { 0, 1, 2, 3, 4, 5 }, listWithData.toArray());

        listWithData.add(3, 2.5);
        assertArrayEquals(new Object[] { 0, 1, 2, 2.5, 3, 4, 5 }, listWithData.toArray());

        listWithData.add(listWithData.size(), 5.5);
        assertArrayEquals(new Object[] { 0, 1, 2, 2.5, 3, 4, 5, 5.5 }, listWithData.toArray());

        listWithData.clear();
        listWithData.add(0, "wiped");
        assertArrayEquals(new Object[] { "wiped" }, listWithData.toArray());

    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#addAll(HCollection)} and
     * {@link myAdapter.ListAdapter#addAll(int, HCollection)} methods
     * <br>
     * <br>
     * Design test: initially all the exception are thrown for both HCollection and
     * HList implementation. Then a non-null collection is
     * created in which elements are inserted. This collection is used as a
     * parameter of the tested method invoked on a collection that already contains
     * data to verify that the elements of the collection (parameter) are added but
     * not removed from the main collection. Checked if an exception was thrown
     * <br>
     * <br>
     * Description: to verify that the tested method works correctly, elements are
     * added both to the list used as a parameter and to the list in which the
     * method will be invoked (in which the elements will be inserted). These
     * operations are carried out to verify that after the invocation of the tested
     * method the only changes that occurred in the main collection were only the
     * addition of the values ​​contained in the parameter collection and that no
     * elements already present in the main collection were deleted (verified with
     * the of the final size of the main collection which must assume a size equal
     * to the previous one + size of the parameter collection)
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: all the elements contained in the collection passed as a
     * parameter must also belong to the main collection, not considering the
     * elements already belonging to the main collection
     * <br>
     * <br>
     * Expected results: coll.containsAll(testColl) == true && list has to contain
     * the added HCollection
     */
    @Test
    public void testAddAll() {
        // for the HCollections
        HCollection testColl = null;
        try {
            uColl.addAll(testColl);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            coll.addAll(testColl);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        testColl = new ListAdapter(true);
        testColl.add(1);
        testColl.add(2);
        testColl.add(3);

        int collDim = coll.size();
        coll.addAll(testColl);
        assertTrue(coll.containsAll(testColl));
        assertEquals(collDim + testColl.size(), coll.size());

        // for the HLists
        HCollection coll;
        try {
            uList.addAll(0, null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            list.addAll(0, null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
        coll = new ListAdapter(true);
        try {
            list.addAll(list.size() + 1, coll);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        coll.add(8);
        coll.add(9);

        list.add(1);
        list.add(2);
        list.add(3);

        list.addAll(0, coll);
        assertArrayEquals(new Object[] { 8, 9, 1, 2, 3 }, list.toArray());

        list.addAll(3, coll);
        assertArrayEquals(new Object[] { 8, 9, 1, 8, 9, 2, 3 }, list.toArray());

        list.addAll(list.size(), coll);
        assertArrayEquals(new Object[] { 8, 9, 1, 8, 9, 2, 3, 8, 9 }, list.toArray());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#clear()} method.
     * <br>
     * <br>
     * Design test: the design provides information about the clear method which has
     * to clear the list from all the elements. Exception are thrown first.
     * <br>
     * <br>
     * Description: The clear() method is called for the listWithData.
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: The list doesn't have any data stored anymore.
     * <br>
     * <br>
     * Expected results: listWithData.size() == 0;
     */
    @Test
    public void testClear() {
        try {
            uList.clear();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }

        listWithData.clear();
        assertEquals(0, listWithData.size());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#contains(Object)} method.
     * <br>
     * <br>
     * Design test: addition of two elements, verification of the existence of an
     * element present, verification of the existence of an element not present.
     * Check with different types belonging to Object
     * <br>
     * <br>
     * Description: after adding two elements, I verify that the method returns true
     * using one of the two elements as a parameter, false using an element that
     * does not exist in the collection as a parameter
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: elements have been added correctly in the HCollection
     * <br>
     * <br>
     * Expected results: coll.contains(1) == true && coll.contains(4.50) == true &&
     * coll.contains(2) == false;
     */
    @Test
    public void testContains() {
        coll.add(1);
        coll.add(3);
        coll.add(4.5);

        try {
            coll.contains(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertTrue(coll.contains(1));
        assertTrue(coll.contains(4.50));
        assertFalse(coll.contains(2));
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#containsAll(HCollection)}
     * method.
     * <br>
     * <br>
     * Design test: elements are added to the collection on which the method will be
     * invoked. Subsequently a collection is created that will be passed as a
     * parameter to the tested method containing only some of the elements present
     * in the main collection and the tested method is invoked. A value not present
     * in the main collection is then inserted into the collection passed as a
     * parameter and the tested method is invoked again, verifying the correctness
     * of the returned value in both cases. The throwing of the exception in the
     * event of a null parameter is also tested
     * <br>
     * <br>
     * Description: after the creation and addition of some values in the collection
     * that will be passed as a parameter, I add the same values in the main
     * collection and verify that a true is returned (returned even in the case of
     * an empty parameter collection). After adding a new element in the collection
     * passed as a parameter, I check that the returned value is false
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: Elements have been correctly added to the HCollection and it
     * has to contain the given Collections.
     * <br>
     * <br>
     * Expected results: true if coll contains the given HCollection.
     */
    @Test
    public void testContainsAll() {
        try {
            coll.containsAll(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);

        HCollection testColl = new ListAdapter(true, coll);

        assertTrue(coll.containsAll(testColl));

        testColl.add(1);
        testColl.add(2);
        testColl.add(3);
        assertTrue(coll.containsAll(testColl));

        testColl.add(5);
        assertFalse(coll.containsAll(testColl));
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#isEmpty()} method.
     * <br>
     * <br>
     * Design test: An element is added and the method is tested, the element is
     * removed and the method is invoked again
     * <br>
     * <br>
     * Description: after adding a data item it is verified that the container is
     * not indicated as empty, while after removal it is verified that the container
     * is correctly considered empty
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty.
     * <br>
     * <br>
     * Postconditions: No elements are present in the HCollection.
     * <br>
     * <br>
     * Expected results: coll.isEmpty() == false and then coll.isEmpty() == true;
     */
    @Test
    public void testIsEmpty() {
        coll.add(1);
        assertFalse(coll.isEmpty());
        coll.remove(1);
        assertTrue(coll.isEmpty());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#hIterator()},
     * {@link myAdapter.ListAdapter#hListIterator()} and
     * {@link myAdapter.ListAdapter#hListIterator(int)} methods.
     * <br>
     * <br>
     * Design test: Provides information about the definition of iterators for
     * HCollections and HLists. An exception is thrown for the iterator with index.
     * <br>
     * <br>
     * Description: Three iterators are created from the collections and some of
     * their methods are tested to prove that they are working.
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: Three iterators are created correctly.
     * <br>
     * <br>
     * Expected results: iterators return values in the HCollections.
     */
    @Test
    public void testIterator() {
        HIterator collIter = coll.hIterator();
        HListIterator listIter = list.hListIterator();
        HListIterator listIterIndex = listWithData.hListIterator(2);

        assertFalse(collIter.hasNext());

        listIter.add(1);
        listIter.add(3);
        listIter.add(5);

        listIter = list.hListIterator();
        Object[] arr = list.toArray();
        int i = 0;
        while (listIter.hasNext()) {
            assertEquals(arr[i], listIter.next());
            i++;
        }

        assertEquals(3, listIterIndex.next());
        assertEquals(4, listIterIndex.next());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#remove(Object)} and
     * {@link myAdapter.ListAdapter#remove(int)} method
     * <br>
     * <br>
     * Design test: The tests provides information about the remove() method. In the
     * first place Exception are thrown then the function is called.
     * <br>
     * <br>
     * Description: both with empty collection and with non-existent element, the
     * tested method is invoked verifying that it returns the expected result. After
     * adding an element, if passed as a parameter of the tested method, the first
     * matching element will no longer be present
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: Elements passed as parameters have to be
     * removed from the main collection.
     * <br>
     * <br>
     * Expected results: coll contains {3,2} && list contains {1,3,5} &&
     * list == list2.
     */
    @Test
    public void testRemove() {
        // remove(Object) from HCollection
        try {
            uColl.remove(10);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            coll.remove(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertFalse(coll.remove(new Object()));
        coll.add(2);
        coll.add(3);
        coll.add(2);

        assertFalse(coll.remove(1));
        assertTrue(coll.remove(2));
        assertEquals(2, coll.size());
        assertArrayEquals(new Object[] { 3, 2 }, coll.toArray());

        // remove(int) from HList
        try {
            uList.remove(5);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            list.remove(0);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        try {
            list.remove(list.size());
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        HList list2 = new ListAdapter(true);
        list2.add(1);
        list2.add(3);
        list2.add(5);

        for (int i = 0; i < list.size(); i++) {
            if ((Integer) list.get(i) % 2 == 0)
                list.remove(i);
        }

        assertEquals(list, list2);
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#removeAll(HCollection)}
     * method
     * <br>
     * <br>
     * Design test:The tests provides information about the removeAll() method. In
     * the
     * first place Exception are thrown then the function is called.
     * <br>
     * <br>
     * Description: after verification of correct operation using empty collections,
     * elements are added to the main collection and an element not present in this
     * one, in the parameter collection. After checking that the returned value is
     * false, another element is added, this time present in the main collection,
     * and it is verified that the invocation of the tested method returns true and
     * that in the main collection there are no elements in common with the one
     * passed as a parameter.
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: Some elements from the listWithData HList have been correctly
     * removed.
     * <br>
     * <br>
     * Expected results: listWithData contains {1,3,4,5}.
     */
    @Test
    public void testRemoveAll() {
        HCollection testColl = new ListAdapter(true);
        try {
            uList.removeAll(testColl);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            listWithData.removeAll(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertFalse(listWithData.removeAll(testColl));

        testColl.add(6);
        assertFalse(coll.removeAll(testColl));
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, listWithData.toArray());

        listWithData.add(2);
        testColl.add(2);
        listWithData.removeAll(testColl);
        assertArrayEquals(new Object[] { 1, 3, 4, 5 }, listWithData.toArray());

    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#retainAll(HCollection)}
     * method.
     * <br>
     * <br>
     * Design test: The test provides information about the retainAll() method.
     * First, all the exception are thrown, then the function is called. The design
     * is about operating with both empty and non-empty HCollections in order to
     * cover all the possible exceptions.
     * <br>
     * <br>
     * Description: the main collection is always filled with the same values, while
     * a second collection, the one passed as a parameter, contains an always
     * different combination of values to study if the method works correctly in
     * different cases
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty and HList with
     * data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: the main collection must not contain data that is not also
     * contained in the collection passed as a parameter and must return true if the
     * first has been modified
     * <br>
     * <br>
     * Expected results: the collection must have zero size if there is no common
     * data, otherwise these must be present
     */
    @Test
    public void testRetainAll() {
        HCollection testColl = new ListAdapter(true);

        try {
            uColl.retainAll(testColl);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        try {
            coll.retainAll(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertFalse(coll.retainAll(testColl));

        coll.add(1);
        coll.add(2);
        coll.add(3);
        assertTrue(coll.retainAll(testColl));
        assertEquals(0, coll.size());

        coll.add(1);
        coll.add(2);
        coll.add(3);
        testColl.add(5);
        assertTrue(coll.retainAll(testColl));
        assertEquals(0, coll.size());

        coll.add(1);
        coll.add(2);
        coll.add(3);
        testColl.add(2);
        assertTrue(coll.retainAll(testColl));
        assertArrayEquals(new Object[] { 2 }, coll.toArray());
        coll.clear();

        coll.add(1);
        coll.add(1);
        coll.add(1);
        assertTrue(coll.retainAll(testColl));
        assertEquals(0, coll.size());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#size()} method.
     * <br>
     * <br>
     * Design test: test of the size of the collection before and after adding an
     * element and its removal,
     * increasing and decreasing the value of the size of the collection
     * <br>
     * <br>
     * Description: The size method is invoked both before adding a new element in
     * the collection and after verifying
     * the increment of one unit of the size of the collection.
     * Similarly with the removal of that element.
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty
     * <br>
     * <br>
     * Postconditions: the returned value must correspond to the number of elements
     * contained in the collection
     * <br>
     * <br>
     * Expected results: 0 if collection is empty, otherwise the number of elements
     * present in the collection.
     */
    @Test
    public void testSize() {
        assertEquals(0, coll.size());
        coll.add(1);
        assertEquals(1, coll.size());
        coll.remove(1);
        assertEquals(0, coll.size());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#toArray()} method.
     * <br>
     * <br>
     * Design test: after some data has been entered, a manually created (test)
     * array is compared with the one returned by the method
     * <br>
     * <br>
     * Description: after inserting some data in the colleciton, it is verified that
     * the object returned by the toArray () method corresponds with an array of
     * Object containing the attested elements having the same order in which they
     * were inserted in the collection
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty
     * <br>
     * <br>
     * Postconditions: Elements are added in the collection and must be equals to
     * the array manually created.
     * <br>
     * <br>
     * Expected results: coll.toArray() == {1,2,3,4}.
     */
    @Test
    public void testToArray() {
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);

        assertArrayEquals(new Object[] { 1, 2, 3, 4 }, coll.toArray());

        coll = new ListAdapter(true);
        assertArrayEquals(new Object[0], coll.toArray());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#toArray(Object[])} method.
     * <br>
     * <br>
     * Design Test: The test design is based on trying to call the method three
     * times passing
     * filled array as the parameter. Exception are thrown.
     * <br>
     * <br>
     * Description: for all the situations indicated by the design test, it is
     * verified with the use of a manually created array that the tested method
     * returns an array of Object, filled with the rest of elements present in the
     * specified array for the greater the difference between the size of the array
     * passed as parameter and the size of the
     * collection, exactly the elements of the collection, or a new array always
     * with the elements of the collection
     * <br>
     * <br>
     * Preconditions: HCollection has to be initialize as Empty
     * <br>
     * <br>
     * Postconditions: the returned array must contain all the elements present in
     * the collection on which the method is invoked and in the order with which
     * they appear in the collection
     * <br>
     * <br>
     * Expected results: (1) coll.toArray() == {1,2,3}, (2)
     * coll.toArray() == {5,6,3}, (3) coll.toArray() == {5,6,7,8}.
     */
    @Test
    public void testToArrayWithParameter() {
        Object[] array1 = null;

        try {
            coll.toArray(array1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        array1 = new Object[] { 1, 2, 3 };
        assertArrayEquals(new Object[] { 1, 2, 3 }, coll.toArray(array1));

        coll.add(5);
        coll.add(6);
        assertArrayEquals(new Object[] { 5, 6, 3 }, coll.toArray(array1));

        coll.add(7);
        coll.add(8);
        assertArrayEquals(new Object[] { 5, 6, 7, 8 }, coll.toArray(array1));
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#get(int)} method.
     * <br>
     * <br>
     * Design test: check that each inserted element is reachable through the tested
     * method. Exception are thrown.
     * <br>
     * <br>
     * Description: considering the insertion of values in the list, a for loop is
     * called to verify that indeed each inserted element is correctly returned by
     * the get method
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: the element returned must be the one contained in the i-th -1
     * position of the list
     * <br>
     * <br>
     * Expected results: the for loop ends correctly (i.e. it reaches the end of the
     * conditions for which it loops)
     */
    @Test
    public void testGet() {

        try {
            listWithData.get(listWithData.size());
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        for (int i = 0; i < 5; i++)
            assertEquals(i + 1, listWithData.get(i));
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#indexOf(Object)} method.
     * <br>
     * <br>
     * Design test: considering the element insert in the list previously I perform
     * three searches for single element, duplicate element, non-existent element.
     * Search also with empty list. Exception are thrown.
     * <br>
     * <br>
     * Description: the first test is performed on an empty list, thus not returning
     * the index containing the desired element. The following invocations are made
     * after the insertion of values, some even repeated, specifically: invocation
     * to find a non-repeated element, invocation to find a repeated element and
     * invocation to find an element not contained in the list. For simplicity, the
     * values entered are Integer
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside and list with
     * no data initialized as Empty.
     * <br>
     * <br>
     * Postconditions: the index of the first matching element found is returned,
     * otherwise -1
     * <br>
     * <br>
     * Expected results: -1 for empty list and element not found; index of the
     * position of the single element, searched; index of the position of the first
     * element of the list found
     */
    @Test
    public void testIndexOf() {
        try {
            listWithData.indexOf(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertEquals(-1, list.indexOf(5));

        listWithData.add(2);

        assertEquals(-1, listWithData.indexOf(9));
        assertEquals(1, listWithData.indexOf(2));
        assertEquals(0, listWithData.indexOf(1));
        assertEquals(-1, listWithData.indexOf(6));
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#lastIndexOf(Object)} method.
     * <br>
     * <br>
     * Design test: after the insertion of some elements, three searches are carried
     * out for single element, duplicate element, non-existent element. Search also
     * with empty list. Exception are thrown.
     * <br>
     * <br>
     * Description: the first test is performed on an empty list, thus not returning
     * the index containing the desired element. The following invocations are made
     * after the insertion of values, some even repeated, specifically: invocation
     * to find a non-repeated element, invocation to find a repeated element and
     * invocation to find an element not contained in the list. For simplicity, the
     * values ​​entered are Integer
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside and list with
     * no data initialized as Empty.
     * <br>
     * <br>
     * Postconditions: the index of the last matching element found is returned,
     * otherwise -1
     * <br>
     * <br>
     * Expected results: -1 for empty list and element not found; index of the
     * position of the single element, searched; index of the position of the first
     * element of the list found
     */
    @Test
    public void testLastIndexOf() {
        try {
            listWithData.indexOf(null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        assertEquals(-1, list.lastIndexOf(9));

        listWithData.add(2);
        listWithData.add(3);

        assertEquals(5, listWithData.lastIndexOf(2));
        assertEquals(0, listWithData.lastIndexOf(1));
        assertEquals(-1, listWithData.lastIndexOf(6));
    }

    /**
     * Summary:Tests the {@link myAdapter.ListAdapter#set(int, Object)} method.
     * <br>
     * <br>
     * Design test: the list is filled with n values (for simplicity 0), after the
     * invocation for n times of set the list must contain increasing numbers from 1
     * to n + 1. The check is performed with the equals method. The correct throw of
     * the exception with an index not consistent with the size of the list is also
     * checked
     * <br>
     * <br>
     * Description: after inserting an arbitrary number of values (0), a for loop is
     * invoked which must modify the contents of the list so that it corresponds to
     * the contents of a second list containing the expected data entered manually
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: the main list is different than it was before the invocation
     * of the set method
     * <br>
     * <br>
     * Expected results: the master list on which the set is performed and the
     * verification sublist must be equal or the equals method must return true
     */
    @Test
    public void testSet() {
        try {
            uList.set(2, 10);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(UnsupportedOperationException.class, e.getClass());
        }

        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);

        try {
            list.set(list.size(), "error");
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        try {
            list.set(4, null);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, i + 1);
        }

        assertArrayEquals(list.toArray(), listWithData.toArray());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#subHList(int, int)} method.
     * <br>
     * <br>
     * Design test: the method with two valid indices is invoked and is checked by
     * comparing the array returned by the toArray () method and an array containing
     * the expected values, that the sublist actually contains the range of values
     * indicated by the two indices. The empty sublist is also checked, in case of
     * co-incidence of the indexes in the invocation of the tested method, and an
     * exception throw in case of invalid indexes
     * <br>
     * <br>
     * Description: to verify that the sublist contained in the indexes passed as
     * parameters is returned correctly, first of all it is specified that if the
     * indexes are equal then the sublist will be empty, then it is verified that
     * with a non-empty sublist the elements contained in it are exactly those
     * expected (verification carried out by comparing arrays with expected values
     * and the one returned by the toArray () method invoked on the sublist). It is
     * also verified that if the main list is empty the only valid indexes are 0, if
     * indexes are put outside the maximum size of the list the exception is raised.
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside.
     * <br>
     * <br>
     * Postconditions: the main list is not changed immediately after the method
     * invocation. With indexes from zero to the value returned by size () the
     * sublist has a size equal to the list
     * <br>
     * <br>
     * Expected results: the sublist contains all the elements contained in the
     * range [from, to)
     */
    @Test
    public void testSubList() {
        HList subList = listWithData.subHList(2, 2);
        assertEquals(0, subList.size());

        subList = listWithData.subHList(2, 4);
        assertEquals(2, subList.size());
        assertArrayEquals(new Object[] { 3, 4 }, subList.toArray());

        subList = listWithData.subHList(0, listWithData.size());
        assertEquals(listWithData.size(), subList.size());

        listWithData.clear();
        subList = listWithData.subHList(0, 0);
        try {
            subList = listWithData.subHList(2, 3);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#equals(Object)} method.
     * <br>
     * <br>
     * Design test: a new list is created and both in this and in the main list the
     * same elements are inserted and compared. The insertion of incompatible
     * objects is also tested
     * <br>
     * <br>
     * Description: after the creation of a second list, the same elements are
     * inserted in the two lists and are compared. Then an element is added in one
     * of the two and they are compared again. After being made equal again, one
     * value is changed to one of the two and a further comparison is made. A
     * collection is inserted both with the same elements in the same order as they
     * appear in the main list, and in a different order. It also tests the
     * insertion of a non-empty Object array to test the compatibility of the data
     * entered
     * <br>
     * <br>
     * Preconditions: List with no data initialized as Empty.
     * <br>
     * <br>
     * Postconditions: the method must return true if the two containers have the
     * same elements arranged in the same order and must return false if the two
     * objects are incompatible for a comparison (according to logic, incompatible
     * corresponds to not equal)
     * <br>
     * <br>
     * Expected results: true only in the first case described and in the case of
     * data compatible and respecting the <br>
     * <br>
     * Description in HList, exception with incompatible data, false with the other
     * cases described
     */
    @Test
    public void testEquals() {
        HList list2 = new ListAdapter(true);
        list.add(1);
        list.add(2);
        list.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        assertEquals(list, list2);

        list2.add(4);
        assertNotEquals(list, list2);

        list2.clear();
        list2.add(1);
        list2.add(4);
        list2.add(3);
        assertNotEquals(list, list2);

        coll.clear();
        coll.add(1);
        coll.add(3);
        coll.add(2);
        assertNotEquals(list, coll);

        assertNotEquals(list, new Object[] { 1, 2, 3 });
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#hashCode()} method.
     * <br>
     * <br>
     * Design test: the same data is entered in the main list and in one created ad
     * hoc. The hash must be the same. The order of two elements in one of the two
     * lists is reversed and the tested method is rerun
     * <br>
     * <br>
     * Description: after having entered the data in the main list, a second one is
     * created which contains the same data as the first and in the same order. The
     * calculated hash must be the same. The reversal of the order of two elements
     * and and subsequent hash calculation must be different
     * <br>
     * <br>
     * Preconditions: the hash calculation must be the one described in ListAdapter
     * and List with no data initialized as Empty.
     * <br>
     * <br>
     * Postconditions: only if the compared objects have the same elements arranged
     * in the same order, the hash must be identical
     * <br>
     * <br>
     * Expected results: the cases in which the hash of the two objects match is
     * exactly when the content and order of the elements of the two objects are the
     * same
     */
    @Test
    public void testHashCode() {
        list.add(1);
        list.add(2);
        list.add(3);

        HList list2 = new ListAdapter(true);
        list2.add(1);
        list2.add(2);
        list2.add(3);

        assertEquals(list2.hashCode(), list.hashCode());

        list2.clear();
        list2.add(1);
        list2.add(3);
        list2.add(2);
        assertNotEquals(list2.hashCode(), list.hashCode());

        list2.clear();
        assertNotEquals(list2.hashCode(), list.hashCode());

        HCollection coll = new ListAdapter(true);
        coll.add(1);
        coll.add(2);
        coll.add(3);
        assertEquals(coll.hashCode(), list.hashCode());
    }

    /**
     * Summary: Tests the {@link myAdapter.ListAdapter#hListIterator(int)} method
     * which is the only particular case among iterator methods.
     * <br>
     * <br>
     * Design test: the iterator is invoked on a non-empty list and it is verified
     * that the object returned by the first invocation of next corresponds to the
     * one corresponding to the index provided The correct throw of the exception
     * after the invocation of next () is also tested because it is equivalent that
     * the method has correctly returned an iterator at the end of the list.
     * Furthermore, the throw of exception is also checked in the case of an invalid
     * index with respect to the positions that the iterator can take
     * <br>
     * <br>
     * Description: to verify that the method works correctly, an iterator is
     * created on a list containing values, and the next () method is invoked to
     * verify that the returned value is the one expected with respect to the
     * position passed as a parameter to the tested method. Next () is also
     * performed on an iterator returned by the method to which the exact size of
     * the list has been passed as a parameter to verify that the method is able to
     * return an iterator on all n + 1 positions. Finally it is verified that if the
     * method is executed passing an invalid index (greater than the size of the
     * list) an exception is thrown
     * <br>
     * <br>
     * Preconditions: HList with data has to have data stored inside
     * <br>
     * <br>
     * Postconditions: the index must indicate the first element returned by the
     * next () call
     * <br>
     * <br>
     * Expected results: the element returned is the one corresponding to the first
     * element returned by the next () call
     */
    @Test
    public void testListIteratorIndex() {
        HListIterator listIterator = listWithData.hListIterator(3);
        assertEquals(4, listIterator.next());

        listIterator = listWithData.hListIterator(listWithData.size());
        try {
            listIterator.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

        try {
            listIterator = listWithData.hListIterator(listWithData.size() + 1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

}
