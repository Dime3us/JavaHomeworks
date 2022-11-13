package Homework31;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PiThread {
    private static int yes = 0;
    private static int no = 0;

    public static void main(String[] args) throws InterruptedException {

        long a = System.currentTimeMillis();
        PiRunnable p1 = new PiRunnable();
        p1.execute(2);
        long b = System.currentTimeMillis();
        System.out.println("Work time with 2 Threads = " + (b-a) + " ms");
        yes = 0;no = 0;

        long c = System.currentTimeMillis();
        PiRunnable p2 = new PiRunnable();
        p2.execute(3);
        long d = System.currentTimeMillis();
        System.out.println("Work time with 3 Threads = " + (d-c) + " ms");
        yes = 0;no = 0;

        long e = System.currentTimeMillis();
        PiRunnable p3 = new PiRunnable();
        p3.execute(4);
        long f = System.currentTimeMillis();
        System.out.println("Work time with 4 Threads = " + (f-e) + " ms");

    }

    static class PiRunnable implements Runnable {
        public void execute(int n) throws InterruptedException {
            ExecutorService service = Executors.newFixedThreadPool(n);
            Runnable r = new PiRunnable();
            int i = 0;
            while (i < 1_000_000) {
                service.submit(r);
                i++;
            }
            service.shutdown();
            Thread.sleep(200);
            System.out.println("pi = " + 4.0 * yes / (yes + no));
            System.out.println("yes counter = " + yes);
            System.out.println("no counter = " + no);
            System.out.println("count sum = " + (yes + no));

        }
        @Override
        public void run() {
            Random random = new Random();
            double x = random.nextDouble();
            double y = random.nextDouble();
            double R = Math.sqrt(x * x + y * y);
            countSum(R);
        }
        private void countSum(double R) {
            if (R < 1.0)
                yes++;
            if (R > 1.0)
                no++;
        }
    }
}
/*Вычислите многопоточно число pi - инструкции ниже

Заведите два целых счетчика - один для точек, для которых вычисленное расстояние до начала координат R меньше  1.0 ("yes" счетчик)
и второй счетчик для тех точек, для которых вычисленное расстояние до начала координат R больше 1.0

Создайте производный от Runnable класс и внутри run метода напишите:
Сгенерируйте с помощью генератора случайных чисел два double числа из диапазона [0.0 - 1.0] - x и y координаты точки
С помощью теоремы Пифагора вычислите для нее расстояние от начала координат - R.
Если для сгенерированой точки расстояние R до начала координат меньше 1.0 то увеличивайте на единицу счетчик "yes"; если R больше 1.0 увеличивайте на единицу счетчик "no".
Создайте и запустите 1_000_000 таких Runnable через ExecutorService
По результатам эксперимента вычислите значение pi как 4.0*yes/(yes+no)*/