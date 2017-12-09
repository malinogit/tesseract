package com.mal.tesseract.init;

import com.mal.tesseract.model.Account;
import com.mal.tesseract.repository.AccountRepository;
import com.mal.tesseract.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class AccountInit implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... strings) {

        if (accountRepository.findAll().isEmpty()) {
            Account account1 = new Account("Anonymous", "password", true, true, true,
                    true, Collections.singleton(roleRepository.findByName("ANONYMOUS").orElseThrow(NoSuchElementException::new)));

            Account account2 = new Account("BasicUser", "password", true, true, true,
                    true, Collections.singleton(roleRepository.findByName("BASIC_USER").orElseThrow(NoSuchElementException::new)));

            Account account3 = new Account("GlobalAdmin", "password", true, true, true,
                    true, Collections.singleton(roleRepository.findByName("GLOBAL_ADMIN").orElseThrow(NoSuchElementException::new)));

            accountRepository.save(Arrays.asList(account1, account2, account3));
        }
    }
}

