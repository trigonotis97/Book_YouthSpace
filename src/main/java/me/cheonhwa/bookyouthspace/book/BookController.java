package me.cheonhwa.bookyouthspace.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @GetMapping("/form")
    public String bookingFormView(Model model){
        //TODO : 선택한 하루 예약 보내기



        return "book/form";
    }

    @GetMapping("/test-ajax")
    public String testAjaxView(){
        return "book/test-ajax";
    }

    @PostMapping("/ajax")
    @ResponseBody
    public ResponseEntity testAjaxPost(@RequestBody String text){
        System.out.println(text);

        return ResponseEntity.ok("okkk");
    }




    @PostMapping("/submit")
    public String bookSubmit(){

        return "redirect:/book/success";
    }

    @GetMapping("/success")
    public String bookSuccessView(Model model){
        return "book/success";
    }
}
