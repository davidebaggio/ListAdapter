package myAdapter;

import java.util.NoSuchElementException;

public class IteratorAdapter implements HListIterator {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() throws UnsupportedOperationException, IllegalStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Object o) throws UnsupportedOperationException, ClassCastException, IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object previous() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(Object o)
			throws UnsupportedOperationException, ClassCastException, IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub

	}

}
