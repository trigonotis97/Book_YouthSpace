package me.cheonhwa.bookyouthspace.book;

import me.cheonhwa.bookyouthspace.domain.Gender;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    TimePartRepository timePartRepository;

    @Autowired
    VisitorRepository visitorRepository;




    private Visitor testVisitor = Visitor.builder()
            .age(25)
            .gender(Gender.FEMALE)
            .name("김천화")
            .reservedDate(LocalDate.now().toString())
            .reservedTimePart(3)
            .build();

    @BeforeEach
    void beforeEach(){

    }

    @Test
    @DisplayName("TimePart DB 에 visitor 저장하고 확인")
    void saveVisitorToTimePartRepo() throws Exception {
        //timePartRepository.findByDateAndTimePart(testVisitor.getReservedDate(),testVisitor.getReservedTimePart());
        int count=timePartRepository.countByDateAndTimePart(testVisitor.getReservedDate(),testVisitor.getReservedTimePart());
        List<TimePart> timePartList=timePartRepository.findAllByDateAndTimePart(testVisitor.getReservedDate(),testVisitor.getReservedTimePart());
        assertEquals(count,1);
    }

}