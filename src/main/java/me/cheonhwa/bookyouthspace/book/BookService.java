package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.DayBookingPersonnel;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final TimePartRepository timePartRepository;
    private final VisitorRepository visitorRepository;

    public DayBookingPersonnel getDayBookingPersonnel(String date) {
        int maxPersonnel;
        boolean isWeekend;
        List<Integer> bookingPersonnelList=new ArrayList<>();

        List<TimePart> dayTimeParts=timePartRepository.findAllByDate(date);

        isWeekend=dayTimeParts.size()==3;
        maxPersonnel=dayTimeParts.get(0).getMaxPersonnel();
        for (int i = 0; i <dayTimeParts.size() ; i++) {
            bookingPersonnelList.add(dayTimeParts.get(i).getVisitors().size());
        }

        return DayBookingPersonnel.builder()
                .weekend(isWeekend)
                .maxPersonnel(maxPersonnel)
                .personnel(bookingPersonnelList)
                .build();
    }

    public void saveBooking(Visitor visitor) {
        //TODO : save visitor
        visitorRepository.save(visitor);

        //TODO : add timepart visitors
        TimePart byDateAndTimePart = timePartRepository.findByDateAndTimePart(visitor.getReservedDate(),visitor.getReservedTimePart());
        byDateAndTimePart.getVisitors().add(visitor);
    }

}
