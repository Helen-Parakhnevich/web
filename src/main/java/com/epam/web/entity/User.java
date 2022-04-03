package com.epam.web.entity;

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
    private boolean isAdmin;

    public User(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(Long id, String firstName, String lastName, String login, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
