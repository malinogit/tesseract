package com.mal.tesseract.facade.mapper;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.model.dto.AccountDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@DecoratedWith(AccountMapperDecorator.class)
public interface AccountMapper {

    @Mappings({
        @Mapping(target = "roles", ignore = true)
    })
    AccountDto accountToAccountDto(Account account);
}
