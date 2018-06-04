package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.period.PeriodComparator;
import com.mp.privatewallet.wallet.perodicity.ExecutionDaysComparator;
import com.mp.privatewallet.wallet.flows.ImpactStrategy;
import java.time.LocalDate;
import java.util.List;

public class ExecutionDaysCalculatorEngine implements ExecutionDaysCalculator {

    private ImpactStrategy cashFlow;
    private ExecutionDaysComparator executionDaysComparator;

    public ExecutionDaysCalculatorEngine(final ImpactStrategy cashFlow) {
        this.cashFlow = cashFlow;
        this.executionDaysComparator = cashFlow.getPeriodicity().getComparator();
    }

    @Override
    public List<LocalDate> getExecutionDaysForShorterPeriod(Comparable period) {
        Comparable updatedPeriod = PeriodComparator.getCommonPartOfPeriods(cashFlow.getPeriod(), period);
        return executionDaysComparator.getMatchingDays(cashFlow.getExecutionDays(), updatedPeriod);
    }

    public List<LocalDate> getExecutionDays() {
        return executionDaysComparator.getMatchingDays(cashFlow.getExecutionDays(), cashFlow.getPeriod());
    }


}
