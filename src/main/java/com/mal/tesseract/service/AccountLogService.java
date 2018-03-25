package com.mal.tesseract.service;

import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.model.LogType;

import java.util.List;

public interface AccountLogService {

    AccountLog save(AccountLog accountLog);
    AccountLog save(LogType logType, String description);
    AccountLog saveRequestLog(String message);
    List<AccountLog> findAll();
}
