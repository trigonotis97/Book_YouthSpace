package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.DayBookingPersonnel;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final TimePartRepository timePartRepository;

    public DayBookingPersonnel getDayBookingPersonnel(LocalDate date) {
        int maxPersonnel;
        boolean isWeekend;
        List<Integer> bookingPersonnelList=new ArrayList<>();

        List<TimePart> dayTimeParts=timePartRepository.findAllByDate(date);

        isWeekend=dayTimeParts.size()==4;
        maxPersonnel=dayTimeParts.get(0).getMax();
        for (int i = 0; i <dayTimeParts.size() ; i++) {
            bookingPersonnelList.add(dayTimeParts.get(i).getVisitors().size());
        }

        return DayBookingPersonnel.builder()
                .isWeekend(isWeekend)
                .maxPersonnel(maxPersonnel)
                .personnel(bookingPersonnelList)
                .build();
    }
}
