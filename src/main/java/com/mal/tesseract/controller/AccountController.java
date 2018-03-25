package com.mal.tesseract.controller;

import com.mal.tesseract.facade.AccountFacade;
import com.mal.tesseract.model.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @PreAuthorize("hasAuthority('BASIC_USER')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    ResponseEntity<AccountDto> findByUsername(@PathVariable String username){
        return accountFacade.findByUsername(username)
                .map(accountDto -> new ResponseEntity<>(accountDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
