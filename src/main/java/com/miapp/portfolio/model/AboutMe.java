package com.miapp.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sobre_mi")
public class AboutMe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "sobre_mi")
    private String about;

    public AboutMe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String aboutme) {
        this.about = aboutme;
    }

    public AboutMe(String aboutme) {
        this.id = 1L;
        this.about = aboutme;
    }

    public AboutMe(Long id, String aboutme) {
        this.id = id;
        this.about = aboutme;
    }
    
}
