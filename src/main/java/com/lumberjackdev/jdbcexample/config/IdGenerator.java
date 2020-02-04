package com.lumberjackdev.jdbcexample.config;

import com.lumberjackdev.jdbcexample.domain.Book;
import org.springframework.context.ApplicationListener;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdGenerator implements ApplicationListener<BeforeSaveEvent> {
    @Override
    public void onApplicationEvent(BeforeSaveEvent event) {
        var entity = event.getEntity();
        if (entity instanceof Book) {
            ((Book) entity).setId(UUID.randomUUID().toString());
        }
    }
}
