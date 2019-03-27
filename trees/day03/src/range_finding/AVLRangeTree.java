package range_finding;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.List;

public class AVLRangeTree extends BinarySearchTree<Integer> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    RangeNode<Integer> delete(RangeNode<Integer> n, Integer key) {
        n = super.delete(n, key);
        if (n != null) {
            n.rank = getDecendences(n);
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    RangeNode<Integer> insert(RangeNode<Integer> n, Integer key) {
        n = super.insert(n, key);
        if (n != null) {
            n.rank = getDecendences(n);
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    RangeNode<Integer> deleteMin(RangeNode<Integer> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(RangeNode x) {
        if (x == null) return -1;
        return x.height;
    }

    private int getRank(RangeNode x) {
        if (x==null) return 0;
        return x.rank;
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree.
    RangeNode<Integer> balance(RangeNode<Integer> x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.rightChild) < 0) {
                x.rightChild = rotateRight(x.rightChild);
            }
            x = rotateLeft(x);
        } else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.leftChild) > 0) {
                x.leftChild = rotateLeft(x.leftChild);
            }
            x = rotateRight(x);
        }
        return x;
    }

    // Return all keys that are between [lo, hi] (inclusive).
    // TODO: runtime = O(?)
    public List<Integer> rangeIndex(int lo, int hi) {
        // TODO


        List<Integer> l = new LinkedList<>();
        addToList(root, l,  lo, hi);

        return l;
    }

    private void addToList(RangeNode<Integer> node, List<Integer> l, int lo, int hi) {
        if (node != null) {
            if (node.key >= lo && node.key <= hi) {
                addToList(node.leftChild, l, lo, hi);
                l.add(node.key);
                addToList(node.rightChild, l, lo, hi);
            }

            if (node.key < lo) {
                addToList(node.rightChild,l,lo,hi);

            }

            if (node.key > hi) {
                addToList(node.leftChild, l, lo, hi);
            }
        }

    }









    // return the number of keys between [lo, hi], inclusive
    // TODO: runtime = O(?)
    public int rangeCount(int lo, int hi) {
        // TODO


        int high =  rank(root, hi+1);
        int low = rank(root, lo);

        int count = high - low;



        return count;
    }

//    private int count(RangeNode<Integer> node, int lo, int hi) {
//        if (node == null) {
//            return 0;
//        }
//
//        if(node.key >= lo && node.key <= hi) {
//            return 1 + count(node.leftChild, lo, hi) + count(node.rightChild, lo, hi);
//        } else if (node.key < lo) {
//            return count(node.rightChild, lo, hi);
//        } else {
//            return count(node.leftChild, lo, hi);
//        }
//    }


    private int rank(RangeNode<Integer> node, int k) {
        if (node == null) {
            return 0;
        } else if (node.key >= k) {
            return rank(node.leftChild, k);
        } else {
            if (node.leftChild != null) {
                return(getRank(node.leftChild) + rank(node.rightChild, k) + 2);

            } else {
                return(getRank(node.leftChild) + rank(node.rightChild, k) + 1);

            }
        }
    }



    private int getDecendences(RangeNode<Integer> node) {

        int right = (node.rightChild != null) ? node.rightChild.rank + 1 : 0;
        int left = (node.leftChild != null) ? node.leftChild.rank + 1 : 0;

        return right + left;


    }



    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(RangeNode x) {
        return height(x.rightChild) - height(x.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private RangeNode<Integer> rotateRight(RangeNode<Integer> x) {
        RangeNode<Integer> l = x.leftChild;
        x.leftChild = l.rightChild;
        l.rightChild = x;

        x.rank = getDecendences(x);
        l.rank = getDecendences(l);

        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));
        l.height = 1 + Math.max(height(l.leftChild), height(l.rightChild));
        return l;
    }



    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private RangeNode<Integer> rotateLeft(RangeNode<Integer> x) {
        RangeNode<Integer> y = x.rightChild;
        x.rightChild = y.leftChild;
        y.leftChild = x;

        x.rank = getDecendences(x);
        y.rank = getDecendences(y);

        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));
        y.height = 1 + Math.max(height(y.leftChild), height(y.rightChild));
        return y;
    }
}
