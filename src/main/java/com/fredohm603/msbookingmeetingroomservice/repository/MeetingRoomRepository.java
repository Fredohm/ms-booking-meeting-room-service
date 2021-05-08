package com.fredohm603.msbookingmeetingroomservice.repository;

import com.fredohm603.msbookingmeetingroomservice.domain.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

}
