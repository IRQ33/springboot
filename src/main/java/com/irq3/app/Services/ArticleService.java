package com.irq3.app.Services;

import com.irq3.app.Cookies.CookieManager;
import com.irq3.app.Models.DTOMessage;
import com.irq3.app.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class ArticleService {
    @Autowired
    ArticleRepository repository;
    @Autowired
    CookieManager manager;

    public ResponseEntity<?> makeMessage(DTOMessage message)
    {
        repository.save(message.build(manager));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteMessage(int i)
    {
        repository.deleteById((long) i);
    }

}
