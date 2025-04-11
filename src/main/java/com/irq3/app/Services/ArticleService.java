package com.irq3.app.Services;

import com.irq3.app.Cookies.CookieManager;
import com.irq3.app.Models.DTOMessage;
import com.irq3.app.Models.Message;
import com.irq3.app.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;
    @Autowired
    CookieManager manager;

    public ResponseEntity<String> makeMessage(DTOMessage message)
    {
        repository.save(message.build(manager));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteMessage(int i)
    {
        repository.deleteById((long) i);
    }
    public List<Message> getList()
    {
        return repository.findAll();
    }

    public CookieManager getManager() {
        return manager;
    }
}
