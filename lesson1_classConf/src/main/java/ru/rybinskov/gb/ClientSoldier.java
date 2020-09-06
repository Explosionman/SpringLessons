package ru.rybinskov.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientSoldier {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AutomaticWeapon automaticWeapon = context.getBean("weaponComponent", AutomaticWeapon.class);
        automaticWeapon.doShot();
        automaticWeapon.jamming();
        automaticWeapon.doShot();

        System.out.println("Получаем новое оружие");
        AutomaticWeapon newAutomaticWeapon = context.getBean("weaponComponent", AutomaticWeapon.class);
        newAutomaticWeapon.doShot();
    }
}
