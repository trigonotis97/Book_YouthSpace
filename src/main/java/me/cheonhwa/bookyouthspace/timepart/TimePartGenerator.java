package me.cheonhwa.bookyouthspace.timepart;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.SystemData;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Component
@Transactional
@RequiredArgsConstructor
public class TimePartGenerator implements ApplicationRunner {

    private LocalDateTime lastGenerateTime;
    private final TimePartRepository timePartRepository;

    private final DayTimePartRepository dayTimePartRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("💙 ApplicationRunner is now Driven");
        System.out.println("💙 generateTimePartRecord");
        generateTimePartRecord();

    }

    //매주 월요일 1시 실행
    @Scheduled(cron = "0 0 1 * * MON")
    public void generateTimePartRecord(){
        //TODO: 2주치 TimePart 미리생성
        //TODO: 이미 생성된 날짜는 중복생성 금지시키기

        Optional<TimePart> lastUpdateTimePart = timePartRepository.findById(timePartRepository.count());
        LocalDate countDate;
        int counter;

        //만들어진 레코드가 없는경우
        if(!lastUpdateTimePart.isPresent()) {
            countDate= LocalDate.now();
            counter=0;
        }
        //이미 만들어진 레코드가 있는경우
        else {
            //LocalDate lastTimePartDate=LocalDate.parse(lastUpdateTimePart.get().getDate(), DateTimeFormatter.ISO_DATE);
            LocalDate lastTimePartDate=lastUpdateTimePart.orElseThrow().getDate();
            counter= (int)ChronoUnit.DAYS.between(LocalDate.now(),lastTimePartDate);
            System.out.println("날짜 차이 : "+ counter);
            countDate=lastTimePartDate.plusDays(1); counter++;
            System.out.println("시작 날짜: "+ countDate);
        }


        //해당일부터 2주치 생성
        for (; counter <14; counter++, countDate=countDate.plusDays(1)) {
            int timePartCounter=0;

            //월요일은 제외
            if(countDate.getDayOfWeek()== DayOfWeek.MONDAY) {
                continue;
            }
            //주말
            else if(countDate.getDayOfWeek()== DayOfWeek.SUNDAY ||  countDate.getDayOfWeek()== DayOfWeek.SATURDAY){
                timePartCounter=3;
            }
            //평일
            else {
                timePartCounter = 4;
            }


            for (int j = 1; j <= timePartCounter; j++) {
                TimePart currentTimePart = TimePart.builder()
                        .date(countDate)
                        .timePart(j)
                        .personnel(0)
                        .build();
                timePartRepository.save(currentTimePart);

            }
            List<TimePart> currentTimePartList= timePartRepository.findAllByDate(countDate);
            DayTimePart currentDayTimePart = DayTimePart.builder()
                    .date(countDate)
                    .maxPersonnel(SystemData.MAXIMUM_BOOKING_NUMBER)
                    .timePartList(currentTimePartList)
                    .weekend(timePartCounter ==3)
                    .build();
            dayTimePartRepository.save(currentDayTimePart);
            System.out.println(counter+"회차 "+"레코드 기록 날짜 : " + countDate);

        }



        lastGenerateTime=LocalDateTime.now();

        System.out.println(" Init TimePart Record ( 2 week ) ");
    }

    public LocalDateTime getLastGenerateTime() {
        return lastGenerateTime;
    }
    /*
    @Scheduled(cron = "* * * * * *")
    private void sampletestGenerateTimePart(){
        System.out.println("Generator is Running ... : " + LocalDateTime.now());
    }
     */


}
