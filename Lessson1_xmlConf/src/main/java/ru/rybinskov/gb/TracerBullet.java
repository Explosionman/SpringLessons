package ru.rybinskov.gb;

public class TracerBullet implements Bullet{
    @Override
    public void processing() {
        System.out.println("Стрелял трассирующей пулей");
    }
}
