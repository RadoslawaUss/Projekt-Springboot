package com.blackbeast.booklibrary.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String username;
        private String password;
        private Boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;


    public User() {
        this.roles = new ArrayList<>();
            }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.roles = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public void addRole(Role role){
        if(role !=null)
            this.roles.add(role);


    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
