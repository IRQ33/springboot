package com.irq3.app.Services;

import com.irq3.app.Models.DTOMessage;
import com.irq3.app.Models.Message;
import com.irq3.app.Repositories.ArticleRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public void makeMessage(DTOMessage message, HttpSession session)
    {
        repository.save(message.build(session));
        new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteMessage(int i)
    {
        repository.deleteById((long) i);
    }
    public List<Message> getList()
    {
        return repository.findAll();
    }

}
