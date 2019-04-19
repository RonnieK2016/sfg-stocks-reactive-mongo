package com.example.udemy.sfg.sfgstocksreactivemongo.bootstrap;

import com.example.udemy.sfg.sfgstocksreactivemongo.client.QuoteWebClient;
import com.example.udemy.sfg.sfgstocksreactivemongo.model.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

//@Component
public class QuoteRunner implements CommandLineRunner {

    private final QuoteWebClient quoteWebClient;

    public QuoteRunner(QuoteWebClient quoteWebClient) {
        this.quoteWebClient = quoteWebClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Quote> quoteFlux = quoteWebClient.getQuoteStream();

        quoteFlux.subscribe(System.out::println);
    }
}
