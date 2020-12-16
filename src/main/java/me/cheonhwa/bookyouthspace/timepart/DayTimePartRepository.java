package me.cheonhwa.bookyouthspace.timepart;

import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional(readOnly =true)
public interface DayTimePartRepository extends JpaRepository <DayTimePart ,Long> {
    DayTimePart findByDate(LocalDate date);
}
