package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder @Getter @Setter @EqualsAndHashCode(of="id")
@AllArgsConstructor @NoArgsConstructor
public class TimePart {

    @Id
    @GeneratedValue
    private Long id;

    //예약 날짜
    @Column(nullable = false)
    private LocalDate reservedDate;

    //희망시간(타임파트 1~4)
    @Column(nullable = false)
    private int reservedTimePart;

    //최대예약인원
    private int max;

    @OneToMany
    private Set<Visitor> visitors = new HashSet<>();

}
