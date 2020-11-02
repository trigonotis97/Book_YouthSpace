package me.cheonhwa.bookyouthspace.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class BookStatusServiceTest {



    @Test
    void findThisSunday(){
        LocalDate today =LocalDate.parse("2020-10-27"); //이날은 화요일
        LocalDate thisSaturday =LocalDate.parse("2020-10-31"); //이날은 토요일
        LocalDate thisSunday = LocalDate.parse("2020-10-25"); //이날은 이번주 일요일

        LocalDate findDay=today;
       if(today.getDayOfWeek() !=DayOfWeek.SUNDAY){
           findDay=today.minusDays(LocalDate.now().getDayOfWeek().ordinal()+1);
       }
        assertEquals(thisSunday,findDay);
        if(thisSaturday.getDayOfWeek() !=DayOfWeek.SUNDAY){
            findDay=today.minusDays(LocalDate.now().getDayOfWeek().ordinal()+1);
        }
        assertEquals(thisSunday,findDay);
    }

    @Test
    void testPlusWeek(){
        LocalDate date = LocalDate.parse("2020-10-27");
        LocalDate datePlusWeekAndSameWeekDay = LocalDate.parse("2020-11-03");
        assertEquals(date.plusWeeks(1),datePlusWeekAndSameWeekDay);
    }

}