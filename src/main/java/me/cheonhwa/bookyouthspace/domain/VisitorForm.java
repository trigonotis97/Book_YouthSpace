package me.cheonhwa.bookyouthspace.domain;


import lombok.*;

import java.time.LocalDate;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitorForm {

    private Long id;


    private String name;


    private String phoneNumber;


    private String password;


    private int age;


    private Gender gender;

    //날짜

    private String reservedDate;

    //희망시간

    private int reservedTimePart;

    //이용하고싶은것

    private Contents contentsToUse=new Contents();

    //최종예약수정시간

    private String reservationUpdateDateTime;

}
