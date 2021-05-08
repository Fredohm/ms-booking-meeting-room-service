package com.fredohm603.msbookingmeetingroomservice.bootstrap;

import com.fredohm603.msbookingmeetingroomservice.domain.MeetingRoom;
import com.fredohm603.msbookingmeetingroomservice.model.MeetingRoomStyle;
import com.fredohm603.msbookingmeetingroomservice.repository.MeetingRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class MeetingRoomBootstrap implements CommandLineRunner {

    private final MeetingRoomRepository meetingRoomRepository;

    @Override
    public void run(String... args) throws Exception {
        if (meetingRoomRepository.count() == 0) {
            loadMeetingRooms();
        }
    }

    private void loadMeetingRooms() {

        MeetingRoom m1 = MeetingRoom.builder()
                .name("Salle 1")
                .meetingRoomType(MeetingRoomStyle.SALLE.toString())
                .capacity(12)
                .build();

        meetingRoomRepository.save(m1);
    }
}
