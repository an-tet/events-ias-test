package com.ias.events.infrastructure.drivenadapters.r2dbc.repositories;

import com.ias.events.infrastructure.drivenadapters.r2dbc.entities.EventEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R2DBCRepository extends ReactiveCrudRepository<EventEntity, Integer> {
}
