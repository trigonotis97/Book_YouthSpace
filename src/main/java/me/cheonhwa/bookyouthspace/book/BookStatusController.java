package me.cheonhwa.bookyouthspace.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookStatusController {

    @GetMapping("/status")
    public String bookStatusView(){
        return "book/status";
    }
}
