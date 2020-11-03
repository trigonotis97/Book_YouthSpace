package me.cheonhwa.bookyouthspace.admin;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.Admin;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService implements UserDetailsService, ApplicationRunner {

    private final  AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin =adminRepository.findByUsername(username);
        if(admin ==null) {
            throw new UsernameNotFoundException(username);
        }
        return  new AdminUserAccount(admin);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Admin lulu= Admin.builder().password(passwordEncoder.encode("01045057196")).username("룰루").build();
        adminRepository.save(lulu);
    }
}
