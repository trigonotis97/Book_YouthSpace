package me.cheonhwa.bookyouthspace.status;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.BookStatusForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookStatusController {

    private final BookStatusService statusService;

    @GetMapping("/status")
    public String bookStatusView(Model model){
        model.addAttribute("statusList",statusService.getBookStatusFormList());
        return "book/status";
    }
}
