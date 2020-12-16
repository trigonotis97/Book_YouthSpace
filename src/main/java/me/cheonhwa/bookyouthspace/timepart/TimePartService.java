package me.cheonhwa.bookyouthspace.timepart;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TimePartService {
    private final TimePartRepository timePartRepository;
    private final DayTimePartRepository dayTimePartRepository;

    private static List<String> dayOfTwoWeek = new ArrayList<>();

    static {
        for (int i = 0; i < 2; i++) {
            dayOfTwoWeek.add("일");
            dayOfTwoWeek.add("월");
            dayOfTwoWeek.add("화");
            dayOfTwoWeek.add("수");
            dayOfTwoWeek.add("목");
            dayOfTwoWeek.add("금");
            dayOfTwoWeek.add("토");
        }
    }

    public List<String> getDayOfTwoWeekStringList() {
        return dayOfTwoWeek;
    }


    //TODO :  personnel db캐싱하기.
    //2주치 리스트에 1주분량(최대예약기간만 나가야한다.)
    public List<DayTimePart> getWeekDayTimePart() {
        List<DayTimePart> dayTimePartList = new ArrayList<>();




        LocalDate dateCounter = findThisSunday();
        LocalDate end2week=dateCounter.plusWeeks(2);
        for (; dateCounter.isBefore(end2week); dateCounter=dateCounter.plusDays(1)) {
            DayTimePart dayTimePart=new DayTimePart();

            //


//            List<Integer> personnel=new ArrayList<>();
            //오늘 이전 || 7일이후 || 월요일(휴관일)제외
            if(dateCounter.isBefore(LocalDate.now()) || dateCounter.isAfter(LocalDate.now().plusWeeks(1).minusDays(1))
            || dateCounter.getDayOfWeek() ==DayOfWeek.MONDAY){
                dayTimePart.setDate(dateCounter);
                dayTimePart.setWeekend(dateCounter.getDayOfWeek() == DayOfWeek.SUNDAY || dateCounter.getDayOfWeek() == DayOfWeek.SATURDAY);
//                for (int j = 0; j < (dayTimePart.isWeekend() ? 3 : 4); j++) {
//                    personnel.add(0);
//                }
            }
            //실제 예약데이터기간
            else {
                //최대예약인원
                dayTimePart = dayTimePartRepository.findByDate(dateCounter);
                //혅재예약인원
//                List<TimePart>  timePartList =timePartRepository.findAllByDate(dateCounter);
//                for (int j = 0; j < (dayTimePart.isWeekend() ? 3 : 4); j++) {
//                    personnel.add(timePartList.get(j).getVisitors().size());
//                    //TODO : 쿼리 줄이기- 연관관계 개수 받아올때 줄이기
//                }
            }
//            dayTimePart.setPersonnel(personnel);

            dayTimePartList.add(dayTimePart);
        }
        //TODO : 관리자 선택 데이 제외 등등 커스텀

        return dayTimePartList;
    }



    private LocalDate findThisSunday() {
        LocalDate thisSunday;
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            thisSunday = LocalDate.now();
        } else {
            thisSunday = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().ordinal() + 1);
        }
        return thisSunday;
    }

//
//    public List<DayTimePart> getWeekBookingDataForAdmin() {
//
//    }
}
