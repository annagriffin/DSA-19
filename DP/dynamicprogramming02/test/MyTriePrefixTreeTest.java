
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


public class MyTriePrefixTreeTest {

    private TriePrefixTree t;


    @Test
    void insertElement() {
        assertTrue(t.contains("quick"));
        assertTrue(t.contains("brown"));
        assertTrue(t.contains("fox"));
        assertTrue(t.contains("jumps"));
        assertTrue(t.contains("over"));
        assertTrue(t.contains("lazy"));
        assertTrue(t.contains("dog"));

        assertFalse(t.contains("words"));
        assertFalse(t.contains("not"));
        assertFalse(t.contains("here"));

    }

    @BeforeEach
    public void createNewTrie() {

        t = new TriePrefixTree();

        t.insert("quick");
        t.insert("brown");
        t.insert("fox");
        t.insert("jumps");
        t.insert("over");
        t.insert("lazy");
        t.insert("dog");

    }



    @Test
    public void isNotEmptyTest() {

        assertFalse(t.isEmpty());
    }

    @Test
    public void deleteElement() {

        assertTrue(t.contains("jumps"));
        t.deleteHelper("jumps");
        assertFalse(t.contains("jumps"));
    }


}