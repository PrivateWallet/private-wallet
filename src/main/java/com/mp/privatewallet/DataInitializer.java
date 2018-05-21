package com.mp.privatewallet;

import com.mp.privatewallet.account.entity.Account;
import com.mp.privatewallet.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @EventListener
    public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
        createInitialData();
        System.out.println("Data Initialized!");
    }

    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent event) {
        dropInitialData();
        System.out.println("Data Deleted!");
    }

    private void createInitialData() {
        accountRepository.save(new Account("Mietek"));
        accountRepository.save(new Account("Zdzisiek"));
        accountRepository.save(new Account("Zenek"));
        accountRepository.save(new Account("Włodek"));
        accountRepository.save(new Account("Jerzy"));
        accountRepository.save(new Account("Bogdan"));


    }

    private void dropInitialData() {
        accountRepository.deleteAll();
    }
}
