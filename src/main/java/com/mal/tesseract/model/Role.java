package com.mal.tesseract.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Table
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<Account> accountCollection;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountCollection=" + accountCollection.stream().map(Account::getUsername) +
                ", privileges=" + privileges +
                '}';
    }
}
