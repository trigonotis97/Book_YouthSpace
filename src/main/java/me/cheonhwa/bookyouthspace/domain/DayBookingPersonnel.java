package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayBookingPersonnel {
    boolean isWeekend;

    int maxPersonnel;

    List<Integer> personnel;


}
