package me.cheonhwa.bookyouthspace.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode( of="id")
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Visitor {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //날짜
    @Column(nullable = false)
    private LocalDate reservedDate;

    //희망시간
    @Column(nullable = false)
    private int reservedTimePart;

    //이용하고싶은것

    private String munGongContent;

    //최종예약수정시간
    @Column(nullable = false)
    private LocalDateTime reservationUpdateDateTime;

}
