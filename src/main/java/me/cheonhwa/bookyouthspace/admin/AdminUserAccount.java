package me.cheonhwa.bookyouthspace.admin;

import me.cheonhwa.bookyouthspace.domain.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class AdminUserAccount extends User {

    private Admin admin;

    public AdminUserAccount(Admin admin) {
        super(admin.getNickname(), admin.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        this.admin = admin;
    }
}
