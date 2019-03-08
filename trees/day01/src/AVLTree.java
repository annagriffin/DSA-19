public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            n.height = Math.max(height(n.leftChild), height(n.rightChild)) + 1;
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            n.height = Math.max(height(n.leftChild), height(n.rightChild)) + 1;
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        // TODO

        if (n == null) {
            return -1;
        }

        return n.height;
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
        // TODO: (if you're having trouble, use pseudocode provided in slides)

        if (balanceFactor(n) > 1) {
            if (balanceFactor(n.rightChild) <= -1) {
                n.rightChild = rotateRight(n.rightChild);
                n.rightChild.height = Math.max(height(n.rightChild.rightChild), height(n.rightChild.leftChild)) +1;
                n.rightChild.rightChild.height = Math.max(height(n.rightChild.rightChild), height(n.rightChild.leftChild)) +1;
            }
            n = rotateLeft(n);
            n.rightChild.height = Math.max(height(n.rightChild.rightChild), height(n.rightChild.leftChild)) +1;
            n.height = Math.max(height(n.rightChild), height(n.leftChild)) +1;
        }
        if (balanceFactor(n) < -1) {
            if (balanceFactor(n.leftChild) >= 1) {
                n.leftChild = rotateLeft(n.leftChild);
                n.leftChild.height = Math.max(height(n.leftChild.rightChild), height(n.leftChild.leftChild)) +1;
                n.leftChild.leftChild.height = Math.max(height(n.leftChild.leftChild), height(n.leftChild.rightChild)) +1;
            }
            n = rotateRight(n);
            n.leftChild.height = Math.max(height(n.leftChild.rightChild), height(n.leftChild.leftChild)) +1;
            n.height = Math.max(height(n.rightChild), height(n.leftChild)) +1;

        }


        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        // TODO


        return height(n.rightChild) - height(n.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        // TODO

        TreeNode<T> x = n.leftChild;
        TreeNode<T> beta1 = x.rightChild;
        x.rightChild = n;
        n.leftChild = beta1;
        n.height = Math.max(height(n.rightChild), height(n.leftChild)) +1;
        x.height = Math.max(height(x.rightChild), height(x.rightChild)) + 1;
        return x;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        // TODO

        TreeNode<T> k = n.rightChild;
        TreeNode<T> beta = k.leftChild;
        k.leftChild = n;
        n.rightChild = beta;
        n.height = Math.max(height(n.rightChild), height(n.leftChild)) +1;
        k.height = Math.max(height(k.rightChild), height(k.rightChild)) + 1;
        return k;

    }
}
