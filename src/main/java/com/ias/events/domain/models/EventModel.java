package com.ias.events.domain.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EventModel {
    private String id;
    private String name;
    private String date;
    private String location;
}
