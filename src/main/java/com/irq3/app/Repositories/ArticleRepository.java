package com.irq3.app.Repositories;

import com.irq3.app.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Message, Long> {
    Message findArticleByHeader(String name);
}
