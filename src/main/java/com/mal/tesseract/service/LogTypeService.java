package com.mal.tesseract.service;

import com.mal.tesseract.model.LogType;

public interface LogTypeService {

    LogType findByName(String name);
}
