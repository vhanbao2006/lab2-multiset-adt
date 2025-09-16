/**
 * A minimal implementation of a binary search tree. See the python version for
 * additional documentation.
 * You can also see <a href="https://www.teach.cs.toronto.edu/~csc148h/notes/binary-search-trees/bst_implementation.html">
 *     CSC148 Course Notes Section 8.5 BST Implementation and Search</a>
 * if you want a refresher on BSTs, but it is not required to complete this assignment.
 */
public class BST {
    // we use Integer here so that we can set the root to null. This is the same idea as
    // how the Python code uses None in the BST implementation.
    private Integer root;

    private BST left;
    private BST right;

    public BST(int root) {
        this.root = root;
        this.left = new BST();
        this.right = new BST();
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        root = null;
        // left and right default to being null
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(int item) {
        // provided as an example
        if (this.isEmpty()) {
            return false;
        } else if (item == this.root) {
            return true;
        } else if (item < this.root) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }


    public void insert(int item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST();
            this.right = new BST();
        } else if (item <= this.root) {
            this.left.insert(item);
        } else {
            this.right.insert(item);
        }
    }


    public void delete(int item) {
        if (this.isEmpty()) {
            return;
        } else if (item == this.root) {
            this.deleteRoot();
        }  else if (item < this.root) {
            this.left.delete(item);
        } else  {
            this.right.delete(item);
        }
    }

    private void deleteRoot() {
        if (this.left.isEmpty() && this.right.isEmpty()) {
            this.root = null;
            this.left = new BST();
            this.right = new BST();
        } else if (this.left.isEmpty()) {
            this.root = this.right.root;
            this.left = this.right.left;
            this.right = this.right.right;
        } else if (this.right.isEmpty()) {
            this.root = this.left.root;
            this.left = this.left.left;
            this.right = this.left.right;
        } else {
            this.root = this.left.extractMax();
        }
    }


    private int extractMax() {
        if (this.right.isEmpty()) {
            int max_item = this.root;
            this.root = this.left.root;
            this.left = this.left.left;
            this.right = this.left.right;
            return max_item;
        } else { return this.right.extractMax(); }
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return Math.max(this.left.height(), this.right.height()) + 1;
        }
    }

    public int count(int item) {
        if (this.isEmpty()) {
            return 0;
        } else if (this.root > item) {
            return this.left.count(item);
        } else if (item > this.root) {
            return this.right.count(item);
        } else {
            return 1 +  this.left.count(item) + this.right.count(item);
        }
    }

    public int getSize() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return 1 + this.left.getSize() + this.right.getSize();
        }
    }

    public static void main(String[] args) {
        // You can also add code here to do some basic testing if you want,
        // but make sure it doesn't contain syntax errors
        // or else we won't be able to run your code on MarkUs since the file won't
        // compile. Always make sure to run the self tests on MarkUs after you update your code.
        BST bst = new BST();
        int a = 1;
        bst.insert(a);
        System.out.println(bst.contains(a));
    }

}