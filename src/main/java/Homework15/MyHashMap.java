package Homework15;

public class MyHashMap implements MyMap {

    private int size = 0; // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 4; // начальный размер массива
    private static final double LOAD_FACTOR = 0.75; // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR то нужно перебалансировать
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair[] source = new Pair[INITIAL_CAPACITY]; // массив для хранения "голов" цепочек

    private static class Pair { // элемент
        String key; // ключ
        String value; // значение
        Pair next; // ссылка на следующий элемент в цепочке

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }
    }

    @Override
    public void put(String key, String value) {
        if (size > LOAD_FACTOR * source.length)
            resize();
        Pair pair = findPair(key); // поиск пары по ключу
        if (pair == null) // нужно вставить новую пару
        {
            int bucket = findBucket(key); // найдем номер ведра по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair; // делаем новую пару корнем цепочки
            size++;
        } else {
            pair.value = value; // такая пара уже есть, просто меняем значение
        }
    }

    private int findBucket(String key) { // по ключу находим хэш и по хэшу находим бакет

        return Math.abs(key.hashCode()) % source.length;

    }

    // поиск пары по ключу
    private Pair findPair(String key) {
        // найдем ведро по ключу
        int bucket = findBucket(key);
        Pair currentPair = source[bucket]; // корень цепочки
        while (currentPair != null) {
            if (currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null; // пара с ключом key не найдена
    }

    //     перебалансировка массива - создание массива в два раза больше и перенос
//     туда всех элементов
    private void resize() {
//
//            // нужно создать новый массив в два раза больше, чем sourceP

        Pair[] newSource = new Pair[source.length * 2];   //создаем массив в два раза больше
        for (Pair pair : source)                                 // пробегаем по старому массиву
        {
            Pair pair1 = pair;
            while (pair1 != null) {
                Pair pair2 = pair1.next;
                int bucket = Math.abs(pair1.key.hashCode()) % newSource.length;
                pair.next = newSource[bucket];
                newSource[bucket] = pair1;
                pair1 = pair2;
            }
        }
        source = newSource;
    }

    @Override
    public String toString() {
        int s = size - 1;
        StringBuilder b = new StringBuilder();

        for (Pair p : source
        ) {
            Pair c = p;
            while ((c != null)) {
                s--;
                b.append(c);
                if (s >= 0) {
                    b.append((", "));
                }
                c = c.next;
            }
        }
        b.append("]");
        return b.toString();
    }

    //                int bucket = Math.abs(pair.key.hashCode()) % newSource.length;
//
//                if (newSource[bucket] != null)
//                    pair.next = newSource[bucket];
//
//                newSource[bucket] = pair;
//                pair = pair.next;
//            }
//
//        }
//        source = newSource;

//                Pair currentPair = source[i];                   //создаем пару из старого массива
//                while (currentPair != null) {                   //и проверяем ее на null
//                    // находим бакет в новом массиве
//                    int bucket = Math.abs(currentPair.key.hashCode()) % newSource.length;  //находим бакет для нового массива
//                    Pair newPair = newSource[bucket];                     //создаем пару для нового массива
//                    if (newPair == null) {                          //     и проверяем ее на null
//                        newSource[bucket] = currentPair;            // кладем пару из старого в голову нового
//                        currentPair = currentPair.next;
//                        continue;
//                    } else {
//                        while (newPair != null) {               //если голова уже занята
//                            newPair = newPair.next;             //идем к следующему элементу вниз
//                        }
//                        // в этом месте вместо newPair должно быть что-то связанное с newSource
//                        newPair.value = currentPair.value;
//                    }
//                    currentPair = currentPair.next;
//                }
//            }
//            source = newSource;
//        }


//         нужно создать новый массив длины в два раза больше чем source
//         пробежаться по всем корневым элементам и перенести их
//         в нужные бакеты нового массива


    @Override
    public String get(String key) { // найти значение в паре с ключом key
        Pair pair = findPair(key);
        if (pair == null)
            return null;

        return pair.value;
    }

    @Override
    public String remove(String key) {
        if (size == 0)
            return "Container is empty";

        int bucket = findBucket(key);

        Pair currentPair = source[bucket];
        if (currentPair.key.equals(key)) {
            if (currentPair.next == null) {
                source[bucket] = null;
                size--;
                return currentPair.value;
            }
            source[bucket] = currentPair.next;
            size--;
            return currentPair.value;
        }
        while (currentPair.next != null) {
            if (currentPair.next.key.equals(key)) {
                Pair pairTemp = currentPair.next;
                currentPair.next = currentPair.next.next;
                size--;
                return pairTemp.value;
            }

            currentPair = currentPair.next;
        }

        return "No such element";
    }



//    public String removeTeacher(String key) {
//        int bucket = findBucket(key);
//        Pair c = source[bucket];
//        if(c == null)
//            return null;
//        if(c.key.equals(key))
//        {
//            source[bucket]  = c.next;
//            size--;
//            return c.value;
//        }
//        while (c.next != null)
//        {
//            if(c.next.key.equals(key))
//            {
//                Pair toDelete = c.next;
//                c.next = toDelete.next;
//                size--;
//                return toDelete.value;
//            }
//            c = c.next;
//        }
//        return null;
//    }



    @Override
    public boolean contains(String key) {

        Pair pair = findPair(key);
        return pair != null;

    }

    @Override
    public int size() {
        return size;
    }


}
