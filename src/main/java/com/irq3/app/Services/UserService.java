package com.irq3.app.Services;

import com.irq3.app.Models.Annonucement;
import com.irq3.app.Models.RegisterAnnonucement;
import com.irq3.app.Models.User;
import com.irq3.app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public RegisterAnnonucement createUser(User user)
    {
        RegisterAnnonucement annonucement = new RegisterAnnonucement("User created", user.toString());
        if(!annonucement.getUUID().equals(null)) {
            repository.save(user);
            return new RegisterAnnonucement("User created",user.toString());
        }
        return new RegisterAnnonucement("failed","we didnt make it");
    }
    public void deleteUserById(int id)
    {
        repository.deleteById(id);
    }
    public void deleteUser(User user)
    {
        repository.delete(user);
    }
    public User updateUser(User user)
    {
        if(repository.existsById(user.getId()))
        {
           return repository.save(user);
        }
        else {
            return new User("Error", "Error");
        }
    }
    public RegisterAnnonucement login(User usr) {
        User user = repository.findByName(usr.getName());
        if (user != null)
        {
            if(user.getSurname().equals(usr.getSurname()))
            {
                return new RegisterAnnonucement("Logged", user.toString());
            }
        }
        return new RegisterAnnonucement("Problem", "Can't log in");
    }
}
