package com.fredohm603.msbookingmeetingroomservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class MeetingRoomPagedList extends PageImpl<MeetingRoomDto> implements Serializable {

    static final long serialVersionUID = 1032394573922184655L;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MeetingRoomPagedList(
            @JsonProperty("content")List<MeetingRoomDto> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("pageable") JsonNode pageable,
            @JsonProperty("last") boolean last,
            @JsonProperty("totalPages") int totalPages,
            @JsonProperty("first") boolean first,
            @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }

    public MeetingRoomPagedList(List<MeetingRoomDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public MeetingRoomPagedList(List<MeetingRoomDto> content) {
        super(content);
    }
}

