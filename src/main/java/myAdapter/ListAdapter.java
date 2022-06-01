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

		int n = this.size();
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

		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		Object[] elements = this.toArray();
		for (Object o : elements)
			this.remove(o);
	}

	@Override
	public boolean contains(Object o) throws ClassCastException, NullPointerException {
		if (o == null)
			throw new NullPointerException();

		// TODO implementare ClassCastException

		return this.list.contains(o);
	}

	@Override
	public boolean containsAll(HCollection h) throws ClassCastException, NullPointerException {
		if (h == null)
			throw new NullPointerException();

		// TODO implementare ClassCastException

		Object[] elements = h.toArray();
		for (Object o : elements) {
			if (!this.contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.size() <= 0;
	}

	@Override
	public HIterator hIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (o == null)
			throw new NullPointerException();

		int index = this.list.indexOf(o);
		if (index < 0)
			return false;
		this.list.removeElementAt(index);
		return true;
	}

	@Override
	public boolean removeAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (h == null)
			throw new NullPointerException();

		Object[] elements = h.toArray();

		int n = this.size();
		for (Object o : elements) {
			if (this.list.indexOf(o) >= 0)
				this.remove(o);
		}
		if (n != this.size())
			return true;
		return false;
	}

	@Override
	public boolean retainAll(HCollection h)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (h == null)
			throw new NullPointerException();

		Object[] elements = this.toArray();

		int n = this.size();
		for (Object o : elements) {
			if (!h.contains(o))
				this.remove(o);
		}
		if (n != this.size())
			return true;
		return false;
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public Object[] toArray() {
		Object[] elements = new Object[this.size()];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = this.list.elementAt(i);
		}
		return elements;
	}

	@Override
	public Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException {
		if (a == null)
			throw new NullPointerException();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				index = i;
				break;
			}
		}

		Object[] elements = this.toArray();
		if (index + elements.length >= a.length)
			return elements;
		for (int i = 0; i < elements.length; i++) {
			a[i + index] = elements[i];
		}
		return a;
	}

	@Override
	public void add(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (!supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (element == null)
			throw new NullPointerException();
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();

		this.list.insertElementAt(element, index);
	}

	@Override
	public boolean addAll(int index, HCollection o) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (!supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (o == null)
			throw new NullPointerException();
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();

		int n = this.size();
		Object[] elements = o.toArray();
		for (int i = 0; i < elements.length; i++) {
			this.add(index + i, elements[i]);
		}
		if (n != this.size())
			return true;
		return false;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		return this.list.elementAt(index);
	}

	@Override
	public int indexOf(Object o) throws ClassCastException, NullPointerException {

		// TODO implementare ClassCastException

		if (o == null)
			throw new NullPointerException();
		return this.list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {

		// TODO implementare ClassCastException

		if (o == null)
			throw new NullPointerException();
		return this.list.lastIndexOf(o);
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
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (element == null)
			throw new NullPointerException();
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();

		Object o = this.get(index);
		this.list.setElementAt(element, index);
		return o;
	}

	@Override
	public HList subHList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		if (fromIndex >= toIndex || fromIndex < 0 || toIndex > this.size())
			throw new IndexOutOfBoundsException();

		HList sub = new ListAdapter(true);

		for (int i = fromIndex; i < toIndex; i++) {
			sub.add(this.get(i));
		}

		return sub;
	}

}
