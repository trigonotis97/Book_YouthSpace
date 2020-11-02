package me.cheonhwa.bookyouthspace.status;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookStatusController {

    private final BookStatusService statusService;

    @GetMapping("/status")
    public String bookStatusView(Model model){

        //인원수
        model.addAttribute("dayTimePartList",statusService.getWeekDayTimePart());
        //요일표시
        model.addAttribute("dayOfWeek",statusService.getDayOfThe2WeekList());

        return "book/status";
    }
}
