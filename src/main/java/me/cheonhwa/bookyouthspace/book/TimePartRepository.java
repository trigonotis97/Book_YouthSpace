package me.cheonhwa.bookyouthspace.book;


import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.hibernate.type.EntityType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FetchType;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Transactional(readOnly =true)
public interface TimePartRepository extends JpaRepository<TimePart,Long> {

    List<TimePart> findAllByDate(LocalDate date);

    @EntityGraph(attributePaths = {"visitors"}, type = EntityGraph.EntityGraphType.LOAD)
    TimePart findByDateAndTimePart(LocalDate reservedDate, int reservedTimePart);


    int countByDateAndTimePart(LocalDate reservedDate, int reservedTimePart);


}
