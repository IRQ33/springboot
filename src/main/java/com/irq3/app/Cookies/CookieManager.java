package com.irq3.app.Cookies;

import com.irq3.app.Models.Cookie;
import com.irq3.app.Models.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CookieManager {
    private final HashMap<Cookie, User> cookieList = new HashMap<>();

    public void add(Cookie cookie, User user)
    {
        cookieList.put(cookie,user);
    }
    public void remove(Cookie cookie)
    {
        cookieList.remove(cookie);
    }
    public User getUser(UUID uuid) {
        for (var entry : cookieList.entrySet()) {
            if (entry.getKey().getUuid().equals(uuid)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Scheduled(fixedRate = 600000)
    public void Remover() {

        var iterator = cookieList.entrySet().iterator();

        while (iterator.hasNext()) {
            var entry = iterator.next();
            Cookie cookie = entry.getKey();

            if (cookie.getTime().plusMinutes(10).isBefore(LocalDateTime.now())) {
                iterator.remove();
            }
        }
    }
}
