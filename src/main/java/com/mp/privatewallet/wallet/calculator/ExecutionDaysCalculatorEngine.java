package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.flows.ImpactStrategy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExecutionDaysCalculator {

    public static List<LocalDate> getExecutionDays(ImpactStrategy cashFlow, LocalDate from, LocalDate to) {
        final List<LocalDate> executionDays = new ArrayList();
        final int yearDifference = to.getYear() - from.getYear();
            for (int i = from.getDayOfYear(); i < to.getDayOfYear() + to.lengthOfYear() * yearDifference; i++) {
                final LocalDate calculatedDate = LocalDate.of(from.getYear(), 1, 1).plusDays(i - 1);
                final Integer dayToCompare = cashFlow.getComparableIntBasedOnDate(calculatedDate);

                cashFlow.getExecutionDays().stream().forEach(date -> {
                    if (dayToCompare.equals(date)) {
                        executionDays.add(calculatedDate);
                    }
                });
            }
        return executionDays;
    }

}
