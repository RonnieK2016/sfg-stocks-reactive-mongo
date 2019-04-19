package com.example.udemy.sfg.sfgstocksreactivemongo.repositories;

import com.example.udemy.sfg.sfgstocksreactivemongo.model.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {
}
