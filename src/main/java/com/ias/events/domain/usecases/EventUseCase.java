package com.ias.events.domain.usecases;

import com.ias.events.domain.models.EventModel;
import com.ias.events.domain.usecases.repositories.EventUseCaseRepository;
import com.ias.events.infrastructure.drivenadapters.r2dbc.adapter.EventAdapterRepository;
import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import com.ias.events.infrastructure.entrypoints.mappers.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EventUseCase implements EventUseCaseRepository {
    private EventAdapterRepository eventAdapterRepository;
    private EventMapper eventMapper;

    @Override
    public Flux<EventModel> findAllEvents() {
        return eventAdapterRepository.findAllEvents()
                .map(eventMapper::eventEntityToModel);
    }

    @Override
    public Mono<EventModel> findEventById(Integer id) {
        return eventAdapterRepository.findEventById(id)
                .map(eventMapper::eventEntityToModel);
    }

    @Override
    public Mono<EventModel> createEvent(EventModel eventModel) {
        EventEntity entity = eventMapper.eventModelToEntity(eventModel);
        return eventAdapterRepository.createEvent(entity)
                .map(eventMapper::eventEntityToModel);
    }
}
