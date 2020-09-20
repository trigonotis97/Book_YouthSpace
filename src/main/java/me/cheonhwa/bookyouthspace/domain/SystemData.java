package me.cheonhwa.bookyouthspace.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class SystemData {

    //한 timepart 당 최대 예약 가능 인원
    public static int MAXIMUM_BOOKING_NUMBER=10;
    //최대 예약 오픈 기간
    public static int MAXIMUM_BOOKING_OPEN_PERIOD=7;


}
