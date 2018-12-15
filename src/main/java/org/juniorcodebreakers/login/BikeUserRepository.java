package org.juniorcodebreakers.login;

import org.juniorcodebreakers.model.user.BikeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeUserRepository extends JpaRepository<BikeUser, Long> {

    Optional<BikeUser> findByLogin(String login);
}
