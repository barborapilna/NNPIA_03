package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    private Integer counter = 0;

    @Override
    public void add(){
        this.counter++;
    }

    @Override
    public Integer getCounter() {
        return counter;
    }
}
