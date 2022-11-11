package com.miapp.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sobre_mi")
public class AboutMe {
    @Id
    @Column(name = "persona_id")
    private Long id;
    
    @Column(name = "sobre_mi")
    private String aboutme;

    public AboutMe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public AboutMe(String aboutme) {
        this.id = 1L;
        this.aboutme = aboutme;
    }

    public AboutMe(Long id, String aboutme) {
        this.id = id;
        this.aboutme = aboutme;
    }
    
}
