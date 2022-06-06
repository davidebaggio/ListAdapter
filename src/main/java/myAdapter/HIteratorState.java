package myAdapter;

/**
 * This ENUM contains the different states of an HListIterator
 * 
 * @author Davide Baggio
 */
public enum HIteratorState {
	/**
	 * HListIterator has just added a new element in the HList
	 */
	HAS_ADDED,
	/**
	 * HListIterator has just removed an element in the HList
	 */
	HAS_REMOVED,
	/**
	 * HListIterator has just gone next in the HList
	 */
	HAS_GONE_NEXT,
	/**
	 * HListIterator has just gone previous in the HList
	 */
	HAS_GONE_PREV,
	/**
	 * HListIterator is waiting for a new call
	 */
	IDLE
}
