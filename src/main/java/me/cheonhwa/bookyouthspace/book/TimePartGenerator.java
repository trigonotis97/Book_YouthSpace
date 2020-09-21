package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
@Transactional
@RequiredArgsConstructor
public class TimePartGenerator implements ApplicationRunner {

    private LocalDateTime lastGenerateTime;
    private final TimePartRepository timePartRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner is now Driven");
        TimePart currentTimePart = new TimePart().builder().date(LocalDate.now()).timePart(1).max(10).build();
        timePartRepository.save(currentTimePart);
    }

    public void initTimePartRecord(){
        //TODO: 2주치 TimePart 미리생성
        //TODO: 이미 생성된 날짜는 중복생성 금지시키기

        Optional<TimePart> lastUpdateTimePart = timePartRepository.findById(timePartRepository.count());
        if(!lastUpdateTimePart.isPresent()){
            LocalDate countDate=LocalDate.now();
            for (int i = 0; i <14 ; i++ ) {
                if(countDate.getDayOfWeek()== DayOfWeek.MONDAY)
                    continue;
                else if(countDate.getDayOfWeek()== DayOfWeek.SUNDAY ||  countDate.getDayOfWeek()== DayOfWeek.SATURDAY) {

                }
                else {

                }

            }
        }
        else

        lastGenerateTime=LocalDateTime.now();
        System.out.println(" Init TimePart Record ( 2 week ) ");
    }

    //매주 월요일 1시 실행
    @Scheduled(cron = "0 0 1 * * MON")
    protected void generateWeekTimePartRecord(){
        //TODO: 이미 생성된 날짜는 중복생성 금지시키기
        lastGenerateTime=LocalDateTime.now();
        System.out.println("generated Week TimePart. now Time is : " + lastGenerateTime);
    }

    /*
    @Scheduled(cron = "* * * * * *")
    private void sampletestGenerateTimePart(){
        System.out.println("Generator is Running ... : " + LocalDateTime.now());
    }
     */


}
