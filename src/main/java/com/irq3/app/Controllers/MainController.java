package com.irq3.app.Controllers;

import com.irq3.app.Models.Annonucement;
import com.irq3.app.Models.RegisterAnnonucement;
import com.irq3.app.Models.User;
import com.irq3.app.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings(value = "unused")
public class MainController {

    @Autowired
    UserService service;
    @GetMapping("/")
    public Annonucement header(HttpServletRequest request)
    {
        System.out.println(request.getRemoteAddr());
        return new Annonucement("Welcome on our great page", "Read the Bible!!");
    }
    @PostMapping("/register")
    public Annonucement register(@RequestBody User user)
    {
        return service.createUser(user);
    }

    @PostMapping("/login")
    public RegisterAnnonucement login(@RequestBody User user)
    {
        return service.login(user);
    }
}
