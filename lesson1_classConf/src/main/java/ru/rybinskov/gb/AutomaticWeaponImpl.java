package ru.rybinskov.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("weaponComponent")
@Scope("prototype")
public class AutomaticWeaponImpl implements AutomaticWeapon {
    private Bullet bullet;

    @Value("false")
    private boolean jammed;

    public AutomaticWeaponImpl() {
    }

    public AutomaticWeaponImpl(Bullet bullet) {
        this.bullet = bullet;
    }

    public void doShot() {
        if (jammed) {
            System.out.println("Оружие заклинило... =(");
            return;
        }
        System.out.println("Трататата");
        bullet.processing();
    }

    public Bullet getBullet() {
        return bullet;
    }

    @Autowired
    @Qualifier("bullet")
    public void setBullet(Bullet bul) {
        this.bullet = bul;
    }

    @Override
    public void jamming() {
        this.jammed = true;
    }

    @Override
    public boolean isJammed() {
        return jammed;
    }
}

