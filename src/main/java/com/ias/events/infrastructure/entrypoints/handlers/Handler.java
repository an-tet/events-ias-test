package com.ias.events.infrastructure.entrypoints.handlers;

import com.ias.events.infrastructure.entrypoints.rest.EventRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Handler {
    public final EventRest eventRest;
}
