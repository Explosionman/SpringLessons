package ru.rybinskov.gb;

public class AutomaticWeaponImpl implements AutomaticWeapon {
    private Bullet bullet;

    public AutomaticWeaponImpl() {
    }

    public AutomaticWeaponImpl(Bullet bullet) {
        this.bullet = bullet;
    }

    public void doShot() {
        System.out.println("Трататата");
        bullet.processing();
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void jamming() {
        System.out.println("Оружие заклинило... =(");
    }

    @Override
    public boolean isJammed() {
        return false;
    }
}

