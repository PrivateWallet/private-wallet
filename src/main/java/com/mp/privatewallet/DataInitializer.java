package com.mp.privatewallet;

import com.mp.privatewallet.account.collections.Account;
import com.mp.privatewallet.account.repository.AccountRepository;
import com.mp.privatewallet.wallet.collections.*;
import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import com.mp.privatewallet.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class DataInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WalletRepository walletRepository;

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

        walletRepository.save(createBugdetForMietek());
    }

    private void dropInitialData() {
        accountRepository.deleteAll();
        walletRepository.deleteAll();
    }

    private Wallet createBugdetForMietek() {

        CashFlow inFlowDaily = new Daily(100.0, LocalDate.now(), LocalDate.of(2018, 06, 15));
//        CashFlow inFlowAnnually = new InFlow(123.4, PeriodicityEnum.ANNUALLY);
//        CashFlow inFlowOnce = new InFlow(123.4, PeriodicityEnum.ONCE);
//
//        CashFlow outFlowDaily = new OutFlow(123.4, PeriodicityEnum.DAILY);
//        CashFlow outFlowAnnually = new OutFlow(123.4, PeriodicityEnum.ANNUALLY);
//        CashFlow outFlowOnce = new OutFlow(123.4, PeriodicityEnum.ONCE);
        Collection<CashFlow> flows = new ArrayList();
//
//        flows.add(inFlowDaily);
//        flows.add(inFlowAnnually);
//        flows.add(inFlowOnce);
//        flows.add(outFlowDaily);
//        flows.add(outFlowAnnually);
        flows.add(inFlowDaily);

        return new Wallet("Mietek", 1000000.00, flows);
    }
}
