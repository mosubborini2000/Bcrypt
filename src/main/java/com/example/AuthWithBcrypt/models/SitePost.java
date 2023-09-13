package com.example.AuthWithBcrypt.models;

import javax.persistence.*;


@Entity
public class SitePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postInfo;
    @ManyToOne
    private SiteUser siteUser;

    public SitePost(String postInfo, SiteUser siteUser) {
        this.postInfo = postInfo;
        this.siteUser = siteUser;
    }

    public SitePost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }
}
