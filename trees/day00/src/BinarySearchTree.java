import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;



public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;

        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public void traverse(TreeNode<T> n, ArrayList<T> l) {

        if (n == null) {
            return;
        }
        traverse(n.leftChild, l);
        l.add(n.key);
        traverse(n.rightChild, l);

    }


    public List<T> inOrderTraversal() {
        // TODO

        ArrayList<T> inOrderList = new ArrayList<>();

        if (root != null) {
            traverse(root, inOrderList);
        }

        return inOrderList;
    }

    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        TreeNode<T> deleted = delete(toDelete);
        if (toDelete == root) {
            root = deleted;
        }
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;

        TreeNode<T> replacement;

        if (n.isLeaf())
            // Case 1: no children
            replacement = null;
        else if (n.hasRightChild() != n.hasLeftChild())
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
        else {
            // Case 3: two children
            // TODO
            TreeNode<T> s = findSuccessor(n);
            replacement = s;
            delete(s);
            replacement.moveChildrenFrom(n);



        }

        // Put the replacement in its correct place, and set the parent.
        n.replaceWith(replacement);
        return replacement;
    }

    public T findPredecessor(T key) {
        // finds and returns the TreeNode with key = key if such a TreeNode exists in the tree
        TreeNode<T> n = find(root, key);
        if (n != null) {
            // get the predecessor TreeNode by calling the function you will implement below
            TreeNode<T> predecessor = findPredecessor(n);
            // return the key of predecessor TreeNode
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        // finds and returns the TreeNode with key = key if such a TreeNode exists in the tree
        TreeNode<T> n = find(root, key);
        if (n != null) {
            // get the successor TreeNode by calling the function you will implement below
            TreeNode<T> successor = findSuccessor(n);
            // return the key of successor TreeNode
            if (successor != null)
                return successor.key;
        }
        return null;
    }


    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        // TODO

        if (n== null) {
            return null;
        }

        // finds the maximum value on the left branch
        if (n.hasLeftChild()) {
            TreeNode<T> temp = n.leftChild;
            while (temp.rightChild != null) {
                temp = temp.rightChild;
            }
            return temp;
        } else {
        // if it is a right child, return the parent, if it is a left child, travel up the tree
            TreeNode<T> p = n.parent;
            while (p!= null && n==p.leftChild) {
                n=p;
                p=p.parent;
            }
            return p;
        }

    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        // TODO
        if (n == null) {
            return null;
        }

        // finds the minimum value on the right branch
        if (n.hasRightChild()) {
            TreeNode<T> temp = n.rightChild;
            while (temp.leftChild != null) {
                temp = temp.leftChild;
            }
            return temp;
        } else {
        // if it is a left child, return the parent, if it is a right child, travel up the tree
            TreeNode<T> p = n.parent;
            while (p!= null && n==p.rightChild) {
                n=p;
                p=p.parent;
            }
            return p;
        }
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
