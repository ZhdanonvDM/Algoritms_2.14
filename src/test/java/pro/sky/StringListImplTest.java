package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringListImpl s;
    @BeforeEach
    void setUp() {
//        String[] test = {"1", "2", "3"};
        s = new StringListImpl();
        s.add("1");
        s.add("2");
        s.add("3");
    }


    @Test
    void add() {
        s.add("4");
        String[] test2 = {"1", "2", "3", "4"};
        assertArrayEquals(test2, s.toArray());
        assertThrows(NullPointerException.class, () -> {
            s.add(null);
        });

    }

    @Test
     void removeString() {
        s.remove("3");
        String[] test2 = {"1", "2"};
        assertArrayEquals(test2, s.toArray());
        assertThrows(NoSuchElementException.class, () -> {
            s.remove("4");
        });
    }

    @Test
    void testRemoveIndex() {
        s.remove(2);
        String[] test2 = {"1", "2"};
        assertArrayEquals(test2, s.toArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.remove(4);
        });
    }

    @Test
    void contains() {
        assertTrue(s.contains("3"));
    }

    @Test
    void indexOf() {
        assertEquals(1, s.indexOf("2"));
    }

    @Test
    void lastIndexOf() {
        assertEquals(2, s.lastIndexOf("3"));
    }

    @Test
    void testEquals() {
        String[] test2 = {"1", "2", "3"};
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void isEmpty() {
        assertFalse(s.isEmpty());
    }

    @Test
    void testAddIndex () {
        s.add(2,"4");
        String[] test2 = {"1", "2", "4", "3"};
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void get() {
        assertEquals("1", s.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.get(4);
        });
    }

    @Test
    void toArray() {
        String[] test2 = {"1", "2", "3"};
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void clear() {
        s.clear();
        String[] test2 = new String[0];
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void set() {
        String[] test2 = {"1", "2", "4"};
        s.set(2, "4");
        assertArrayEquals(test2, s.toArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.set(4, "5");
        });
    }

    @Test
    void size() {
        assertEquals(3, s.size());
    }
}