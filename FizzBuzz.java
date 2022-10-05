package ex44;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//# FizzBuzz multithreaded
//        Parallelize FizzBuzz https://en.wikipedia.org/wiki/Fizz_buzz game.
//        Focus on implementing and interconnecting:
//        - number producer
//        - divisible by 3 checker
//        - divisible by 5 checker
//        - not divisible by 3 and not divisible by 5 checker
//        - console printer
//        Rules:
//        - only producer can generate sequence of numbers
//        - producer generates new number every 400ms
//        - only printer can print result to console
//        - checkers consume input (number or something else) and produce output (number or something else)
//        - checking takes from 150 - 250 ms (randomly)
//        Expected output:
//
//        1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19

public class FizzBuzz {


    record ProducerStage(Integer number, boolean last) {}
    record Div3Stage(ProducerStage producerStage, boolean div3) {
    }

    record Div5Stage(Div3Stage div3Stage, boolean div5) {
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<ProducerStage> queueFromProducerToDiv3 = new LinkedBlockingQueue<>();
        BlockingQueue<Div3Stage> queueFromDiv3ToDiv5 = new LinkedBlockingQueue<>();
        BlockingQueue<Div5Stage> queueFromDiv5ToPrinter = new LinkedBlockingQueue<>();

        final var producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i += 1) {
                    queueFromProducerToDiv3.put(new ProducerStage(i, i == 100));
                    TimeUnit.MILLISECONDS.sleep(4);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final var checker3 = new Thread(() -> {
            try {
                for (; ; ) {
                    final var element = queueFromProducerToDiv3.take();
                    queueFromDiv3ToDiv5.put(new Div3Stage(element, element.number() % 3 == 0));
                    if (element.last()) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final var checker5 = new Thread(() -> {
            try {
                for (; ; ) {
                    final var element = queueFromDiv3ToDiv5.take();
                    queueFromDiv5ToPrinter.put(new Div5Stage(element, element.producerStage().number() % 5 == 0));
                    if (element.producerStage().last()) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final var printer = new Thread(() -> {
            try {
                for (; ; ) {
                    final var element = queueFromDiv5ToPrinter.take();
                    if (element.div5 && element.div3Stage.div3) {
                        System.out.println("Fizz Buzz");
                    } else if (element.div5) {
                        System.out.println("Buzz");
                    } else if (element.div3Stage.div3) {
                        System.out.println("Fizz");

                    } else {
                        System.out.println(element.div3Stage.producerStage().number());
                    }
                    if (element.div3Stage().producerStage().last()) {
                        break;
                    }
                }
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        producer.start();
        checker3.start();
        checker5.start();
        printer.start();


    }

}


















