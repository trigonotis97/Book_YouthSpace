package me.cheonhwa.bookyouthspace.admin;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService implements UserDetailsService {

    private final  AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Admin admin =adminRepository.findByNickname(nickname);
        if(admin ==null) {
            throw new UsernameNotFoundException(nickname);
        }
        return  new AdminUserAccount(admin);
    }
}
