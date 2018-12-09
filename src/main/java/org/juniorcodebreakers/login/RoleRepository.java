package org.juniorcodebreakers.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("select r from Role r inner join r.users u where u.login = ?1")
    Set<Role> findRoleByLogin(String login);
}
