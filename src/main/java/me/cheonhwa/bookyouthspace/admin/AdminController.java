package me.cheonhwa.bookyouthspace.admin;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.VisitorRepository;
import me.cheonhwa.bookyouthspace.domain.SystemData;
import me.cheonhwa.bookyouthspace.domain.Visitor;
import me.cheonhwa.bookyouthspace.timepart.TimePartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AdminRepository adminRepository;
    private final VisitorRepository visitorRepository;

    private final TimePartService timePartService;
    private final SystemData systemData;

    @GetMapping("/login")
    public String adminLogin(){
        return "admin/login";
    }

    @GetMapping("/status")
    public String adminView(Model model, @RequestParam(required = false) String date){
        LocalDate localDate;
        if(date==null){
            localDate=LocalDate.now();
        }
        else {
            localDate= LocalDate.parse(date);
        }
        model.addAttribute("timePartList", adminService.getWeekTimePartData(localDate));
        model.addAttribute(systemData);
        model.addAttribute("dayOfWeekList",timePartService.getDayOfTwoWeekStringList());
        model.addAttribute("today",LocalDate.now());
        //페이징

        return "admin/status";
    }


    //예약자 상세정보 페이지
    @GetMapping("/{id}")
    public String visitorStatus(Model model,@PathVariable Long id)
    {
        Optional<Visitor> visitor =visitorRepository.findById(id);
        model.addAttribute(visitor);

        return "";
    }

/*
TODO: 커스텀 할수 있는것 : 일최대 예약명수

 */
}
