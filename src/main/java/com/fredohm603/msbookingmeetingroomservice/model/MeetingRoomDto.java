package com.fredohm603.msbookingmeetingroomservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomDto implements Serializable {

    static final long serialVersionUID = 1032394573922184655L;

    @Null
    private Long id;

    @Null
    private Long version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String name;

    @NotNull
    private MeetingRoomStyle style;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Min(2)
    private Integer capacity;
}
