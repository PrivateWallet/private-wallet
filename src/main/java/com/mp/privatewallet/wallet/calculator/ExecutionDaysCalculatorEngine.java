package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.period.Comparable;
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

    public List<LocalDate> getExecutionDays(final Comparable period) {
        Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlow.getPeriod(), period);
        final List<LocalDate> executionDays = new ArrayList<>();
        final int yearDifference = updatedPeriod.getTo().getYear() - updatedPeriod.getFrom().getYear();
        for (int i = updatedPeriod.getFrom().getDayOfYear(); i < updatedPeriod.getTo().getDayOfYear() + updatedPeriod.getTo().lengthOfYear() * yearDifference; i++) {
            final LocalDate calculatedDate = LocalDate.of(period.getFrom().getYear(), 1, 1).plusDays(i - 1);
            if(executionDaysComparator.isDateMatching(cashFlow.getExecutionDays(), calculatedDate)) {
                executionDays.add(calculatedDate);
            }
        }
        return executionDays;
    }

}
