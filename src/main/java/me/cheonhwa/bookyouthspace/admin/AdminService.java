package me.cheonhwa.bookyouthspace.admin;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.Admin;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import me.cheonhwa.bookyouthspace.timepart.DayTimePartRepository;
import me.cheonhwa.bookyouthspace.timepart.TimePartService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService implements UserDetailsService, ApplicationRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    private final TimePartRepository timePartRepository;

    private final TimePartService timePartService;

    private final DayTimePartRepository dayTimePartRepository;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AdminUserAccount(admin);
    }

    //TODO : 테스트용 나중에지우기
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Admin lulu = Admin.builder().password(passwordEncoder.encode("01045057196")).username("룰루").build();
        adminRepository.save(lulu);
    }


    public List<TimePart> getWeekTimePartData(LocalDate date) {
        List<TimePart> timePartList = new ArrayList<>();
        LocalDate dateCounter;

        //timepart
        for (int i = 0; i < 4; i++) {
            dateCounter = timePartService.findThisSunday(date);
            //day
            for (int j = 0; j < 7; j++, dateCounter = dateCounter.plusDays(1)) {
                if (i == 2 && !isWeekend(dateCounter)) {
                    timePartList.add(TimePart.builder()
                            .date(dateCounter)
                            .timePart(i + 1)
                            .visitors(new HashSet<>())
                            .build());
                    continue;
                }

                TimePart timePart = timePartRepository.findByDateAndTimePart(dateCounter, i + 1);
                if (timePart == null) {
                    timePartList.add(TimePart.builder()
                            .date(dateCounter)
                            .timePart(i + 1)
                            .visitors(new HashSet<>())
                            .build());
                    continue;
                }

                timePartList.add(timePart);
            }
        }
        return timePartList;
    }


    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }


//    public List<String> getDateStringList(LocalDate localDate) {
//        List<String> dateList =new ArrayList<>();
//        LocalDate dateCounter=timePartService.findThisSunday(localDate);
//        for (int i = 0; i < 7; i++,dateCounter=dateCounter.plusDays(1)) {
//            String date=dateCounter.getMonth()+"월"
//        }
//        return dateList;
//    }
}
