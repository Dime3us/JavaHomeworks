package Homework8;


import org.testng.annotations.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class MyLinkedListTest {
    @Test
    public void testLinkedList() {
        MyLinkedList l = new MyLinkedList();
        assertEquals(0, l.size());
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(3, l.size());
        assertEquals(3, l.get(2));

        assertTrue(l.contains(2));
        l.set(2, 22);
        assertEquals(l.get(2), 22);
        l.add(2, 33);
        assertEquals("[1, 2, 33, 22]", l.toString());
        l.remove(1);
        assertEquals("[1, 33, 22]", l.toString());
        Iterator<Integer> i = l.iterator();
        l.addFirst(555);
        assertEquals("[555, 1, 33, 22]", l.toString());
        assertFalse(i.hasNext());
        l.removeFirst();
        assertEquals("[1, 33, 22]", l.toString());
        assertEquals(l.getFirst(), 1);
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(15);
        list.add(30);
        list.add(45);
        assertEquals("[15, 30, 45]", list.toString());
        list.removeLast();
        assertEquals("[15, 30]", list.toString());
    }
}
