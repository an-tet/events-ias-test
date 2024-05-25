package com.ias.events.infrastructure.drivenadapters.r2dbc.adapter;

import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import com.ias.events.infrastructure.drivenadapters.r2dbc.repositories.R2DBCRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EventAdapter implements EventAdapterRepository {
    private R2DBCRepository repository;

    //TODO: implement error handler and unit test
    @Override
    public Flux<EventEntity> findAllEvents() {
        return repository.findAll();
    }

    @Override
    public Mono<EventEntity> findEventById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Mono<EventEntity> createEvent(EventEntity eventEntity) {
        return repository.save(eventEntity);
    }
}
