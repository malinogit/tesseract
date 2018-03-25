package com.mal.tesseract.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean enabled;

    @Column
    private Boolean accountNotExpired;

    @Column
    private Boolean credentialsNonExpired;

    @Column
    private Boolean accountNonLocked;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<AccountLog> accountLogs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Account(String username, String password, Boolean enabled, Boolean accountNotExpired, Boolean credentialsNonExpired, Boolean accountNonLocked, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNotExpired = accountNotExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.roles = roles;
    }

    public Account() {}

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", accountNotExpired=" + accountNotExpired +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", roles=" + roles.stream().map(Role::getName) +
                '}';
    }
}
