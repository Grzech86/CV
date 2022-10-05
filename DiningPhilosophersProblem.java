package ex43;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;


public class DiningPhilosophersProblem {

    static int philosopher = 5;
    static Philosopher Philosophers[] = new Philosopher[philosopher];
    static Chopstick Chopsticks[] = new Chopstick[philosopher];



    static class Philosopher extends Thread {

        public int number;
        public Chopstick leftchopstick;
        public Chopstick rightchopstick;

        Philosopher(int num, Chopstick left, Chopstick right) {
            number = num;
            leftchopstick = left;
            rightchopstick = right;
        }

        public void run(){

            while (true) {
                leftchopstick.grab();
                System.out.println("philosopher " + (number+1) + " grabs left chopstick.");
                rightchopstick.grab();
                System.out.println("philosopher " + (number+1) + " grabs right chopstick.");
                eat();
                leftchopstick.release();
                System.out.println("philosopher " + (number+1) + " releases left chopstick.");
                rightchopstick.release();
                System.out.println("philosopher " + (number+1) + " releases right chopstick.");

            }
        }

        void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 100);
                System.out.println("philosopher " + (number+1) + " eats for " + sleepTime);
                Thread.sleep(sleepTime);
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

    }
    static class Chopstick {
        public Semaphore mutex = new Semaphore(2);
        void grab() {
            try {
                mutex.acquire();
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        void release() {
            mutex.release();
        }
        boolean isFree() {
            return mutex.availablePermits() > 0;
        }
    }
    public static void main(String arg[]) {

        for (int i = 0; i < philosopher; i++) {
            Chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < philosopher; i++) {
            Philosophers[i] = new Philosopher(i, Chopsticks[i], Chopsticks[(i + 1) % philosopher]);
            Philosophers[i].start();
        }

        for(;;) {
            try {
                Thread.sleep(100);
                boolean deadlock = true;
                for (Chopstick f : Chopsticks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(100);
                    System.out.println("Everyone Eats");
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.println("Exit The Program!");
        System.exit(0);
    }
}
