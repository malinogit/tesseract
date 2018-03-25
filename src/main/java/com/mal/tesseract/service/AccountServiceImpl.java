package com.mal.tesseract.service;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.model.constant.AccountConstant;
import com.mal.tesseract.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElse(null);
    }

    @Override
    public Account findAnyByUsername(String username) {
        return accountRepository.findFirstByUsernameIn(username, AccountConstant.NOT_REGISTERED);
    }
}
