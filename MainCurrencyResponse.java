package ex50;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;

import java.util.Collection;

public class MainCurrencyResponse {

    sealed interface CurrencyResponse {
        record CurrencyRate(String table, String currency, String code,
                            Collection<Rate> rates) implements CurrencyResponse {
        }

        record BadRequest(String message) implements CurrencyResponse {
        }

        record Unknown(String message) implements CurrencyResponse {
        }

        record Rate(String no, String effectiveDate, double bid, double ask) {
        }

    }

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Mono<CurrencyResponse> decode(HttpResponseStatus code, ByteBufMono bytes) {
        return bytes.asString().map(body -> {
            try {
                if (code.equals(HttpResponseStatus.OK)) {
                    return mapper.readValue(body, CurrencyResponse.CurrencyRate.class);
                } else if (code.equals(HttpResponseStatus.BAD_REQUEST)){
                    return new CurrencyResponse.BadRequest(body);
                } else {
                    return new CurrencyResponse.Unknown(body);
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) {
        HttpClient client = HttpClient.create();

        final var average = client.get()
                .uri("http://api.nbp.pl/api/exchangerates/rates/c/eur/2022-09-01/2022-09-30")
                .responseSingle((response, bytes) -> decode(response.status(), bytes))
                .ofType(CurrencyResponse.CurrencyRate.class)
                .map(currencyRate -> {
                    double sum = 0.0;
                    for(final var rate : currencyRate.rates()) {
                        sum += rate.bid;
                    }
                    return sum / currencyRate.rates().size();
                })
                .block();

        System.out.println(average);
    }
}
