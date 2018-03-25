package com.mal.tesseract.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AccountLogDto {

    private Long id;

    private String logType;

    private String description;

    private String account;

    private LocalDateTime created;

    private LocalDateTime updated;

    public AccountLogDto() {
    }
}
