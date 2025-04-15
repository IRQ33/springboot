package com.irq3.app.Services;

import com.irq3.app.Models.RegisterAnnonucement;
import com.irq3.app.Models.User;
import com.irq3.app.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public RegisterAnnonucement createUser(User user, HttpSession session)
    {
        session.setAttribute("user",user);
        repository.save(user);

        return new RegisterAnnonucement("User created",user.toString(), session);
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
    public RegisterAnnonucement login(User usr, HttpSession session) {
        User user = repository.findByName(usr.getName());
        if (user != null)
        {
            if(user.getSurname().equals(usr.getSurname()))
            {
                session.setAttribute("user", user);
                return new RegisterAnnonucement("Logged", user.toString(), session);
            }
        }
        return new RegisterAnnonucement("Problem", "Can't log in");
    }

}
