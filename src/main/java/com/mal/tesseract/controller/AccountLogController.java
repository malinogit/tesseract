package com.mal.tesseract.controller;

import com.mal.tesseract.facade.AccountLogFacade;
import com.mal.tesseract.model.dto.AccountLogDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "logs")
@AllArgsConstructor
public class AccountLogController {

    private final AccountLogFacade accountLogFacade;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<AccountLogDto>> findAll(){
        return Optional.of(accountLogFacade.findAll())
                .map(accountLogDto -> new ResponseEntity<>(accountLogDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
