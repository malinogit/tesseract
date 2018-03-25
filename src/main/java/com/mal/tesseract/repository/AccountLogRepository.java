package com.mal.tesseract.repository;

import com.mal.tesseract.model.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountLogRepository extends JpaRepository<AccountLog, Integer> {
}
