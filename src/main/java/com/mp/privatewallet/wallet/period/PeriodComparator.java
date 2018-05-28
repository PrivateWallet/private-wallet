package com.mp.privatewallet.wallet.period;

import java.time.LocalDate;

public class PeriodComparator {

    public static Comparable getUpdatedPeriod(Comparable cashFlowPeriod, Comparable customPeriod) {
        if((customPeriod.getFrom().compareTo(cashFlowPeriod.getTo()) > 0) ||
                (cashFlowPeriod.getFrom().compareTo(customPeriod.getTo())) > 0) {
                  throw new RuntimeException("Periods don't have a common part");
        }
        LocalDate updatedFrom = (cashFlowPeriod.getFrom().compareTo(customPeriod.getFrom()) > 0)?
                cashFlowPeriod.getFrom() : customPeriod.getFrom();

        LocalDate updatedTo = (cashFlowPeriod.getTo().compareTo(customPeriod.getTo()) > 0)?
                cashFlowPeriod.getFrom() : customPeriod.getFrom();
        return new Period(updatedFrom, updatedTo);
    }

}
