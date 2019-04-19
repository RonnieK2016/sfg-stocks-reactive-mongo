package com.example.udemy.sfg.sfgstocksreactivemongo.service;

import com.example.udemy.sfg.sfgstocksreactivemongo.client.QuoteWebClient;
import com.example.udemy.sfg.sfgstocksreactivemongo.repositories.QuoteRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class QuoteMonitoringService implements ApplicationListener<ContextRefreshedEvent> {

    private final QuoteWebClient quoteWebClient;
    private final QuoteRepository quoteRepository;

    public QuoteMonitoringService(QuoteWebClient quoteWebClient, QuoteRepository quoteRepository) {
        this.quoteWebClient = quoteWebClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        quoteWebClient.getQuoteStream()
                .subscribe(quote -> {
                    System.out.println(quote);
                    quoteRepository.save(quote);
                });
    }
}
