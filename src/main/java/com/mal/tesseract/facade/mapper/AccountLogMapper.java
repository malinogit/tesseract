package com.mal.tesseract.facade.mapper;

import com.mal.tesseract.model.AccountLog;
import com.mal.tesseract.model.dto.AccountLogDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(AccountLogMapperDecorator.class)
public interface AccountLogMapper {

    @Mappings({
        @Mapping(target = "logType", ignore = true),
        @Mapping(target = "account", ignore = true)
    })
    AccountLogDto accountLogToAccountLogDto(AccountLog accountLog);

    List<AccountLogDto> accountLogsToAccountLogDtos(List<AccountLog> accountLogs);
}
