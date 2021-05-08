package com.fredohm603.msbookingmeetingroomservice.web.mapper;

import com.fredohm603.msbookingmeetingroomservice.domain.MeetingRoom;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class, MeetingRoomStyleMapper.class})
public interface MeetingRoomMapper {

    @Mapping(target = "style", source = "meetingRoomType")
    MeetingRoomDto meetingRoomToMeetingRoomDto(MeetingRoom meetingRoom);

    @Mapping(target = "meetingRoomType", source = "style")
    MeetingRoom meetingRoomDtoToMeetingRoom(MeetingRoomDto meetingRoomDto);
}
