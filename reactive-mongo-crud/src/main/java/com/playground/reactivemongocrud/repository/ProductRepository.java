package com.playground.reactivemongocrud.repository;

import com.playground.reactivemongocrud.dto.ProductDto;
import com.playground.reactivemongocrud.model.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<ProductDto> findByPriceBetween(Range<BigDecimal> priceRange);
}
