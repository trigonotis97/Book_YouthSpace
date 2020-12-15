package me.cheonhwa.bookyouthspace.admin;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.Admin;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService implements UserDetailsService, ApplicationRunner {

    private final  AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    private final TimePartRepository timePartRepository;


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

    public List<DayTimePart> getFirstWeekBookingData() {
        List<DayTimePart> weekDayTimePart =new ArrayList<>();


        return weekDayTimePart;
    }
    private boolean isWeekend(LocalDate date){
        return date.getDayOfWeek()==DayOfWeek.SUNDAY || date.getDayOfWeek()== DayOfWeek.SATURDAY;
    }

    private List<DayTimePart> getWeekDayTimePart(int week){
        List<DayReservation> weekTimePart =new ArrayList<>();
        for (int i = week==1? 0:7; i < (week==1? 7 : 14); i++) {
            DayReservation dayReservation=new DayReservation();
            List<TimePart> timePartList =new ArrayList<>();
            LocalDate date = LocalDate.now().plusDays(i);
            int timePartLength =isWeekend(date)? 3:4;

            for (int j = 1; j <= timePartLength; j++) {
                timePartList.add(timePartRepository.findByDateAndTimePart(date,j));
            }
            dayReservation.setTimePartList(timePartList);
            weekTimePart.add(dayReservation);
        }
        return weekTimePart;
    }


    public List<DayTimePart> getWeekBookingData() {
        List<DayTimePart> dayTimePartList= new ArrayList<>();
        return  dayTimePartList;
    }
}
