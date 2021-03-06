package com.blog.domain;

/**
 * 用户登录的类,
 * 帐号,密码等..
 */
public class UserLogin {
    private Integer id;
    private String username;
    private String password;

    public UserLogin() {
    }

    public UserLogin(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
