package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.period.Period;
import com.mp.privatewallet.wallet.period.PeriodComparator;
import com.mp.privatewallet.wallet.perodicity.ExecutionDaysComparator;
import com.mp.privatewallet.wallet.flows.ImpactStrategy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExecutionDaysCalculatorEngine implements ExecutionDaysCalculator {

    private ImpactStrategy cashFlow;
    private ExecutionDaysComparator executionDaysComparator;

    public ExecutionDaysCalculatorEngine(final ImpactStrategy cashFlow) {
        this.cashFlow = cashFlow;
        this.executionDaysComparator = cashFlow.getPeriodicity().getComparator();

    }

    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        Period updatedPeriod = PeriodComparator.getUpdatedPeriod()
        final List<LocalDate> executionDays = new ArrayList<>();
        final int yearDifference = to.getYear() - from.getYear();
        for (int i = from.getDayOfYear(); i < to.getDayOfYear() + to.lengthOfYear() * yearDifference; i++) {
            final LocalDate calculatedDate = LocalDate.of(from.getYear(), 1, 1).plusDays(i - 1);
            if(executionDaysComparator.isDateMatching(cashFlow.getExecutionDays(), calculatedDate)) {
                executionDays.add(calculatedDate);
            }
        }
        return executionDays;
    }

}
