package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String roleType;

    // constructors
    public Role() {
    }

    public Role(String roleType) {
        this.roleType = roleType;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String roleType) {
        this.id = id;
        this.roleType = roleType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String getAuthority() {
        return getRoleType();
    }

    @Override
    public String toString() {
        return roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(roleType, role.roleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleType);
    }
}