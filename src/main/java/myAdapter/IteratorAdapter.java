package myAdapter;

import java.util.NoSuchElementException;

public class IteratorAdapter implements HListIterator {

	private HList hList;
	private int index;
	private boolean supportOptional;
	private HIteratorState state;

	public IteratorAdapter(HIteratorState state, boolean supportOptional, HList hList) {
		this.hList = hList;
		this.index = 0;
		this.supportOptional = supportOptional;
		this.state = state;
	}

	public IteratorAdapter(HIteratorState state, boolean supportOptional, HList hList, int index) {
		this.hList = hList;
		this.index = index;
		this.supportOptional = supportOptional;
		this.state = state;
	}

	@Override
	public boolean hasNext() {
		return this.index < this.hList.size() - 1;
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

		this.hList.remove(this.index);
		this.state = HIteratorState.HAS_REMOVED;
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
