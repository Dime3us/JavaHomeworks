package Homework7;

import java.util.Arrays;
import java.util.Iterator;

public class MyCustomArrayList implements AdvancedArrayList {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size = 0;
    public MyCustomArrayList() {
        data = new int[INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        MyCustomArrayList l = new MyCustomArrayList();
        l.append(1);
        l.append(3);
//        // l.set(-5, 10);
//        //l.set(0, 10);
//        // l.set(3, 10);
        l.remove(0);
        l.print();
//        l.insert(1, 2);
//        l.print();
//
//
//        int [] a = new int[] {11,12,13,14,15,16,17,18,19,20};
//        l.append(a);
//        l.print();

    }

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(int value) {
        if (size == data.length)
            increaseCapacity();
        data[size++] = value;
    }

    @Override
    public void append(int[] a) {
        for (int i = 0; i < a.length; i++) {
            append(a[i]);
        }
    }

    private void increaseCapacity() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (size == data.length)
            increaseCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }


    public void print() {
//        for (int i = 0; i < size; i++) {
//            System.out.print(data[i] + " ");
//        }
        System.out.println();
        System.out.println(Arrays.toString(data));
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (value == data[i])
                return true;
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new UnsupportedOperationException("remove");
        int[] newData = new int[size() - 1];
        System.arraycopy(data, 0, newData, 0, index);
        if (size() - (index + 1) >= 0) System.arraycopy(data, index + 1, newData, index + 1 - 1, size() - (index + 1));
        data = newData;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }


        };
    }
}

