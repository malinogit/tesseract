package com.mal.tesseract.configuration;

import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.service.AccountLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Component
@AllArgsConstructor
public class CustomCommonsRequestLoggingFilter extends CommonsRequestLoggingFilter {

    private final AccountLogService accountLogService;

    @PostConstruct
    public void onInit() {
        this.setIncludeQueryString(true);
        this.setIncludePayload(true);
        this.setMaxPayloadLength(10000);
        this.setIncludeHeaders(false);
        this.setAfterMessagePrefix("REQUEST DATA : ");
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return logger.isDebugEnabled();
    }

    /**
     * Writes a log message before the request is processed.
     */
    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logger.debug(message);

    }

    /**
     * Writes a log message after the request is processed.
     */
    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        AccountLog accountLog = accountLogService.saveRequestLog(message);
        logger.info(accountLog.getCreated().toString());
        logger.info(accountLog.getDescription());
        logger.debug(message);
    }

}
