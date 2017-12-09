package com.mal.tesseract.controller;

import com.mal.tesseract.facade.AccountFacade;
import com.mal.tesseract.model.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<AccountDto> getAuthen(@PathVariable String username){
        return accountFacade.findByUsername(username)
                .map(accountDto -> new ResponseEntity<>(accountDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
