package ru.rybinskov.gb;

import org.springframework.stereotype.Component;

@Component("bullet")
public class SimpleBullet implements Bullet {
    @Override
    public void processing() {
        System.out.println("Стрелял простой пулей");
    }
}
