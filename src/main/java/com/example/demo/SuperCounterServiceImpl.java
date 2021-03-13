package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// bude se to reloadovat podle session (kdyby tam byl singleton tak count je pro vsechny pristupy)
public class SuperCounterServiceImpl implements CounterService {

    private Integer counter = 0;

    @Override
    public void add() {
        this.counter++;
    }

    @Override
    public Integer getCounter() {
        return counter;
    }
}

