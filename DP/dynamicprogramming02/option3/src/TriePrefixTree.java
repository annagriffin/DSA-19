import java.util.*;


class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;




}


public class TriePrefixTree {

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            TrieNode t = new TrieNode();

            char c = word.charAt(i);

            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                children.put(c, t);

            }

            children = t.children;


        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String start) {
        if (searchNode(start) == null) {
            return false;
        } else {
            return true;
        }
    }


    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);

            } else {

                return null;
            }


        }
        return t;


    }
}