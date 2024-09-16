package com.ias.events.infrastructure.entrypoints.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EventRest {
    public Mono<ServerResponse> findAllEvents() {
        return Mono.empty();
    }
}
