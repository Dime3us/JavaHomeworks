package Homework11;

// Deque - Double Ended Queue - двухсторонняя очередь
// обеспечивает добавление и получение элементов в обоих концов контейнера
public interface CustomDeque {
    void addFirst(int i); // добавление в начало
    int getFirst() throws IndexOutOfBoundsException; // запрос первого элемента без удаления
    int removeFirst() throws IndexOutOfBoundsException; // получение 1 элемента и удаление

    void addLast(int i); // добавление в конец
    int getLast() throws IndexOutOfBoundsException; // получение последнего элемента без удаления
    int removeLast() throws IndexOutOfBoundsException; // получение последнего с удалением

    int size(); // сколько всего элементов
}
