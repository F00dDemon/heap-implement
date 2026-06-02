import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    private Heap testHeap = new Heap();

    @Test
    public void testAddToHeap() {
        int value = 10;
        testHeap.add(value);
        assertEquals(testHeap.peek(), 10);
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
        int value = 10;
        testHeap.add(value);
        assertEquals(testHeap.peek(), value);
    }

    @Test
    public void testSizeOfHeap() {
        int value = 10;
        testHeap.add(value);
        assertEquals(testHeap.size(), 1);
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
}