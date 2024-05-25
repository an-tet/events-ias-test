package com.ias.events.infrastructure.drivenadapters.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "event")
public class EventEntity {
    @Id
    private Integer id;
    private String name;
    private String date;
    private String location;
}

