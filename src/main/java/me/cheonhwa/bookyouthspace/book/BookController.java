package me.cheonhwa.bookyouthspace.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @GetMapping("/form")
    public String bookingFormView(Model model){
        //TODO : 선택한 하루 예약 보내기
        model.addAttribute("visitor",new Visitor());
        model.addAttribute("mungongContents",new MunGongContent());
        model.addAttribute("contentNames",MunGongContent.getContentNamesToList());
        model.addAttribute("isOverTime", LocalDateTime.now().getHour()>9);
        return "book/form";
    }
    
    


    @GetMapping("/get-day-booking-status")
    @ResponseBody
    public Object getDayBookingStatus(@RequestParam String date){
        System.out.println(date);
        DayBookingPersonnel dayBookingPersonnel=bookService.getDayBookingPersonnel(date);
        System.out.println(dayBookingPersonnel.isWeekend());
        return dayBookingPersonnel;
    }




    @PostMapping("/submit")
    public String bookSubmit(Visitor visitor){
        //TODO : 해당 타임파트의 예약이 초과했을경우의 @Valid + validation 만들기 및 Errors
        bookService.saveBookingAndVisitor(visitor);
        return "redirect:/book/success";
    }

    @GetMapping("/success")
    public String bookSuccessView(Model model){
        return "book/success";
    }

    @PostMapping("/ajax-date")
    public ResponseEntity postDayBookingStatus(@RequestBody String date){
        System.out.println(date);
        //System.out.println(date.getDayOfWeek());
        return ResponseEntity.ok("haha "+date);
    }



    @GetMapping("/test-ajax")
    public String testAjaxView(){
        return "book/test-ajax";
    }


    @GetMapping("/ajax")
    @ResponseBody
    public Object testAjaxGet(){

        return "send object";
    }

    /*
    @PostMapping("/ajax")
    @ResponseBody
    public ResponseEntity testAjaxPost(@RequestBody String text){
        System.out.println(text);

        return ResponseEntity.ok("okkk");
    }

     */




}
