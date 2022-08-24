
package com.miapp.portfolio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public  class Proyecto implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long id;
    
    private String name;
    
    private String description;
    
    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "proyecto_has_tech", 
            joinColumns = @JoinColumn(name = "proyecto_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="tech_id", nullable = false, updatable = false)
    )
    private Set<Tech> techs = new HashSet<>();

    public Proyecto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tech> getTechs() {
        return techs;
    }

    public void setTechs(Set<Tech> techs) {
        this.techs = techs;
    }

    
 
   
    

    
    
    
}
