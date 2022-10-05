package ex42;

import java.util.concurrent.*;

class Main2 {

    public static volatile long counter = 0;

    public synchronized static void increment() {
        ++counter;
    }

    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");

        final var myThread0 = new Thread(() -> {
            for (int i = 0; i < 250_000_000; ++i) {
                increment();
            }
        });
        final var myThread1 = new Thread(() -> {
            for (int i = 0; i < 250_000_000; ++i) {
                increment();
            }
        });
        final var myThread2 = new Thread(() -> {
            for (int i = 0; i < 250_000_000; ++i) {
                increment();
            }
        });
        final var myThread3 = new Thread(() -> {
            for (int i = 0; i < 250_000_000; ++i) {
                increment();
            }
        });

        myThread0.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();

        myThread3.join();
        myThread2.join();
        myThread1.join();
        myThread0.join();

        System.out.println("counter: " + counter);

    }
}

public class InterleavedPrint {

    public static void print(Integer param) {
        System.out.println(Thread.currentThread().getName() + " : " + param);
    }

    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        final var myThreadA = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                print(i);
                flag = true;
                while (flag) {
                }
            }
        });

        final var myThreadB = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                while (!flag) {
                }
                print(i);
                flag = false;
            }
        });

        myThreadA.start();
        myThreadB.start();

        myThreadA.join();
        myThreadB.join();

    }
}

class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ala");
        });
        service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ma");
        });
        service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("kota");
        });

        System.out.println("submission completed");
    }
}

class Main1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final var service = Executors.newSingleThreadExecutor();

        Future<Integer> submit = service.submit(() -> 2);

        System.out.println("submission completed");

        final Integer result;
        try {
            result = submit.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            // do something
            throw new RuntimeException(e);
        }
        System.out.println("result: " + result);

        service.shutdown();
    }
}

