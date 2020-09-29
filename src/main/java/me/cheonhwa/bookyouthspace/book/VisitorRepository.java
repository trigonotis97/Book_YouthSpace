package me.cheonhwa.bookyouthspace.book;

import me.cheonhwa.bookyouthspace.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly =true)
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
}
