import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    private final List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void add(int num) { 
        heap.add(num);
        int i = heap.size() - 1;
        while (i != 0 &&  heap.get(i) < heap.get((i - 1) / 2)) {
            int j = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, j);
            i = (i - 1) / 2;
        }
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 0;
        int smallest;
        int left = ((2 * index) + 1);
        int right;
        

        while ( left < heap.size()) {
            smallest = index;
            left = ((2 * index) + 1);
            right = ((2 * index) + 2);

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }
            if (smallest == index) break;

            int temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
            index = smallest;
        }

        return root;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
}