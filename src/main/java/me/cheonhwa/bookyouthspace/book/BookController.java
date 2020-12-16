package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.MunGongContent;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import me.cheonhwa.bookyouthspace.domain.VisitorForm;
import me.cheonhwa.bookyouthspace.timepart.DayTimePartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final DayTimePartRepository dayTimePartRepository;


    @GetMapping("/form")
    public String bookingFormView(Model model){
        //TODO : 선택한 하루 예약 보내기
        model.addAttribute("visitor",new VisitorForm());
        model.addAttribute("mungongContents",new MunGongContent());
        model.addAttribute("contentNames",MunGongContent.getContentNamesToList());
        model.addAttribute("isOverTime", LocalDateTime.now().getHour()>9);
        return "book/form";
    }
    
    


    @GetMapping("/get-day-booking-status")
    @ResponseBody
    public Object getDayBookingStatus(@RequestParam String date){
        System.out.println(date);
        DayTimePart dayTimePart =bookService.getDayTimePart(date);
        System.out.println(dayTimePart.isWeekend());
        return dayTimePart;
    }




    @PostMapping("/submit")
    public String bookSubmit(VisitorForm visitorForm){
        //TODO : 해당 타임파트의 예약이 초과했을경우의 @Valid + validation 만들기 및 Errors

        Visitor newVisitor = bookService.mappingVisitorForm(visitorForm);
        bookService.saveBookingAndVisitor(newVisitor);
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
