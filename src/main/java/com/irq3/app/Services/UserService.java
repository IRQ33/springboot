package com.irq3.app.Services;

import com.irq3.app.Models.Cookie;
import com.irq3.app.Cookies.CookieManager;
import com.irq3.app.Models.RegisterAnnonucement;
import com.irq3.app.Models.User;
import com.irq3.app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    CookieManager manager;

    public RegisterAnnonucement createUser(User user)
    {
        repository.save(user);
        Cookie cookie = new Cookie();
        manager.add(cookie, user);
        return new RegisterAnnonucement("User created",user.toString(), cookie);
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
                Cookie cookie = new Cookie();
                manager.add(cookie, user);
                return new RegisterAnnonucement("Logged", user.toString(), cookie);
            }
        }
        return new RegisterAnnonucement("Problem", "Can't log in");
    }

    public CookieManager getManager() {
        return manager;
    }
}
