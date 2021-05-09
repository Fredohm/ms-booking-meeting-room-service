package com.fredohm603.msbookingmeetingroomservice.web.controller.v1;

import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomDto;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomPagedList;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomStyle;
import com.fredohm603.msbookingmeetingroomservice.sevices.MeetingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MeetingRoomController {

    public static final Integer DEFAULT_PAGE_NUMBER = 0;
    public static final Integer DEFAULT_PAGE_SIZE = 25;

    private final MeetingRoomService meetingRoomService;

    @GetMapping(produces = {"application/json"}, path = "/meeting-room")
    public ResponseEntity<MeetingRoomPagedList> listMeetingRooms(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "meetingRoomType", required = false) MeetingRoomStyle style,
            @RequestParam(value = "capacity", required = false) Integer capacity) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        MeetingRoomPagedList pagedList = meetingRoomService.listMeetingRooms(name, style, capacity, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(pagedList, HttpStatus.OK);
    }

    @GetMapping("/meeting-room/{id}")
    public ResponseEntity<MeetingRoomDto> getMeetingRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(meetingRoomService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/meeting-room")
    public ResponseEntity<MeetingRoomDto> addMeetingRoom(@Validated @RequestBody MeetingRoomDto dto) {
        return new ResponseEntity<>(meetingRoomService.saveNewMeetingRoom(dto), HttpStatus.CREATED);
    }
}
