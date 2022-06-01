package myAdapter;

public class ListAdapter implements HList {

	private Vector list;
	private boolean supportOptional;

	public ListAdapter(boolean supportOptional) {
		list = new Vector();
		this.supportOptional = supportOptional;
	}

	public ListAdapter(boolean supportOptional, int initialSize) {
		list = new Vector(initialSize);
		this.supportOptional = supportOptional;
	}

	public ListAdapter(boolean supportOptional, int initialSize, int capacityIncrease) {
		list = new Vector(initialSize, capacityIncrease);
		this.supportOptional = supportOptional;
	}

	@Override
	public boolean add(Object o)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (o == null)
			throw new NullPointerException();

		if (this.contains(o))
			return false;
		this.list.addElement(o);
		return true;
	}

	@Override
	public boolean addAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (h == null)
			throw new NullPointerException();

		int n = this.list.size();
		Object[] elements = h.toArray();
		for (Object elem : elements) {
			this.add(elem);
		}
		if (n == list.size()) // se la lista non cambia dimensione non ha aggiunto elementi
			return false;
		return false;
	}

	@Override
	public void clear() throws UnsupportedOperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(HCollection h) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HIterator hIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(int index, HCollection o) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HListIterator hListIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HListIterator hListIterator(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HList subHList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
