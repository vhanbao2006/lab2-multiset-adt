public class BSTMultiSet extends MultiSet {

    // a multiset always starts empty, so we can directly instantiate our private variable
    // here; no need to explicitly write a new constructor.
    private final BST bst = new BST();

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    void add(int item) {
        this.bst.insert(item);
    }

    /**
     * Remove the given item from this multiset.
     * If the item isn't in the multiset, do nothing.
     *
     * @param item the item to remove
     */
    @Override
    void remove(int item) {
        this.bst.delete(item);
    }

    /**
     * Check whether item is in this multiset.
     *
     * @param item the item to check if in this multiset
     * @return True if item is in this multiset and False otherwise.
     */
    @Override
    boolean contains(int item) {
        return this.bst.contains(item);
    }

    /**
     * @return True if this multiset is empty.
     */
    @Override
    boolean isEmpty() {
        return this.bst.isEmpty();
    }

    /**
     * Count how many times the given item appears in this multiset.
     *
     * @param item the item to count
     * @return How many times item appears in this multiset.
     */
    @Override
    int count(int item) {
        return this.bst.count(item);
    }

    /**
     * @return How many items are in this multiset.
     */
    @Override
    int size() {return this.bst.getSize();}
}