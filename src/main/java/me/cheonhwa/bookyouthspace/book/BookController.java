package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    @GetMapping("/form")
    public String bookingFormView(){
        return "book/form";
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
