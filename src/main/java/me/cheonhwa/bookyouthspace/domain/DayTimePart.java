package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayTimePart {

    private LocalDate date;

    private boolean weekend;

    private int maxPersonnel;

    private List<Integer> personnel = new ArrayList<>();

    //관리자 페이지에서 사용?
    private List<TimePart> timePartList = new ArrayList<>();


}
