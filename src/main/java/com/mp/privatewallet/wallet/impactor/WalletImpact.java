package com.mp.privatewallet.wallet.impactor;

import com.mp.privatewallet.wallet.calculator.ExecutionDaysCalculator;
import com.mp.privatewallet.wallet.calculator.ExecutionDaysCalculatorEngine;
import com.mp.privatewallet.wallet.flows.ImpactStrategy;
import com.mp.privatewallet.wallet.period.Comparable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class WalletImpact implements Impactor {

    private ExecutionDaysCalculator executionDaysCalculator;

    public WalletImpact(final ImpactStrategy cashflow, final Comparable customPeriod) {
        this.executionDaysCalculator = new ExecutionDaysCalculatorEngine(cashflow, customPeriod);
    }

//    @Override
//    public Map<Double, List<LocalDate>> getWalletImpactList() {
//        return new Object();
//    }
}
