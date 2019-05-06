import java.util.*;




class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf;


    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isLeaf() {
        return isLeaf;
    }

    void setLeaf(boolean leaf) {
        this.isLeaf = leaf;
    }

}





public class TriePrefixTree {

    private TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode curr = root;

        for (int i=0; i < word.length(); i++) {

            curr = curr.getChildren().computeIfAbsent(word.charAt(i), child -> new TrieNode());
        }

        curr.setLeaf(true);
    }


    boolean contains(String word) {

        TrieNode curr = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode n = curr.getChildren().get(c);
            if (n == null) {
                return false;
            }

            curr = n;
        }

        return curr.isLeaf();


    }

    boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }





    private boolean delete(TrieNode curr, String word, int idx) {
        if (idx == word.length()) {
            if (!curr.isLeaf()) {
                return false;
            }

            curr.setLeaf(false);
            return curr.getChildren().isEmpty();
        }

        char c = word.charAt(idx);
        TrieNode n = curr.getChildren().get(c);
        if (n==null) {
            return false;
        }

        if (!n.isLeaf()) {
            boolean check = delete(n, word, idx+1);

            if (!check) {
                curr.getChildren().remove(c);
                return curr.getChildren().isEmpty();
            }
        }

        return false;

    }

    void deleteHelper(String word) {

        delete(root, word, 0);
    }



}
