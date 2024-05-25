package com.ias.events.infrastructure.entrypoints.controllers;

import com.ias.events.application.constants.ErrorMessageConstants;
import com.ias.events.application.constants.RoutesConstants;
import com.ias.events.domain.models.EventModel;
import com.ias.events.domain.usecases.repositories.EventUseCaseRepository;
import com.ias.events.infrastructure.entrypoints.dtos.EventDto;
import com.ias.events.infrastructure.entrypoints.mappers.EventMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(RoutesConstants.EVENT_PATH)
public class EventController {
    private EventMapper eventMapper;
    private EventUseCaseRepository useCaseRepository;

    @GetMapping()
    public Mono<List<EventDto>> findAllEvents() {
        return useCaseRepository.findAllEvents()
                .map(eventMapper::eventModelToDto)
                .collectList();
    }

    @GetMapping("/{id}")
    public Mono<EventDto> findEventById(
            @PathVariable(name = "id") @Positive(message = ErrorMessageConstants.POSITIVE_NUMBER) Integer id
    ) {
        return useCaseRepository.findEventById(id)
                .map(eventMapper::eventModelToDto);
    }

    @PostMapping()
    public Mono<EventDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        EventModel model = eventMapper.eventDtoToModel(eventDto);
        return useCaseRepository.createEvent(model)
                .map(eventMapper::eventModelToDto);
    }
}
