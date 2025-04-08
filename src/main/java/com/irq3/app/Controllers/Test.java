package com.irq3.app.Controllers;

import com.irq3.app.Models.Annonucement;
import com.irq3.app.Models.User;
import com.irq3.app.Service.ListofPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class Test {
    private  final  ListofPeople list;
    @Autowired
    public Test(ListofPeople list)
    {
        this.list = list;
    }


    @PostMapping("/clicked")
    public String clicked(Model model)
    {
        model.addAttribute("now", Date.valueOf(LocalDate.now()));
        return "clicked :: result2";
    }
    @GetMapping("/showUser/{id}")
    public String show(@PathVariable int id, Model model)
    {
        Optional<User> user = list.getUsers().stream().filter(user1 -> user1.getId()==id).findFirst();
        model.addAttribute("user", user.get().getName());
        return "user";
    }
}
