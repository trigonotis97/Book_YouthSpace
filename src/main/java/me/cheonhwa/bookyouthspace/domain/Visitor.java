package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode ( of="id")
@Builder @AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate reservedDate;
    //희망시간
    private String reservedTime;

    //이용하고싶은것
    private String munGongContent;


    private String reservedContentTitle;


    private LocalDateTime updateReservationDateTime;

}
