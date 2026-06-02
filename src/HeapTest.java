import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {
    private Heap testHeap;

    @Before
    public void setup() {
        testHeap = new Heap();
    }

    @Test
    public void testAddToHeap() {
        int value = 10;
        testHeap.add(value);
        assertEquals(10, testHeap.peek()); //flipped expected and actual values
    }

    @Test
    public void testPopFromHeap() {
        int value = 10;
        testHeap.add(value);
        testHeap.pop();
        assertTrue(testHeap.isEmpty());
    }

    @Test
    public void testPeekFromHeap() {
        int value = 20;
        testHeap.add(value);
        assertEquals(value, testHeap.peek());
    }

    @Test
    public void testSizeOfHeap() {
        int value = 10;
        testHeap.add(value);
        assertEquals(1, testHeap.size());
    }

    @Test
    public void testIsHeapEmptyTrue() {
        assertTrue(testHeap.isEmpty());
    }

    @Test
    public void testIsHeapEmptyFalse() {
        int value = 10;
        testHeap.add(value);
        assertFalse(testHeap.isEmpty());
    }

    @Test
    public void testEmptyHeapPopException() {
        assertThrows(NoSuchElementException.class, () -> { testHeap.pop(); });
    }

    @Test
    public void testEmptyHeapPeekException() {
        assertThrows(NoSuchElementException.class, () -> { testHeap.peek(); });
    }

    @Test
    public void testMultiAddHeap() {
        testHeap.add(10);
        testHeap.add(20);
        testHeap.add(30);
        testHeap.add(40);
        assertEquals(4, testHeap.size());
    }

    @Test
    public void testDuplicateAddHeap() {
        testHeap.add(10);
        testHeap.add(10);
        testHeap.add(10);
        testHeap.add(10);
        assertEquals(4, testHeap.size());
        assertEquals(10, testHeap.pop());
        assertEquals(3, testHeap.size());
        assertEquals(10, testHeap.pop());
        assertEquals(2, testHeap.size());
        assertEquals(10, testHeap.pop());
        assertEquals(1, testHeap.size());
        assertEquals(10, testHeap.pop());
    }

    @Test
    public void testRandomAddHeap() {
        testHeap.add(5);
        testHeap.add(20);
        testHeap.add(3);
        testHeap.add(7);
        testHeap.add(40);
        assertEquals(3, testHeap.pop());
        assertEquals(5, testHeap.pop());
        assertEquals(7, testHeap.pop());
        assertEquals(20, testHeap.pop());
        assertEquals(40, testHeap.pop());
    }

    @Test
    public void testRandomAddAndPopHeap() {
        testHeap.add(5);
        testHeap.add(20);
        testHeap.pop();
        testHeap.add(3);
        testHeap.add(7);
        testHeap.pop();
        testHeap.add(40);
        testHeap.add(64);
        testHeap.add(8);
        assertEquals(7, testHeap.pop());
    }
}