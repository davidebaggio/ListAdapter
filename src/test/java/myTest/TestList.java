package myTest;

import org.junit.Before;
import org.junit.Test;

import myAdapter.HIterator;
import myAdapter.HList;
import myAdapter.HListIterator;
import myAdapter.ListAdapter;

import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestList {
	HList l1 = null, l2 = null;
	HListIterator li = null;
	static String[] argv = { "pippo", "qui", "pluto", "paperino", "ciccio" };

	@Before
	public void setup() {
		System.out.println("Instantiate an empty List");
		l1 = new ListAdapter(true);
	}

	@After
	public void cleanup() {
		System.out.println("Purge all remaining elements");
		l1.clear();
	}

	@Test
	public void testBacking() {
		System.out.println("TestBacking");
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		// l1 = 0,1,2,3,4
		System.out.println("List.toString() ? " + l1);

		int dl0, dl1, dli, dsl0, dsl1, dsli;

		iterate(l1.hIterator()); // iterate through the list
		System.out.println(l1 + " " + l1.size());
		dl0 = l1.size(); // 5

		l2 = l1.subHList(0, argv.length / 2); // from 0 to 2
		dsl0 = l2.size(); // 2

		l2.add("pipperissimo");
		dli = l1.size(); // 5
		dsli = l2.size(); // 3

		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dli, dl0);
		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dsli, dsl0 + 1);

		l2.remove("pipperissimo"); // 2
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l1.size(), dl0);
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l2.size(), dsl0);

		iterate(l2.hIterator());
		System.out.println(l2 + " " + l2.size());

		l2.clear();
		dl1 = l1.size(); // 5
		dsl1 = l2.size(); // 0
		System.out.println(l1 + " " + l1.size());
		iterate(l1.hIterator());
		System.out.println(l2 + " " + l2.size());
		iterate(l2.hIterator());

		System.out.println(dl0 + " " + dl1 + " " + dsl0 + " " + dsl1);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl0, (dl0 / 2));
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl1, 0);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dl1, (dl0 - dsl1));

	}

	@Test
	public void testRecursiveSublist() {
		System.out.println("TestRecursive SubListing");
		System.out.println(l1.size());

		assertEquals("List Starts not empty", l1.size(), 0);
		int prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		iterate(l1.hIterator());
		assertEquals("List add not working correctly", l1.size(), (prev));
		System.out.println(l1.size());
		prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), prev);
		System.out.println(l1.size());
		iterate(l1.hIterator());

		int after = 0;
		int count = 0;
		while (l1.size() >= 2) {
			count++;
			prev = l1.size();
			l1 = l1.subHList(1, prev - 1);
			after = l1.size();
			System.out.println(after);
			assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev - 2));
			iterate(l1.hIterator());
		}
	}

	@Test
	public void testIterator3() {
		System.out.println("TestListIterator #3");
		int dl0, dl1, dl2;

		dl0 = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.hIterator());
		li = l1.hListIterator();
		while (li.hasNext())
			li.next();
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(l1.hIterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.hIterator());

		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl1,
				(dl0 + argv.length));
		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl2, 0);
	}

	@Test
	public void testIterator2() {
		System.out.println("TestListIterator #2");
		int dl0, dl1, dl2;
		dl0 = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.hIterator());
		li = l1.hListIterator();
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
			iterate(l1.hIterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.hIterator());

		assertEquals("\n*** insertion and forward removal not working ***\n", dl1, (dl0 + argv.length));
		assertEquals("\n*** insertion and forward removal not working ***\n", dl2, 0);
	}

	@Test
	public void testIterator1() {
		System.out.println("TestListIterator #1");
		iterate(l1.hIterator());
		li = l1.hListIterator(l1.size());
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(l1.hIterator());
			li.remove();
		}
		iterate(l1.hIterator());

		assertEquals("\n*** listiterator from end not working ***\n", l1.size(), 0);
	}

	public static void iterate(HIterator iter) {
		System.out.print("{");
		while (iter.hasNext()) {
			System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}
}
