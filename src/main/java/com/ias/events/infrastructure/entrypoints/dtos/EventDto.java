package com.ias.events.infrastructure.entrypoints.dtos;

import com.ias.events.application.constants.ErrorMessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static com.ias.events.application.constants.GeneralConstants.DATE_FORMAT_PATTERN;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EventDto {
    private String id;
    @NotNull(message = ErrorMessageConstants.NOT_NULL_NAME)
    @NotBlank(message = ErrorMessageConstants.NOT_BLANK_NAME)
    private String name;
    @NotNull(message = ErrorMessageConstants.NOT_NULL_DATE)
    @NotBlank(message = ErrorMessageConstants.NOT_BLANK_DATE)
    @Pattern(regexp = DATE_FORMAT_PATTERN, message = ErrorMessageConstants.FORMAT_DATE)
    private String date;
    @NotNull(message = ErrorMessageConstants.NOT_NULL_LOCATION)
    @NotBlank(message = ErrorMessageConstants.NOT_BLANK_LOCATION)
    private String location;
}

