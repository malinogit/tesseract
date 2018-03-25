package com.mal.tesseract.repository;

import com.mal.tesseract.model.LogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTypeRepository extends JpaRepository<LogType, Integer> {

    LogType findByName(String name);
}
