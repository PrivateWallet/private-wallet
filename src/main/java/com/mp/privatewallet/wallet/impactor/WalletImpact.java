package com.mp.privatewallet.wallet.impactor;

import com.mp.privatewallet.wallet.calculator.ExecutionDaysCalculator;
import com.mp.privatewallet.wallet.calculator.ExecutionDaysCalculatorEngine;
import com.mp.privatewallet.wallet.flows.ImpactStrategy;
import com.mp.privatewallet.wallet.period.Comparable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletImpact implements Impactor {

    private final ExecutionDaysCalculator executionDaysCalculator;
    private final ImpactStrategy cashFlow;

    public WalletImpact(final ImpactStrategy cashflow, final Comparable customPeriod) {
        this.cashFlow = cashflow;
        this.executionDaysCalculator = new ExecutionDaysCalculatorEngine(cashflow, customPeriod);
    }

    @Override
    public Map<Double, List<LocalDate>> getWalletImpactList() {
        Map<Double, List<LocalDate>> walletImpact = new HashMap<>();
        List<LocalDate> executionDaysList = executionDaysCalculator.getExecutionDays();
        walletImpact.put(cashFlow.getAmount(), executionDaysList);
        return walletImpact;
    }
}
