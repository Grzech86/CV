package ex49;
//# Reactive Histogram
//        Implement calculation of histogram using reactive streams and substreams.

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestEx49 {

    @Test
    public void testHistogram() {
//        final var input = ThreadLocalRandom.current().ints(1000, 1, 100).toArray();
        final var input = new int[]{1, 11, 21, 31, 41, 51, 61, 71, 81, 91, 92};

        Flux<Integer> externalFlux = Flux.range(1,10);

        final var integerFlux = externalFlux.flatMap(n -> calculateBin(n, input), 10).collectList();

        final var debug = integerFlux.block();

        StepVerifier
                .create(integerFlux)
                .expectNext(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 2))
                .verifyComplete();
    }

    @Test
    public void testSingleValueHistogram() {
//        final var input = ThreadLocalRandom.current().ints(1000, 1, 100).toArray();
        final var input = new int[]{1};

        Flux<Integer> externalFlux = Flux.range(1,10);

        final var integerFlux = externalFlux.flatMap(n -> calculateBin(n, input), 10).collectList();

        final var debug = integerFlux.block();

        StepVerifier
                .create(integerFlux)
                .expectNext(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0))
                .verifyComplete();
    }

    @Test
    public void testEmptyHistogram() {
//        final var input = ThreadLocalRandom.current().ints(1000, 1, 100).toArray();
        final var input = new int[]{};

        Flux<Integer> externalFlux = Flux.range(1,10);

        final var integerFlux = externalFlux.flatMap(n -> calculateBin(n, input), 10).collectList();

        final var debug = integerFlux.block();

        StepVerifier
                .create(integerFlux)
                .expectNext(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
                .verifyComplete();
    }

    private Mono<Integer> calculateBin(Integer n, int[] input) {
        return Mono.just(n).map(k -> {
            final int lower = (k - 1) * 10 + 1;
            final int upper = k * 10;
            int count = 0;
            for(final var i : input) {
                if (lower <= i && i <= upper) {
                    count++;
                }
            }
            return count;
        });
    }


}