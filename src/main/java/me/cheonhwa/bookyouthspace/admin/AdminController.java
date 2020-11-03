package me.cheonhwa.bookyouthspace.admin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String adminView(){
        return "admin/status";
    }

}
