package ex47;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class FizzBuzzStream {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 100);

        final var stream = flux
                .map(v -> (v % 3 == 0 && v % 5 ==0)? Tuples.of(v, "Fizz Buzz") : Tuples.of(v, v.toString()) )
                .map(t -> (t.getT1() % 3 == 0 && t.getT1() % 5 != 0)? Tuples.of(t.getT1(), "Fizz") : Tuples.of(t.getT1(), t.getT2()) )
                .map(w -> (w.getT1() % 5 == 0 && w.getT1() % 3 != 0)? Tuples.of(w.getT1(), "Buzz") : Tuples.of(w.getT1(), w.getT2() ))
                .map(y -> y.getT2())
                .collectList();

        final var resoult = stream.block();
        System.out.println(resoult);

    }
}

