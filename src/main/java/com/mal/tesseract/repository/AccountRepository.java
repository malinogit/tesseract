package com.mal.tesseract.repository;


import com.mal.tesseract.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsername(String username);
    Account findFirstByUsernameIn(String... username);
}
