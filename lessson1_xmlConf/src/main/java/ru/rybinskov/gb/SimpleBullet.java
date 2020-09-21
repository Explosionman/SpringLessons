package ru.rybinskov.gb;

public class SimpleBullet implements Bullet {
    @Override
    public void processing() {
        System.out.println("Стрелял простой пулей");
    }
}
