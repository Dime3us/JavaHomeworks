package Homework8;

import java.util.Iterator;

public class MyLinkedList implements Homework8.MyList {
    // Lists implementations. LinkedList.

    private Node head; // первый элемент списка

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        Node n = head;
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
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null) {

            n = n.getNext();
        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new Node(value));
    }

    @Override
    public void set(int index, int value) {
        Node n = head;
        while (n != null) {
            if (index == 0) {
                n.setValue(value);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public void add(int index, int value) {
        Node n = head;
        Node one = null;
        Node two = null;

        while (n != null) {
            if (index == 1) {
                one = n;
                two = n.getNext();
                break;
            }
            index--;
            n = n.getNext();
        }
        if (one != null) {
            Node nw = new Node(value, two);
            one.setNext(
                    //new Node(value, two)
                    nw
            );
        }
    }

    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int get(int index) {
        Node n = head;
        while (n != null) {
            if (index == 0)
                return n.getValue();
            index--;
            n = n.getNext();
        }
        return 0;
    }

    @Override
    public void remove(int index) {

        Node n = head;
        if (index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = n.next;
            return;
        }

        while (n != null) {
            if (index == 1) {
                n.next = n.getNext().next;
                break;
            }
            index--;
            n = n.getNext();
        }

    }


    @Override
    public int size() {
        int sz = 0; // size
        Node n = head;
        while (n != null) {
            sz++;
            n = n.getNext();
        }
        return sz;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(position--);
            }

            @Override
            public Integer next() {
                Node n = head;
                while (n != null)
                    return n.getNext().value;

                return null;
            }
        };
    }

    static class Node {
        private int value;
        private Node next = null;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    void addFirst(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

    }

    void removeFirst() {
        if (head == null)
            throw new NullPointerException();
        head = head.getNext();

    }

    int getFirst() {
        if (head == null)
            throw new NullPointerException();

        return head.getValue();
    }

    public static void main(String[] args) {
        // Node n = new MyLinkedList().new Node(); // внутренний не статический класс
        // Node n = new MyLinkedList.Node(); // внутренний статический класс
        MyLinkedList l = new MyLinkedList();
        System.out.println(l);

        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        l.remove(0);
        System.out.println(l);
        l.addFirst(555);
        System.out.println(l);
        l.removeFirst();
        System.out.println(l);
        System.out.println(l.getFirst());
    }
}

   /*
   Дописать delete, iterator() и тесты

        * дописать remove в итераторе
        дописать методы void addFirst(int), void removeFirst(), int getFirst() добавляющие, удаляющие и получающие первый элемент в списке

        **** сделать DoubleLinkedList класс на базе MyLinkedList - добавить ссылку на предыдущий элемент в каждый DoubleLinkedNode
         (prev, next ссылки на предыдущий и следующий элементы) и добавить ссылку DoubleLinkedNode tail (на конечный элемент) в класс;
          добавить методы void addLast(int), void removeLast() и int getLast() добавляющие, удаляющие и получающие последний элемент в списке
    */