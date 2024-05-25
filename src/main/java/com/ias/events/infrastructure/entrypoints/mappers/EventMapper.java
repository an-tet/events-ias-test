package com.ias.events.infrastructure.entrypoints.mappers;

import com.ias.events.domain.models.EventModel;
import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import com.ias.events.infrastructure.entrypoints.dtos.EventDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto eventModelToDto(EventModel model);

    EventModel eventEntityToModel(EventEntity entity);

    EventEntity eventModelToEntity(EventModel model);

    EventModel eventDtoToModel(EventDto dto);
}
