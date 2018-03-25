package com.mal.tesseract.service;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.model.LogType;

class AccountLogFactory extends CommonService {

    static AccountLog createAccountLog(Account account, LogType logType, String description) {
        logger.info("SAVE: " + logType.getName() + " " + description);
        AccountLog accountLog = new AccountLog();
        accountLog.setAccount(account);
        accountLog.setLogType(logType);
        accountLog.setDescription(description);
        return accountLog;
    }
}
