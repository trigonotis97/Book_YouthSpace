package me.cheonhwa.bookyouthspace.book;


import me.cheonhwa.bookyouthspace.domain.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ContentsRepository extends JpaRepository<Contents, Long> {
}
