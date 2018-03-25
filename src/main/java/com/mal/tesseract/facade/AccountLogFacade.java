package com.mal.tesseract.facade;

import com.mal.tesseract.model.dto.AccountLogDto;

import java.util.List;

public interface AccountLogFacade {

    List<AccountLogDto> findAll();
}
