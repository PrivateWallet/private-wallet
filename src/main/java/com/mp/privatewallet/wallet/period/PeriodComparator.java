package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.PeriodComparatorException;

import java.time.LocalDate;

public class PeriodComparator {

    public static Comparable getUpdatedPeriod(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        validateCommonPartOfPeriods(cashFlowPeriod, customPeriod);
        return createUpdatedPeriod(cashFlowPeriod, customPeriod);
    }

    private static void validateCommonPartOfPeriods(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        if(!havePeriodsCommonPart(cashFlowPeriod, customPeriod)) {
            throw new PeriodComparatorException("Periods don't have a common part.");
        }
    }

    private static boolean havePeriodsCommonPart(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        return !((customPeriod.getFrom().compareTo(cashFlowPeriod.getTo()) > 0) ||
                (cashFlowPeriod.getFrom().compareTo(customPeriod.getTo())) > 0);
    }

    private static Comparable createUpdatedPeriod(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        final LocalDate updatedFrom = (cashFlowPeriod.getFrom().compareTo(customPeriod.getFrom()) > 0)?
                cashFlowPeriod.getFrom() : customPeriod.getFrom();

        final LocalDate updatedTo = (cashFlowPeriod.getTo().compareTo(customPeriod.getTo()) > 0)?
                customPeriod.getTo() : cashFlowPeriod.getTo();
        return new Period(updatedFrom, updatedTo);
    }


}
