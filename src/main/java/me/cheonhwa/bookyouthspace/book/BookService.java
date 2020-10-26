package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final TimePartRepository timePartRepository;
    private final VisitorRepository visitorRepository;
    private final ContentsRepository contentsRepository;

    private final ModelMapper modelMapper;

    public DayBookingPersonnel getDayBookingPersonnel(String date) {
        int maxPersonnel;
        boolean isWeekend;
        LocalDate localDate = LocalDate.parse(date);
        List<Integer> bookingPersonnelList=new ArrayList<>();
        List<TimePart> dayTimeParts=timePartRepository.findAllByDate(localDate);

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


    public void saveBookingAndVisitor(Visitor visitor) {

        contentsRepository.save(visitor.getContentsToUse());

        visitor.setReservationUpdateDateTime(LocalDateTime.now().toString());
        visitorRepository.save(visitor);
        System.out.println(visitor.toString());
        //TODO : add timepart visitors
        TimePart byDateAndTimePart = timePartRepository.findByDateAndTimePart(visitor.getReservedDate(),visitor.getReservedTimePart());
        byDateAndTimePart.getVisitors().add(visitor);
    }


    public Visitor mappingVisitorForm(VisitorForm visitorForm) {
        Visitor newVisitor =new Visitor();
        modelMapper.map(visitorForm,newVisitor);
        return newVisitor;
    }
}
