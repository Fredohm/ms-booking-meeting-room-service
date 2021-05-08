package com.fredohm603.msbookingmeetingroomservice.sevices;

import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomDto;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomPagedList;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomStyle;
import org.springframework.data.domain.PageRequest;

public interface MeetingRoomService {

    MeetingRoomPagedList listMeetingRooms(String name, MeetingRoomStyle style, Integer capacity, PageRequest pageRequest);

    MeetingRoomDto getById(Long id);

    MeetingRoomDto getByName(String name);

    MeetingRoomDto saveNewMeetingRoom(MeetingRoomDto meetingRoomDto);

    MeetingRoomDto updateMeetingRoom(Long id, MeetingRoomDto meetingRoomDto);

    void deleteMeetingRoom(Long id, MeetingRoomDto meetingRoomDto);
}
