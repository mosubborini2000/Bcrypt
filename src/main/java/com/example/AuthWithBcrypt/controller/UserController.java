package com.example.AuthWithBcrypt.controller;

import com.example.AuthWithBcrypt.models.SiteUser;
import com.example.AuthWithBcrypt.repo.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signup.html";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/login.html";
    }

    @PostMapping("/login")
    public RedirectView logIn(HttpServletRequest request, String userName, String password) {
        SiteUser siteUser = userRepo.findByUserName(userName);
        if (siteUser == null ||!BCrypt.checkpw(password,siteUser.getPassword())) {
            return new RedirectView ("/login");
        }
        HttpSession session= request.getSession();
        session.setAttribute("userName", userName);

//        model.addAttribute("userDb", siteUser);
        return new RedirectView("/signDone");

    }

    @PostMapping("/sign-up")
    public RedirectView signUp(String userName, String password) {
//        SiteUser siteUser = new SiteUser(userName, password);
        String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt(12));
        SiteUser siteUser=new SiteUser(userName,hashedPassword);
        userRepo.save(siteUser);
        return new RedirectView("/login");

    }
    @PostMapping("/logoutWithSecret")
    public RedirectView logOutUserWithSecret(HttpServletRequest request){

        HttpSession session= request.getSession();
        session.invalidate();

        return new RedirectView("/");
    }



}
