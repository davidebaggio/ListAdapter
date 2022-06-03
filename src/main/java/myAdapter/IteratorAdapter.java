package myAdapter;

import java.util.NoSuchElementException;

/**
 * IteratorAdapter class that implements {@link myAdapter.HIterator} and
 * {@link myAdapter.HListIterator} interfaces.
 * 
 */
public class IteratorAdapter implements HListIterator {

	private HList hList;
	private int index;
	private boolean supportOptional;
	private HIteratorState state;

	/**
	 * Iterator constructor
	 * 
	 * @param state           - initial state
	 * @param supportOptional - true if this List support optional operations
	 * @param hList           - list of the iterator
	 */
	public IteratorAdapter(HIteratorState state, boolean supportOptional, HList hList) {
		this.hList = hList;
		this.index = 0;
		this.supportOptional = supportOptional;
		this.state = state;
	}

	/**
	 * Iterator constructor
	 * 
	 * @param state           - initial state
	 * @param supportOptional - true if this List support optional operations
	 * @param hList           - list of the iterator
	 * @param index           - starting point of the iterator
	 */
	public IteratorAdapter(HIteratorState state, boolean supportOptional, HList hList, int index) {
		this.hList = hList;
		this.index = index;
		this.supportOptional = supportOptional;
		this.state = state;
	}

	@Override
	public boolean hasNext() {
		return this.index < this.hList.size();
	}

	@Override
	public Object next() throws NoSuchElementException {
		if (!this.hasNext())
			throw new NoSuchElementException();
		Object next = this.hList.get(this.index);
		this.index++;
		this.state = HIteratorState.HAS_GONE_NEXT;
		return next;
	}

	@Override
	public void remove() throws UnsupportedOperationException, IllegalStateException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();
		if (this.state == HIteratorState.HAS_REMOVED || this.state == HIteratorState.IDLE)
			throw new IllegalStateException();

		if (this.state == HIteratorState.HAS_GONE_NEXT) {
			this.previous();
			this.hList.remove(this.index);
			this.state = HIteratorState.HAS_REMOVED;
			return;
		}
		if (this.state == HIteratorState.HAS_GONE_PREV) {
			this.hList.remove(this.index);
			this.state = HIteratorState.HAS_REMOVED;
			return;
		}
	}

	@Override
	public void add(Object o) throws UnsupportedOperationException, ClassCastException, IllegalArgumentException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (o == null)
			throw new IllegalArgumentException();

		this.hList.add(this.index, o);
		this.index++;
		this.state = HIteratorState.HAS_ADDED;
	}

	@Override
	public boolean hasPrevious() {
		return this.index > 0;
	}

	@Override
	public int nextIndex() {
		return this.index;
	}

	@Override
	public Object previous() throws NoSuchElementException {
		if (!this.hasPrevious())
			throw new NoSuchElementException();
		Object prev = this.hList.get(index - 1);
		this.index--;
		this.state = HIteratorState.HAS_GONE_PREV;
		return prev;
	}

	@Override
	public int previousIndex() {
		if (this.index > 0)
			return this.index - 1;
		return -1;
	}

	@Override
	public void set(Object o)
			throws UnsupportedOperationException, ClassCastException, IllegalArgumentException, IllegalStateException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (o == null)
			throw new IllegalArgumentException();

		if (this.state == HIteratorState.HAS_ADDED || this.state == HIteratorState.HAS_REMOVED
				|| this.state == HIteratorState.IDLE)
			throw new IllegalStateException();

		if (this.state == HIteratorState.HAS_GONE_NEXT)
			this.hList.set(this.index - 1, o);
		if (this.state == HIteratorState.HAS_GONE_PREV)
			this.hList.set(this.index, o);
	}

}
