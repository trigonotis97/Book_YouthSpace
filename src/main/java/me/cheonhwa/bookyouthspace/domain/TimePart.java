package me.cheonhwa.bookyouthspace.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder @Getter @Setter @EqualsAndHashCode(of="id")
@AllArgsConstructor @NoArgsConstructor


//TODO : 제약조건 확인
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"date","timePart"})})
public class TimePart {

    @Id
    @GeneratedValue
    private Long id;

    //날짜
    @Column(nullable = false)

    private LocalDate date;

    //희망시간(타임파트 1~4)
    @Column(nullable = false)
    private int timePart;

    //TODO: 상위 엔티티로 빼내기
    //최대예약인원
//    private int maxPersonnel;
    private int personnel;
    @OneToMany
    private Set<Visitor> visitors = new HashSet<>();

    public void addVisitor(Visitor  visitor){
        this.visitors.add(visitor);
        this.personnel++;
    }

}
