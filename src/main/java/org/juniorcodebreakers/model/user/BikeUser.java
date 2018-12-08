package org.juniorcodebreakers.model.user;

import org.juniorcodebreakers.login.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bike_user")
public class BikeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String e_mail;
    private String role;


    public BikeUser() {
    }

    public BikeUser(String login, String password, String e_mail, Role role) {
        this.login = login;
        this.password = password;
        this.e_mail = e_mail;
        this.role = role.toString();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "BikeUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
