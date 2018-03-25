package com.mal.tesseract.service;

import com.mal.tesseract.model.LogType;
import com.mal.tesseract.repository.LogTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogTypeServiceImpl implements LogTypeService {

    private final LogTypeRepository logTypeRepository;

    @Override
    public LogType findByName(String name) {
        return logTypeRepository.findByName(name);
    }
}
