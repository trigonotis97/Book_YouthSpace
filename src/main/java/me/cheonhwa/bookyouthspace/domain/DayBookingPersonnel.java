package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayBookingPersonnel {

    private boolean weekend;

    private int maxPersonnel;

    private List<Integer> personnel;


}
