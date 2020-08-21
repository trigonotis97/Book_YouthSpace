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
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SexType sex;

    private String reservedContentTitle;

    private LocalDate reservedDate;

    private String reservedTime;

    private LocalDateTime updateReservationDateTime;
}
