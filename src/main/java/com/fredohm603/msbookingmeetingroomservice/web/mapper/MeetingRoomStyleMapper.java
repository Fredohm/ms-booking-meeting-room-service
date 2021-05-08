package com.fredohm603.msbookingmeetingroomservice.web.mapper;

import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomStyle;
import org.springframework.stereotype.Component;

@Component
public class MeetingRoomStyleMapper {

    public String asString(MeetingRoomStyle style) {
        return style.name();
    }

    public MeetingRoomStyle asEnum(String style) {
        if (style.toUpperCase().equals("BUREAU")) {
            return MeetingRoomStyle.BUREAU;
        } else if (style.toUpperCase().equals("SALLE")) {
            return MeetingRoomStyle.SALLE;
        } else {
            return null;
        }
    }
}
