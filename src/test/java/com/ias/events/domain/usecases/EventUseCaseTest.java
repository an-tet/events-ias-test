package com.ias.events.domain.usecases;

import com.ias.events.domain.models.EventModel;
import com.ias.events.infrastructure.drivenadapters.r2dbc.adapter.EventAdapterRepository;
import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import com.ias.events.infrastructure.entrypoints.mappers.EventMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventUseCaseTest {
    @Mock
    private EventAdapterRepository eventAdapterRepositoryMock;

    @Mock
    private EventMapper eventMapperMock;

    @InjectMocks
    private EventUseCase eventUseCase;

    @BeforeAll
    public static void setUp() {
    }

    @Test
    public void shouldFindAllEvents() {
        var mock = EventEntity.builder()
                .id(1)
                .build();

        when(eventAdapterRepositoryMock.findAllEvents())
                .thenReturn(Flux.just(mock));
        when(eventMapperMock.eventEntityToModel(any()))
                .thenReturn(EventModel.builder().id("1").build());

        StepVerifier.create(eventUseCase.findAllEvents())
                .assertNext(eventModel -> {
                    assertEquals(mock.getId().toString(), eventModel.getId());
                })
                .verifyComplete();
    }
}