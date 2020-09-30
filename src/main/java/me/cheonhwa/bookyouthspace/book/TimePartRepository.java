package me.cheonhwa.bookyouthspace.book;


import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Transactional(readOnly =true)
public interface TimePartRepository extends JpaRepository<TimePart,Long> {

    List<TimePart> findAllByDate(String date);

    TimePart findByDateAndTimePart(String reservedDate, int reservedTimePart);

    int countByDateAndTimePart(String reservedDate, int reservedTimePart);

    List<TimePart> findAllByDateAndTimePart(String reservedDate, int reservedTimePart);
}
