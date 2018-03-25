package com.mal.tesseract.service;

import com.mal.tesseract.model.Account;

public interface AccountService {

    Account findByUsername(String username);
    Account findAnyByUsername(String username);
}
