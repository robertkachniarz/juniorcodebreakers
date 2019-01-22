package org.juniorcodebreakers;

import org.juniorcodebreakers.login.BikeUserRepository;
import org.juniorcodebreakers.login.Role;
import org.juniorcodebreakers.login.RoleRepository;
import org.juniorcodebreakers.model.user.BikeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.google.common.collect.Sets;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BikeUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
       Role adminRole = roleRepository.save(new Role("ADMIN"));
        Role userRole = roleRepository.save(new Role("USER"));

        // guava
        userRepository.findByLogin("uzytkownik").ifPresent(System.out::println);
        userRepository.save(new BikeUser("administrator", passwordEncoder.encode("administrator"), "administrator@wp.org", Sets.newHashSet(adminRole, userRole)));
        userRepository.save(new BikeUser("uzytkownik", passwordEncoder.encode("uzytkownik"), "uzytkownik@wp.org", Sets.newHashSet(userRole)));

        //System.out.println(userRepository.findAll().toString());

       // userRepository.save(new BikeUser("q", passwordEncoder.encode("q"), "administrator@wp.org", Sets.newHashSet()));
    }
}

