package com.mal.tesseract.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountDto implements Serializable {

    private Integer id;
    private String username;
    private Boolean enabled;
    private Boolean accountNotExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private List<String> roles;
    public AccountDto() {}
}
