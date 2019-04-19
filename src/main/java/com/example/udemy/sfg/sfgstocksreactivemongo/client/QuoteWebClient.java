package com.example.udemy.sfg.sfgstocksreactivemongo.client;

import com.example.udemy.sfg.sfgstocksreactivemongo.model.Quote;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@Setter
@ConfigurationProperties("sfg")
public class QuoteWebClient {
    private String host;
    private String port;
    private String path;

    public Flux<Quote> getQuoteStream() {
        String baseUrl = "http://" + host + ":" + port;

        return WebClient.builder()
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(path)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Quote.class);
    }
}
