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

    public List<LocalDate> getExecutionDaysForShorterPeriod(final Comparable period) {
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlow.getPeriod(), period);
        final List<LocalDate> calculatedDates = getCalculatedDates(updatedPeriod);
        final List<LocalDate> executionDays = new ArrayList<>();
        calculatedDates.stream().forEach(calculatedDate -> {
            if(executionDaysComparator.isDateMatching(cashFlow.getExecutionDays(), calculatedDate)) {
                executionDays.add(calculatedDate);
            }
        });
        return executionDays;
    }

    public List<LocalDate> getExecutionDays() {
        final List<LocalDate> calculatedDates = getCalculatedDates(cashFlow.getPeriod());
        final List<LocalDate> executionDays = new ArrayList<>();
        calculatedDates.stream().forEach(calculatedDate -> {
            if(executionDaysComparator.isDateMatching(cashFlow.getExecutionDays(), calculatedDate)) {
                executionDays.add(calculatedDate);
            }
        });
        return executionDays;
    }

    private List<LocalDate> getCalculatedDates(final Comparable period) {
        final List<LocalDate> calculatedDates = new ArrayList<>();
        final int yearDifference = period.getTo().getYear() - period.getFrom().getYear();
        for (int i = period.getFrom().getDayOfYear(); i < period.getTo().getDayOfYear() + period.getTo().lengthOfYear() * yearDifference; i++) {
            calculatedDates.add(LocalDate.of(period.getFrom().getYear(), 1, 1).plusDays(i - 1));
        }
        return calculatedDates;
    }

}
