package com.mal.tesseract.facade.mapper;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.model.Role;
import com.mal.tesseract.model.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

abstract class AccountMapperDecorator implements AccountMapper {

    private AccountMapper accountMapper;

    @Autowired
    public void init(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto accountToAccountDto(Account account) {
        AccountDto accountDto = accountMapper.accountToAccountDto(account);
        accountDto.setRoles(account.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return accountDto;
    }
}
