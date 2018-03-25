package com.mal.tesseract.facade;

import com.mal.tesseract.facade.mapper.AccountLogMapper;
import com.mal.tesseract.model.dto.AccountLogDto;
import com.mal.tesseract.service.AccountLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountLogFacadeImpl implements AccountLogFacade {

    private final AccountLogService accountLogService;
    private final AccountLogMapper accountLogMapper;

    @Override
    public List<AccountLogDto> findAll() {
        return accountLogMapper.accountLogsToAccountLogDtos(accountLogService.findAll());
    }
}
