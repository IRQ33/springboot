package com.irq3.app.Service;

import com.irq3.app.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListofPeople {


    public List<User> getUsers()
    {
        return List.of(
                new User(0,"Sigma","Sigma"),
                new User(1,"Sigma1","Sigma1"),
                new User(2,"Sigma2","Sigma2")
        );
    }
}
