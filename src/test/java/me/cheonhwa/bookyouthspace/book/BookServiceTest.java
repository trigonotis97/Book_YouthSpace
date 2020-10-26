package me.cheonhwa.bookyouthspace.book;

import me.cheonhwa.bookyouthspace.domain.Gender;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import me.cheonhwa.bookyouthspace.domain.VisitorForm;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class BookServiceTest {

    @Autowired
    ModelMapper modelMapper;



    @Test
    void testTypemap() throws Exception{

        Visitor newVisitor =new Visitor();
        VisitorForm visitorForm=VisitorForm.builder().age(23).name("김천화").gender(Gender.FEMALE).reservedDate("2020-10-26").password("pass").build();
        modelMapper.map(visitorForm,newVisitor);
        assertEquals(newVisitor.getReservedDate(), LocalDate.now());
        assertEquals(newVisitor.getAge(), 23);

    }

}