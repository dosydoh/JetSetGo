package com.example.capstone.model;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(String name) {
        this.roleName = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return roleName;
    }


    public void setName(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return roleName;
//       return "Role{" +
//               "id=" + id +
//               ", name='" + name + '\'' +
//               '}';
    }
}




    //@Override
    //public String getAuthority() {
     //   return roleName;


