package me.cheonhwa.bookyouthspace.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@NoArgsConstructor
public class SystemData {

    //한 timepart 당 최대 예약 가능 인원
    private   int maximumBookingNumber =10;
    //최대 예약 오픈 기간
    private   int maximumBookingOpenPeriod=7;

    private  String firstPartTime;
    private  String secondPartTime;
    private  String thirdPartTime;
    private  String fourthPartTime;

      {
        firstPartTime="1타임 (오전10:00 ~ 12:00)";
        secondPartTime="2타임 (낮12:30 ~ 낮2:30)";
        thirdPartTime="3타임 (오후3:00 ~ 5:00)";
        fourthPartTime="4타임 (오후5:30 ~ 7:30)";
    }

}
