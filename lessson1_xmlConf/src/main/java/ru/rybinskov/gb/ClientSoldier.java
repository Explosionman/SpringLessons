package ru.rybinskov.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientSoldier {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AutomaticWeapon automaticWeapon = context.getBean("automaticWeapon", AutomaticWeapon.class);
        automaticWeapon.doShot();

        AutomaticWeapon automaticWeaponInnerBean = context.getBean("automaticWeaponInnerBean", AutomaticWeapon.class);
        automaticWeaponInnerBean.doShot();


        AutomaticWeapon automaticWeaponConstructor = context.getBean("automaticWeaponConstructor", AutomaticWeapon.class);
        automaticWeaponConstructor.doShot();
    }
}
