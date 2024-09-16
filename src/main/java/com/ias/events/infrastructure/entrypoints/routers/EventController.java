package com.ias.events.infrastructure.entrypoints.routers;

import com.ias.events.application.constants.ErrorMessageConstants;
import com.ias.events.domain.models.EventModel;
import com.ias.events.domain.usecases.repositories.EventUseCaseRepository;
import com.ias.events.infrastructure.entrypoints.dtos.EventDto;
import com.ias.events.infrastructure.entrypoints.handlers.Handler;
import com.ias.events.infrastructure.entrypoints.mappers.EventMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.ias.events.application.constants.RoutesConstants.EVENT_PATH;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EventController {
    private EventMapper eventMapper;
    private EventUseCaseRepository useCaseRepository;

    @Bean
    public Mono<ServerResponse> routerFunction(Handler handler) {
        return route()
                .GET(EVENT_PATH, handler.eventRest::findAllEvents)
                .build();

        useCaseRepository.findAllEvents()
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
