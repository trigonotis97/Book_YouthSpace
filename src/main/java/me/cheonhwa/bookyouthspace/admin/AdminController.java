package me.cheonhwa.bookyouthspace.admin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AdminRepository adminRepository;

    @GetMapping("/login")
    public String adminLogin(){
        return "admin/login";
    }

    @GetMapping("/status")
    public String adminView(Model model){
        //이번주 예약 명단 보여주기

        
        return "admin/status";
    }

}
