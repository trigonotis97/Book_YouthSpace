package me.cheonhwa.bookyouthspace.book;


import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly =true)
public interface TimePartRepository extends JpaRepository<TimePart,Long> {

}
