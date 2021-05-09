package com.fredohm603.msbookingmeetingroomservice.sevices;

import com.fredohm603.msbookingmeetingroomservice.domain.MeetingRoom;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomDto;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomPagedList;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomStyle;
import com.fredohm603.msbookingmeetingroomservice.repository.MeetingRoomRepository;
import com.fredohm603.msbookingmeetingroomservice.web.controller.exceptions.NotFoundException;
import com.fredohm603.msbookingmeetingroomservice.web.mapper.MeetingRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;
    private final MeetingRoomMapper meetingRoomMapper;


    @Override
    public MeetingRoomPagedList listMeetingRooms(String name, MeetingRoomStyle style, Integer capacity, PageRequest pageRequest) {
        MeetingRoomPagedList meetingRoomPagedList;
        Page<MeetingRoom> meetingRoomPage;

        meetingRoomPage = meetingRoomRepository.findAll(pageRequest);

        meetingRoomPagedList = new MeetingRoomPagedList(meetingRoomPage
            .getContent()
            .stream()
            .map(meetingRoomMapper::meetingRoomToMeetingRoomDto)
            .collect(Collectors.toList()),
        PageRequest.of(meetingRoomPage.getPageable().getPageNumber(),
                meetingRoomPage.getPageable().getPageSize()),
        meetingRoomPage.getTotalElements());

        return meetingRoomPagedList;
    }

    @Override
    public MeetingRoomDto getById(Long id) {
        return meetingRoomMapper.meetingRoomToMeetingRoomDto(
                meetingRoomRepository.findById(id).orElseThrow(NotFoundException::new));

    }

    @Override
    public MeetingRoomDto getByName(String name) {
        return null;
    }

    @Override
    public MeetingRoomDto saveNewMeetingRoom(MeetingRoomDto meetingRoomDto) {
        return meetingRoomMapper.meetingRoomToMeetingRoomDto(
                meetingRoomRepository.save(
                        meetingRoomMapper.meetingRoomDtoToMeetingRoom(meetingRoomDto)));
    }

    @Override
    public MeetingRoomDto updateMeetingRoom(Long id, MeetingRoomDto meetingRoomDto) {
        return null;
    }

    @Override
    public void deleteMeetingRoom(Long id, MeetingRoomDto meetingRoomDto) {

    }
}
