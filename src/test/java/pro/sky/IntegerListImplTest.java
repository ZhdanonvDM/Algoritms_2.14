package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerListImpl s;
    @BeforeEach
    void setUp() {
        s = new IntegerListImpl();
        s.add(2);
        s.add(4);
        s.add(1);
    }


    @Test
    void add() {
        s.add(0);
        Integer[] test2 = {2, 4, 1, 0};
        assertArrayEquals(test2, s.toArray());
        assertThrows(NullPointerException.class, () -> {
            s.add(null);
        });

    }

    @Test
     void removeValue() {
        s.remove((Integer)1);
        Integer[] test2 = {2, 4};
        assertArrayEquals(test2, s.toArray());
        assertThrows(NoSuchElementException.class, () -> {
            s.remove((Integer)5);
        });
    }

    @Test
    void testRemoveIndex() {
        s.remove( 2);
        Integer[] test2 = {2, 4};
        assertArrayEquals(test2, s.toArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.remove(4);
        });
    }

    @Test
    void contains() {
        assertTrue(s.contains(2));
    }

    @Test
    void indexOf() {
        assertEquals(1, s.indexOf((Integer)4));
    }

    @Test
    void lastIndexOf() {
        assertEquals(1, s.lastIndexOf((Integer)4));
    }

    @Test
    void testEquals() {
        Integer[] test2 = {2, 4, 1};
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void isEmpty() {
        assertFalse(s.isEmpty());
    }

    @Test
    void testAddIndex () {
        s.add(3,0);
        Integer[] test2 = {2, 4, 1, 0};
        assertArrayEquals(test2, s.toArray());
    }

    @Test
    void get() {
        assertEquals(2, s.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.get(4);
        });
    }

    @Test
    void toArray() {
        Integer[] test2 = {2, 4, 1};
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
        Integer[] test2 = {2, 4, 0};
        s.set(2, 0);
        assertArrayEquals(test2, s.toArray());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            s.set(4, 5);
        });
    }

    @Test
    void size() {
        assertEquals(3, s.size());
    }
}