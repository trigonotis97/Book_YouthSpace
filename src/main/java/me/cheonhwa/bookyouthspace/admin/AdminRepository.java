package me.cheonhwa.bookyouthspace.admin;


import me.cheonhwa.bookyouthspace.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AdminRepository  extends JpaRepository <Admin ,Long> {
    Admin findByUsername(String nickname);
}
