package com.mal.tesseract.facade.mapper;

import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.model.dto.AccountLogDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

abstract class AccountLogMapperDecorator implements AccountLogMapper {

    private AccountLogMapper accountLogMapper;

    @Autowired
    public void init(AccountLogMapper accountLogMapper) {
        this.accountLogMapper = accountLogMapper;
    }

    @Override
    public AccountLogDto accountLogToAccountLogDto(AccountLog accountLog) {
        AccountLogDto accountLogDto = accountLogMapper.accountLogToAccountLogDto(accountLog);
        accountLogDto.setLogType(accountLog.getLogType().getName());
        accountLogDto.setAccount(accountLog.getAccount().getUsername());
        return accountLogDto;
    }

    @Override
    public List<AccountLogDto> accountLogsToAccountLogDtos(List<AccountLog> accountLogs) {
        return accountLogs.stream().map(accountLogMapper::accountLogToAccountLogDto).collect(Collectors.toList());
    }
}
