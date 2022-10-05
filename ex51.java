package ex51;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class ex51 {

    record Authors(Collection<Author> everythings) {
    }

    record Author(String url, String href, String name, String slug) {
    }

    record AuthorDetails(String name, String url, String sort_key, String description) {
    }

    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws InterruptedException {
        HttpClient client = HttpClient.create();

        final var fluxAuthors = client.get()
                .uri("https://wolnelektury.pl/api/authors/")
                .responseSingle((response, bytes) -> bytes.asString().map(body -> decodeAuthors(body)))
                .flux();

        final var fluxFiveAuthors = fluxAuthors
                .flatMap(authors -> Flux.fromIterable(authors))
                .take(5);

        final var fluxDetails = fluxFiveAuthors
                .flatMap(author -> client
                        .get()
                        .uri(author.href)
                        .responseSingle((response, bytes) -> bytes.asString().map(body -> decodeAuthorDetails(body))))
                .collectList();

        fluxDetails
                .subscribe(details -> System.out.println(details));


        TimeUnit.SECONDS.sleep(10);
    }

    private static AuthorDetails decodeAuthorDetails(String body) {
        try {
            return mapper.readValue(body, AuthorDetails.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Collection<Author> decodeAuthors(String body) {
        try {
            return mapper.readValue(body, new TypeReference<Collection<Author>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
