package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @EqualsAndHashCode(of ="id")
@Builder @NoArgsConstructor  @AllArgsConstructor
public class Admin {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nickname;


    private String password;

}
