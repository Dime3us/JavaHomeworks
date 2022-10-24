package Homework11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMethodsCustomArrayDeque {
    @Test
    public void addAndGetAndRemoveFirst() {
        CustomArrayDeque deque = new CustomArrayDeque();
        deque.addFirst(10);
        deque.addFirst(20);
        assertEquals("[20, 10]", deque.toString());
        assertEquals(20, deque.getFirst());
        deque.removeFirst();
        assertEquals("[10]", deque.toString());
    }
    @Test
    public void addAndGetAndRemoveLast(){
        CustomArrayDeque deque = new CustomArrayDeque();
        deque.addLast(10);
        deque.addLast(20);
        assertEquals("[10, 20]", deque.toString());
        assertEquals(20, deque.getLast());
        deque.removeLast();
        assertEquals("[10]", deque.toString());
    }
    @Test
    public void toStringTest(){
        CustomArrayDeque deque = new CustomArrayDeque();
        deque.addLast(10);
        deque.addLast(20);
        deque.addFirst(30);
        deque.addFirst(40);
        assertEquals("[40, 30, 10, 20]", deque.toString());
    }
}
