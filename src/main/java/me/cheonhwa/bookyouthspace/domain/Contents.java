package me.cheonhwa.bookyouthspace.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contents {

    @Id @GeneratedValue
    private Long id;

    private boolean computer;

    private boolean pocketBall;

    private boolean pingPong;

    private boolean boardGame;

    private boolean restArea;

    private boolean photoZone;

    private boolean ps4;

    private boolean arcadeConsole;


}
