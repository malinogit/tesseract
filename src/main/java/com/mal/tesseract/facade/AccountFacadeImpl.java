package com.mal.tesseract.facade;

import com.mal.tesseract.facade.mapper.AccountMapper;
import com.mal.tesseract.model.dto.AccountDto;
import com.mal.tesseract.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountFacadeImpl implements AccountFacade {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    private AccountDto accountDto;

    @Autowired
    public AccountFacadeImpl(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<AccountDto> findByUsername(String username) {
        accountDto = null;
        accountRepository.findByUsername(username).ifPresent(account ->
                accountDto = accountMapper.accountToAccountDto(account));
        return Optional.of(accountDto);
    }
}
