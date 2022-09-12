package Homework11;

import java.util.Arrays;

public class CustomArrayDeque implements CustomDeque {

    private int[] source; //  массив с содержимым
    private int size = 0; // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить / добавить элемент вначало

    private static final int CAPACITY = 4;

    CustomArrayDeque() {
        source = new int[CAPACITY];
    }

    @Override
    public void addFirst(int i) {
        if (size == source.length)
            increaseCapacity(); // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
//        if (size == 0) {
//        } else {
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;

//        if(firstElementIndex == 0)
//            firstElementIndex = source.length - 1;
//        else
//            firstElementIndex = firstElementIndex - 1;
//        }
        source[firstElementIndex] = i;
        size++;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];

        int j = 0; // индекс в новом массив
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        }
        firstElementIndex = 0;
        source = newSource;
    }

    @Override
    public int getFirst() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() {
        // вернуть элемент по firstElementIndex
        // увеличить на 1 firstElementIndex
        // уменьшить на 1 size
        if (size == 0)
            throw new IndexOutOfBoundsException();
        int el = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return el;
    }

    @Override
    public void addLast(int i) {
        if (size == source.length)
            increaseCapacity();

        source[(size + firstElementIndex) % source.length] = i;
        size++;
    }

    @Override
    public int getLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return source[(size + firstElementIndex - 1) % source.length];
//        return source[firstElementIndex + size - 1];
    }

    @Override
    public int removeLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        int el = source[(size + firstElementIndex - 1) % source.length];
        size--;
        return el;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < size; i++) {
            b.append(source[(firstElementIndex + i) % source.length]);
            if (i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
//        return Arrays.toString(source);
    }


}


