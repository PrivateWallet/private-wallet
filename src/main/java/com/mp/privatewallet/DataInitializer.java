package com.mp.privatewallet;

import com.mp.privatewallet.account.collections.Account;
import com.mp.privatewallet.account.collections.AccountService;
import com.mp.privatewallet.wallet.collections.Wallet;
import com.mp.privatewallet.wallet.collections.WalletService;
import com.mp.privatewallet.wallet.flows.CashFlow;
import com.mp.privatewallet.wallet.flows.Daily;
import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.period.Period;
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
    private AccountService accountService;

    @Autowired
    private WalletService walletService;

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
        accountService.create(new Account("Mietek"));
        accountService.create(new Account("Zdzisiek"));
        accountService.create(new Account("Zenek"));
        accountService.create(new Account("Włodek"));
        accountService.create(new Account("Jerzy"));
        accountService.create(new Account("Bogdan"));

        walletService.create(createBugdetForMietek());
    }

    private void dropInitialData() {
        accountService.deleteAll();
        walletService.deleteAll();
    }

    private Wallet createBugdetForMietek() {
        Comparable period = new Period(LocalDate.now(), LocalDate.now().plusDays(10));
        CashFlow inFlowDaily = new Daily(123.4, period);
//        CashFlow inFlowAnnually = new InFlow(123.4, PeriodicityEnum.ANNUALLY);
//        CashFlow inFlowOnce = new InFlow(123.4, PeriodicityEnum.ONCE);
//
//        CashFlow outFlowDaily = new OutFlow(123.4, PeriodicityEnum.DAILY);
//        CashFlow outFlowAnnually = new OutFlow(123.4, PeriodicityEnum.ANNUALLY);
//        CashFlow outFlowOnce = new OutFlow(123.4, PeriodicityEnum.ONCE);
        Collection<CashFlow> flows = new ArrayList();

        flows.add(inFlowDaily);
//        flows.add(inFlowAnnually);
//        flows.add(inFlowOnce);
//        flows.add(outFlowDaily);
//        flows.add(outFlowAnnually);
//        flows.add(outFlowOnce);

        return new Wallet("Mietek", 1000000.00, flows);
    }
}
