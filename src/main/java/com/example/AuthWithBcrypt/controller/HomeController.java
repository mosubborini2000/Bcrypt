package com.example.AuthWithBcrypt.controller;

import com.example.AuthWithBcrypt.models.SitePost;
import com.example.AuthWithBcrypt.models.SiteUser;
import com.example.AuthWithBcrypt.repo.SiteRepo;
import com.example.AuthWithBcrypt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    SiteRepo siteRepo;
    @Autowired
    UserRepo userRepo;


    @GetMapping("/signDone")
    public String signDone(HttpServletRequest request, Model m) {
        HttpSession session = request.getSession();
        String username = session.getAttribute("userName").toString();
        m.addAttribute("userName", username);

        // Fetch posts associated with the logged-in user
        SiteUser siteUser = userRepo.findByUserName(username);
        if (siteUser != null) {
            List<SitePost> userPosts = siteUser.getSitePosts();
            m.addAttribute("postInfo", userPosts);
        }

        return "signDone.html";
    }

    @PostMapping("/addpost")
    public RedirectView addPost(HttpServletRequest request, String postInfo) {
        HttpSession session = request.getSession();
        String userName = session.getAttribute("userName").toString();
        SiteUser siteUser = userRepo.findByUserName(userName);

        if (siteUser != null) {
            SitePost sitePost = new SitePost(postInfo, siteUser);
            siteRepo.save(sitePost);
        }

        return new RedirectView("/signDone");
    }




}
