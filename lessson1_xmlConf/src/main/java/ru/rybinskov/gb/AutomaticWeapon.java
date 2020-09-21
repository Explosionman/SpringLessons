package ru.rybinskov.gb;

public interface AutomaticWeapon {
    void doShot();
    Bullet getBullet();
    void setBullet(Bullet bullet);
    void jamming();
    boolean isJammed();
}
