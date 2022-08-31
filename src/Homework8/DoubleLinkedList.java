package Homework8;


import java.util.Iterator;

public class DoubleLinkedList implements MyList {
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        DoubleLinkedNode n = head;
        b.append("[");
        while (n != null) {
            b.append(n.getValue());
            n = n.getNext();
            if (n != null) {
                b.append(", ");
            }
        }
        b.append("]");
        return b.toString();
    }


    @Override
    public void add(int value) {
        // идти начиная с head до последнего (пока getNext() != null)
        if (head == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        DoubleLinkedNode n = head;
        while (n.getNext() != null) {
            n = n.getNext();

        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new DoubleLinkedNode(value));
        tail = n.next;

    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public void add(int index, int value) {

    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    static class DoubleLinkedNode {
        private int value;
        private DoubleLinkedNode next = null;
        private DoubleLinkedNode prev = null;

        public DoubleLinkedNode(int value) {
            this.value = value;
        }

        public DoubleLinkedNode(int value, DoubleLinkedNode next, DoubleLinkedNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public DoubleLinkedNode() {

        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DoubleLinkedNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkedNode next) {
            this.next = next;
        }

        public DoubleLinkedNode getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinkedNode prev) {
            this.prev = prev;
        }
    }


    void addLast(int value) {

        // проверяем, есть ли вообще объекты в листе
        if (head == null && tail == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        // определяем условия добавления 1-ого элемента
        if (size() == 1 /*&& head.equals(tail)*/) {
            tail = new DoubleLinkedNode(value);
            head.setNext(tail);
            tail.setPrev(head);
            return;
        }
        // определяем условия добавления 2-ого и последующих элементов
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(value);
        tail.next = doubleLinkedNode;
        doubleLinkedNode.setPrev(tail);
        tail = doubleLinkedNode;
    }

    void removeLast() {
//        if (head == null && tail == null)
//            throw new NullPointerException();
//
//        if (head == tail) {
//            head = null;
//            tail = null;
//            return;
//        }
        if (this.head != null) {

            //1. if head in not null and next of head
            //   is null, release the head
            if (this.head.next == null) {
                this.head = null;
            } else {

                //2. Else, traverse to the second last
                //   element of the list
                DoubleLinkedNode temp;
                temp = this.head;
                while (temp.next.next != null)
                    temp = temp.next;

                //3. Change the next of the second
                //   last node to null and delete the
                //   last node
                temp.next = null;
            }
        }

    }


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(3);
        list.add(4);
        list.add(5);


//        System.out.println(list);
//        list.addLast(10);
//        list.addLast(5);
//        list.addLast(7);
//        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

    }
}
