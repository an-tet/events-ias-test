package com.ias.events.domain.usecases.repositories;

import com.ias.events.domain.models.EventModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventUseCaseRepository {
    Flux<EventModel> findAllEvents();

    Mono<EventModel> findEventById(Integer id);

    Mono<EventModel> createEvent(EventModel eventModel);
}
