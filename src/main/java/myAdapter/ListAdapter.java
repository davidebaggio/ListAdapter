package myAdapter;

/**
 * ListAdapter is a class that contains all the methods of the J2RE 1.4.2
 * Collections and List interfaces (Optional included).
 * Basically it is an adapter to these interfaces and uses java.util.Vector
 * {https://docs.oracle.com/javame/config/cldc/ref-impl/cldc1.1/jsr139/index.html}
 * of CLDC 1.1.
 * This class implements {@link myAdapter.HCollection} and
 * {@link myAdapter.HList} interfaces
 * 
 * This list does not support insertion of null elements
 */
public class ListAdapter implements HList {

	private Vector list;
	private boolean supportOptional;

	/**
	 * Constructor for ListAdapter
	 * 
	 * @param supportOptional - true if this List support optional operations
	 */
	public ListAdapter(boolean supportOptional) {
		list = new Vector();
		this.supportOptional = supportOptional;
	}

	/**
	 * Constructor for ListAdapter
	 * 
	 * @param supportOptional - true if this List support optional operations
	 * @param initialSize     - initial size of the list
	 */
	public ListAdapter(boolean supportOptional, int initialSize) {
		list = new Vector(initialSize);
		this.supportOptional = supportOptional;
	}

	/**
	 * Constructor for ListAdapter
	 * 
	 * @param supportOptional  - true if this List support optional operations
	 * @param initialSize      - initial size of the list
	 * @param capacityIncrease - increase value
	 */
	public ListAdapter(boolean supportOptional, int initialSize, int capacityIncrease) {
		list = new Vector(initialSize, capacityIncrease);
		this.supportOptional = supportOptional;
	}

	/**
	 * Copy constructor
	 * 
	 * @param supportOptional - true if this List support optional operations
	 * @param coll            - Collection to copy
	 */
	public ListAdapter(boolean supportOptional, HCollection coll) {
		this.supportOptional = supportOptional;
		this.list = new Vector(coll.size());
		Object[] elements = coll.toArray();
		for (Object object : elements) {
			this.list.addElement(object);
		}
	}

	@Override
	public boolean add(Object o)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		// null implementagtion
		if (o == null)
			throw new NullPointerException();

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
		return true;
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
		// null implementation

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
		return new IteratorAdapter(HIteratorState.IDLE, this.supportOptional, this);
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
		if (a.length < this.size())
			return this.toArray();

		for (int i = 0; i < this.size(); i++) {
			a[i] = this.get(i);
		}
		return a;
	}

	@Override
	public void add(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		// null implementation

		if (element == null)
			throw new NullPointerException();

		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();

		this.list.insertElementAt(element, index);
	}

	@Override
	public boolean addAll(int index, HCollection o) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (!this.supportOptional)
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
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
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
		return new IteratorAdapter(HIteratorState.IDLE, this.supportOptional, this);
	}

	@Override
	public HListIterator hListIterator(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();
		return new IteratorAdapter(HIteratorState.IDLE, this.supportOptional, this, index);
	}

	@Override
	public Object remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();

		Object obj = this.get(index);
		this.list.removeElementAt(index);
		return obj;
	}

	@Override
	public Object set(int index, Object element) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (!this.supportOptional)
			throw new UnsupportedOperationException();

		// TODO implementare ClassCastException

		if (element == null)
			throw new NullPointerException();
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();

		Object o = this.get(index);
		this.list.setElementAt(element, index);
		return o;
	}

	@Override
	public HList subHList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		if (fromIndex > toIndex || fromIndex < 0 || toIndex > this.size())
			throw new IndexOutOfBoundsException();

		HList sub = new ListAdapter(this.supportOptional);

		for (int i = fromIndex; i < toIndex; i++) {
			sub.add(this.get(i));
		}

		return sub;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass())
			return false;
		if (this.size() != ((ListAdapter) obj).size())
			return false;
		Object[] arr1 = this.toArray();
		Object[] arr2 = ((ListAdapter) obj).toArray();
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	// s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	@Override
	public int hashCode() {
		Object[] arr = this.toArray();
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			n += (Integer) arr[i] * Math.pow(31, arr.length - (i + 1));
		}

		return n;
	}

	@Override
	public String toString() {
		String str = "List length: " + this.size() + "\nElements: ";
		for (int i = 0; i < this.size(); i++) {
			str += "\n\t" + this.get(i);
		}

		return str;
	}

}
