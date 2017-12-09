package com.mal.tesseract.facade;


import com.mal.tesseract.model.dto.AccountDto;

import java.util.Optional;

public interface AccountFacade {

    Optional<AccountDto> findByUsername(String username);
}
