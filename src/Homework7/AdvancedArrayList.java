package Homework7;

import java.util.Iterator;

public interface AdvancedArrayList extends Iterable<Integer> {
    void set(int index, int value);

    int get(int index);

    int size();

    void append(int value);

    void append(int[] a);

    void insert(int index, int value);

    // void insert(int index, int [] a);
    void delete(int index);

    // void delete(int index, int howMany);
    boolean contains(int value);

    void remove(int index);

    Iterator<Integer> iterator();
}

