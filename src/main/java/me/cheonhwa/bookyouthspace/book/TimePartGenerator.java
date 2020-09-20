package me.cheonhwa.bookyouthspace.book;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class TimePartGenerator {

    private LocalDateTime lastGenerateTime;

    public void initTimePartRecord(){
        //2주치 TimePart 미리생성
        lastGenerateTime=LocalDateTime.now();
    }

    //매주 월요일 1시 실행
    @Scheduled(cron = "0 0 1 * * MON")
    private void generateWeekTimePartRecord(){
        //TODO: 이미 생성된 날짜는 중복생성 금지시키기
        lastGenerateTime=LocalDateTime.now();
    }


}
