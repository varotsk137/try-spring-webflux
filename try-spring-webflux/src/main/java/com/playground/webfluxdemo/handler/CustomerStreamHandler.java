package com.playground.webfluxdemo.handler;

import com.playground.webfluxdemo.dao.CustomerDao;
import com.playground.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> loadCustomersBlocking(ServerRequest serverRequest) {
        Flux<Customer> customerList = dao.getCustomersStream();
        return ServerResponse
                .ok()
                .body(customerList, Customer.class);
    }

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {
        Flux<Customer> customerList = dao.getCustomersStream();
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerList, Customer.class);
    }


}
