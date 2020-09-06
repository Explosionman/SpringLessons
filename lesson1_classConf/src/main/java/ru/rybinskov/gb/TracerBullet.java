package ru.rybinskov.gb;

import org.springframework.stereotype.Component;

@Component("tracerBullet")
public class TracerBullet implements Bullet{
    @Override
    public void processing() {
        System.out.println("Стрелял трассирующей пулей");
    }
}
