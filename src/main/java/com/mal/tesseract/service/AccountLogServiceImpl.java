package com.mal.tesseract.service;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.model.LogType;
import com.mal.tesseract.model.constant.LogTypeConstant;
import com.mal.tesseract.repository.AccountLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountLogServiceImpl extends CommonService implements AccountLogService {

    private final AccountLogRepository accountLogRepository;
    private final LogTypeService logTypeService;
    private final AccountService accountService;

    @Override
    public AccountLog save(AccountLog accountLog) {
        return accountLogRepository.save(accountLog);
    }

    @Override
    public AccountLog save(LogType logType, String description) {
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findAnyByUsername(user.getUsername());
        return save(AccountLogFactory.createAccountLog(account, logType, description));
    }

    @Override
    public AccountLog saveRequestLog(String message) {
        return save(logTypeService.findByName(LogTypeConstant.API_CONNECTION), message);
    }

    @Override
    public List<AccountLog> findAll() {
        return accountLogRepository.findAll();
    }
}
