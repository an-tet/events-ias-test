package com.ias.events.infrastructure.drivenadapters.r2dbc.adapter;

import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventAdapterRepository {
    Flux<EventEntity> findAllEvents();

    Mono<EventEntity> findEventById(Integer id);

    Mono<EventEntity> createEvent(EventEntity eventEntity);
}
