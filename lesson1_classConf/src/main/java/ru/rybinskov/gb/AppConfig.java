package ru.rybinskov.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.rybinskov.gb")
public class AppConfig {
    @Bean(name = "automaticWeapon")
    public AutomaticWeapon automaticWeapon(Bullet bullet) {
        return new AutomaticWeaponImpl(bullet);
    }
}
