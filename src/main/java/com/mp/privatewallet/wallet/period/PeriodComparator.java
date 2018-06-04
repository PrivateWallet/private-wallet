package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.PeriodComparatorException;

import java.time.LocalDate;

public class PeriodComparator {

    public static Comparable getCommonPartOfPeriods(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        validateCommonPartOfPeriods(cashFlowPeriod, customPeriod);
        return createUpdatedPeriod(cashFlowPeriod, customPeriod);
    }

    private static void validateCommonPartOfPeriods(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        if(!havePeriodsCommonPart(cashFlowPeriod, customPeriod)) {
            throw new PeriodComparatorException("Periods don't have a common part.");
        }
    }

    private static boolean havePeriodsCommonPart(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        return !(cashFlowPeriod.getTo().isBefore(customPeriod.getFrom()) ||
                customPeriod.getTo().isBefore(cashFlowPeriod.getFrom()));
    }

    private static Comparable createUpdatedPeriod(final Comparable cashFlowPeriod, final Comparable customPeriod) {
        final LocalDate updatedFrom = cashFlowPeriod.getFrom().isAfter(customPeriod.getFrom())?
                cashFlowPeriod.getFrom() : customPeriod.getFrom();

        final LocalDate updatedTo = cashFlowPeriod.getTo().isBefore(customPeriod.getTo())?
                cashFlowPeriod.getTo() : customPeriod.getTo();
        return new Period(updatedFrom, updatedTo);
    }


}
