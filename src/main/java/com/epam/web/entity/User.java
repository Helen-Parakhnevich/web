package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User extends Entity {

    public static final String TABLE = "user";

    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String LOGIN = "login";
    public static final String IS_ADMIN = "is_admin";
    public static final String IS_BLOCKED = "is_blocked";
    public static final String PASSWORD = "password";

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Boolean isAdmin;
    private Boolean isBlocked;

    public User(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(Long id, String firstName, String lastName, String login, boolean isAdmin, boolean isBlocked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, login, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
