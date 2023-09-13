package com.example.AuthWithBcrypt.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "siteUser",cascade = CascadeType.ALL)
    List<SitePost> sitePosts;

    public List<SitePost> getSitePosts() {
        return sitePosts;
    }

    public void setSitePosts(List<SitePost> sitePosts) {
        this.sitePosts = sitePosts;
    }

    public SiteUser(String userName, String password ) {

        this.userName = userName;
        this.password = password;
    }

    public SiteUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
