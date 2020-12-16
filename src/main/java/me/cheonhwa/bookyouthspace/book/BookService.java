package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.*;
import me.cheonhwa.bookyouthspace.timepart.DayTimePartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final TimePartRepository timePartRepository;
    private final VisitorRepository visitorRepository;
    private final ContentsRepository contentsRepository;


    private final DayTimePartRepository dayTimePartRepository;
    private final ModelMapper modelMapper;




    public void saveBookingAndVisitor(Visitor visitor) {

        contentsRepository.save(visitor.getContentsToUse());

        visitor.setReservationUpdateDateTime(LocalDateTime.now().toString());
        visitorRepository.save(visitor);
        System.out.println(visitor.toString());
        //TODO : add timepart visitors
        TimePart byDateAndTimePart = timePartRepository.findByDateAndTimePart(visitor.getReservedDate(),visitor.getReservedTimePart());
        byDateAndTimePart.addVisitor(visitor);
    }


    public Visitor mappingVisitorForm(VisitorForm visitorForm) {
        Visitor newVisitor =new Visitor();
        modelMapper.map(visitorForm,newVisitor);
        return newVisitor;
    }

    public DayTimePart getDayTimePart(String date) {
        return dayTimePartRepository.findByDate(LocalDate.parse(date));
    }
}
