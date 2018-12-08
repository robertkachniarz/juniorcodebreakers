package org.juniorcodebreakers;

import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.model.user.BikeUser;
import org.juniorcodebreakers.login.BikeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private BikeUserRepository userRepository;

    public static void main(String[] args) {SpringApplication.run(Main.class, args);}

    @Override
    public void run(String... args) throws Exception {
//      userRepository.save(new BikeUser("testowy", "123"));
        //System.out.println(userRepository.findByLogin("testowy"));

        BikeUser bikeUser = new BikeUser("janusz","123", "jaki@g-mail.com", Role.ADMIN);
        userRepository.save(bikeUser);
}
}
