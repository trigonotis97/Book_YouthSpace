package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayTimePart {

    @Id @GeneratedValue
    private Long id;

    private LocalDate date;

    private boolean weekend;

    private int maxPersonnel;

    @OneToMany
    private List<TimePart> timePartList =new ArrayList<>();


}
