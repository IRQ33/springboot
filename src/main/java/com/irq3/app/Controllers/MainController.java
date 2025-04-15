package com.irq3.app.Controllers;

import com.irq3.app.Models.*;
import com.irq3.app.Services.ArticleService;
import com.irq3.app.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings(value = "unused")
public class MainController {

    @Autowired
    UserService service;
    @Autowired
    ArticleService articleService;
    @GetMapping("/")
    public Annonucement header(HttpServletRequest request)
    {
        System.out.println(request.getRemoteAddr());
        return new Annonucement("Welcome on our great page", "Read the Bible!!");
    }
    @PostMapping("/register")
    public Annonucement register(@RequestBody User user, HttpSession session)
    {
        return service.createUser(user,session);
    }

    @PostMapping("/login")
    public RegisterAnnonucement login(@RequestBody User user, HttpSession session)
    {
        return service.login(user,session);
    }

    @PostMapping("/create")
    public Annonucement post(@RequestBody DTOMessage message, HttpSession session)
    {
        articleService.makeMessage(message, session);
        return new Annonucement("Made", message.build(session).toString());
    }
    @GetMapping("/articles")
    public List<Message> messageList()
    {
        return articleService.getList();
    }

}
